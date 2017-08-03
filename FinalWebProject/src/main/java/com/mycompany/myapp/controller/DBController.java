package com.mycompany.myapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.myapp.dto.Member;
import com.mycompany.myapp.service.DBService;

@Controller
public class DBController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DBController.class);
	
	@Autowired
	DBService service;


	@RequestMapping(value = "/db/memberjoin", method = RequestMethod.POST)
	public String joinPost(Member member) {
		service.memberJoin(member);
		return "redirect:/";
	}
}
