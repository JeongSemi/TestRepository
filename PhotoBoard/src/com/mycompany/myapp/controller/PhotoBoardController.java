package com.mycompany.myapp.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mycompany.myapp.dto.PhotoBoard;
import com.mycompany.myapp.service.PhotoBoardService;

@Controller
public class PhotoBoardController {

	@Autowired
	ServletContext servletContext;
	@Autowired
	PhotoBoardService service;

	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String writeGet() {

		return "write";
	}

	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String writePost(PhotoBoard board) throws Exception { // board ->
																	// Ŀ�ǵ尴ü
		// ÷�� ���Ͽ� ���� ������ �÷������� ����
		board.setBoriginalfilename(board.getBattach().getOriginalFilename());
		board.setBfilecontent(board.getBattach().getContentType());
		String fileName = new Date().getTime() + "-" + board.getBoriginalfilename();
		board.setBsavedfilename(fileName);

		// ÷�������� ���� ���� �ý��ۿ� ����
		String realPath = servletContext.getRealPath("/WEB-INF/upload/");
		File file = new File(realPath + fileName);
		board.getBattach().transferTo(file);

		// ���񽺰�ü�� ��û ó��
		service.boardWrite(board);
		return "redirect:/";
	}

	@RequestMapping("/")
	public String list(@RequestParam(defaultValue = "1") int pageNo, Model model) {
		// �� �������� �����ϴ� �� ��
		int rowsPerPage = 10;
		// �� �׷��� �����ϴ� ������ ��
		int pagesPerGroup = 7;
		// �� �� ��
		int totalRows = service.boardTotalRows();
		// ��ü ������ ��
		int totalPageNo = totalRows / rowsPerPage + ((totalRows % rowsPerPage != 0) ? 1 : 0);
		// ��ü �׷� ��
		int totalGroupNo = totalPageNo / pagesPerGroup + ((totalPageNo % pagesPerGroup != 0) ? 1 : 0);
		// ���� �׷� ��ȣ
		int groupNo = (pageNo - 1) / pagesPerGroup + 1;
		// ���� �׷��� ���� ������ ��ȣ
		int startPageNo = (groupNo - 1) * pagesPerGroup + 1;
		// ���� �׷��� ������ ������ ��ȣ
		int endPageNo = startPageNo + pagesPerGroup - 1;
		if (groupNo == totalGroupNo) {
			endPageNo = totalPageNo;
		}

		// ���� �������� ���� ������ ��������
		List<PhotoBoard> list = service.boardListPage(pageNo, rowsPerPage);

		// View�� �Ѱ��� ������
		model.addAttribute("list", list);
		model.addAttribute("pagesPerGroup", pagesPerGroup);
		model.addAttribute("totalPageNo", totalPageNo);
		model.addAttribute("totalGroupNo", totalGroupNo);
		model.addAttribute("groupNo", groupNo);
		model.addAttribute("startPageNo", startPageNo);
		model.addAttribute("endPageNo", endPageNo);
		model.addAttribute("pageNo", pageNo);

		// View �̸� ����
		return "list";
	}

	@RequestMapping("/file")
	public void fileView(HttpServletResponse response, @RequestHeader("User-Agent") String userAgent, int bno)
			throws IOException {
		// ���� HTTP ������� �߰�
		// 1)�����̸�(�ɼ�)
		PhotoBoard board = service.getBoard(bno);
		String fileName = board.getBsavedfilename();
		String encodingFileName;
		if (userAgent.contains("MSIE") || userAgent.contains("Trident") || userAgent.contains("Edge")) {
			encodingFileName = URLEncoder.encode(fileName, "UTF-8");
		} else {
			encodingFileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
		}

		response.addHeader("Content-Disposition", "attachment; filename=\"" + encodingFileName + "\"");
		// 2)��������(�ʼ�)
		response.addHeader("Content-Type", board.getBfilecontent());
		// 3)���ϻ�����(�ɼ�)
		File file = new File(servletContext.getRealPath("/WEB-INF/upload/" + fileName));
		long fileSize = file.length();
		response.addHeader("Content-Length", String.valueOf(fileSize));

		// ���� HTTP ������ ���� �����͸� ���
		OutputStream os = response.getOutputStream();
		FileInputStream fis = new FileInputStream(file);
		FileCopyUtils.copy(fis, os);
		os.flush();
		fis.close();
		os.close();

	}

	@RequestMapping("/hit")
	public String hit(int bno) {
		PhotoBoard board = service.getBoard(bno);
		board.setBhitcount(board.getBhitcount() + 1);
		service.boardUpdateBhitCount(board);

		return "redirect:/";
	}

	@RequestMapping("/checkBpassword")
	public String checkBpassword(int bno, String bpassword, Model model) {
		String result = service.boardCheckBpassword(bno, bpassword);
		model.addAttribute("result", result);
		return "checkBpassword";
	}

	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String updateGet(int bno, Model model){
		PhotoBoard board = service.getBoard(bno);
		model.addAttribute("board", board);
		return "update";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String exam05UpdatePost(PhotoBoard board) throws Exception {
		// ÷�������� ����Ǿ����� �˻�
		if (!board.getBattach().isEmpty()) {
			board.setBoriginalfilename(board.getBattach().getOriginalFilename());
			board.setBfilecontent(board.getBattach().getContentType());
			String fileName = new Date().getTime() + "-" + board.getBoriginalfilename();
			board.setBsavedfilename(fileName);

			// ÷�������� ���� ���� �ý��ۿ� ����
			String realPath = servletContext.getRealPath("/WEB-INF/upload/");
			File file = new File(realPath + fileName);
			board.getBattach().transferTo(file);
		}
		// �Խù� ����ó��
		service.boardUpdate(board);
		return "redirect:/";
	}

	@RequestMapping("/delete")
	public String delete(int bno) {
		service.boardDelete(bno);
		return "redirect:/";
	}

}