package com.mycompany.myapp.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.dto.Member;

@Component
public class DBDaoImpl implements DBDao {

	private static final Logger logger = LoggerFactory.getLogger(DBDaoImpl.class);

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public String memberInsert(Member member) {

		sqlSessionTemplate.insert("member.insert", member);
		String mid = member.getMid();

		logger.info("성공");
		return mid;
	}
	
	@Override
	public Member memberSelectByMid(String mid) {
		
		Member member = sqlSessionTemplate.selectOne("member.selectByMid", mid);
		logger.info("성공");
		
		return member;
	}
}
