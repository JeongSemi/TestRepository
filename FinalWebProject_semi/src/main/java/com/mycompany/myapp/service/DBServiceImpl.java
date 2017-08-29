package com.mycompany.myapp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.dao.DBDao;
import com.mycompany.myapp.dto.Member;

@Component
public class DBServiceImpl implements DBService {

	private static final Logger LOGGER = LoggerFactory.getLogger(DBServiceImpl.class);

	@Autowired
	DBDao dao;

	@Override
	public void memberJoin(Member member) {
		dao.memberInsert(member);
	}

	@Override
	public String memberCheckMid(String mid) {

		LOGGER.info("실행");

		Member member = dao.memberSelectByMid(mid);
		String result = "fail";
		if (member == null) {
			result = "success";
		}
		return result;
	}

	@Override
	public Member login(String mid, String mpassword) {

		LOGGER.info("실행");

		Member member = dao.memberSelectByMid(mid);
		
		if (member != null && mpassword.equals(member.getMpassword())) {
			LOGGER.info("if");
			return member;
		}

		return null;
	}
}
