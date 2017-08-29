package com.mycompany.myapp.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	@Autowired
	private ServletContext servletContext;

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping("/")
	public String home(HttpSession session, Model model) {

		if (session.getAttribute("mid") != null) {
			model.addAttribute("login", "success");
			return "loginhome";
		}
		model.addAttribute("login", "wait");
		return "home";
	}

	@RequestMapping("file/portfolio")
	public void download(@RequestParam String filename, HttpServletResponse response,
			@RequestHeader("User-Agent") String userAgent) throws Exception {
		// 응답 HTTP 헤더행을 추가
		// 한글이름 파일을 나타내주기 위한 코드
		String encodingFileName;
		if (userAgent.contains("MSIE") || userAgent.contains("Trident") || userAgent.contains("Edge")) {
			encodingFileName = URLEncoder.encode(filename, "UTF-8");
		} else {
			encodingFileName = new String(filename.getBytes("UTF-8"), "ISO-8859-1");
		}

		// addHeader (헤더명, 헤더값)
		response.addHeader("Content-Disposition", "attachment; filename=\"" + encodingFileName + "\"");
		// 2) 파일의 종류
		response.addHeader("Content-Type", "application/pptx");
		// 3) 파일의 크기
		String realPath = servletContext.getRealPath("/WEB-INF/upload/" + filename);
		File file = new File(realPath);
		long fileSize = file.length();
		response.addHeader("Content-Length", String.valueOf(fileSize));

		// 응답 HTTP 본문에 파일 데이터를 출력
		OutputStream os = response.getOutputStream();
		FileInputStream fis = new FileInputStream(file);
		FileCopyUtils.copy(fis, os);
		os.flush();
		fis.close();
		os.close();

	}

}
