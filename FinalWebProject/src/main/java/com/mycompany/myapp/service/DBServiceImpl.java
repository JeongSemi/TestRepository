package com.mycompany.myapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.dao.DBDao;
import com.mycompany.myapp.dto.Member;

@Component
public class DBServiceImpl implements DBService {
	
	@Autowired
	DBDao dao;
	
	@Override
	public void memberJoin(Member member) {
		dao.memberInsert(member);
	}
}
