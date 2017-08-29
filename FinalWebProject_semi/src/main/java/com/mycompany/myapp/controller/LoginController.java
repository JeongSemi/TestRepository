package com.mycompany.myapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.mycompany.myapp.dto.Member;
import com.mycompany.myapp.service.DBService;

@Controller
@SessionAttributes({ "mid", "mpassword", "mname" })
public class LoginController {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	DBService service;

	@RequestMapping(value = "/db/memberjoin", method = RequestMethod.POST)
	public String joinPost(Member member) {
		service.memberJoin(member);
		return "redirect:/";
	}

	@RequestMapping("/checkMid")
	public String checkMid(String mid, Model model) {
		String result = service.memberCheckMid(mid);
		model.addAttribute("result", result);

		return "checkMid";
	}

	@RequestMapping("/login")
	public String login(HttpServletRequest request, Model model) {

		String id = request.getParameter("mid");
		String pwd = request.getParameter("mpassword");

		Member member = service.login(id, pwd);
		// LOGGER.info(member.getMid());

		// id, pwd가 맞을 경우 실행
		if (member != null) {
			model.addAttribute("mname", member.getMname());
			model.addAttribute("mid", member.getMid());
			// 보낸다
			return "loginhome";
		} else {
			model.addAttribute("login", "fail");
			return "home";
		}

	}

	@RequestMapping("/logout")
	public String logout(SessionStatus sessionStatus) {
		// 세션에 있는 모든 정보를 삭제
		// @SessionAttributes를 사용할 경우 이용
		sessionStatus.setComplete();
		return "home";
	}

}
