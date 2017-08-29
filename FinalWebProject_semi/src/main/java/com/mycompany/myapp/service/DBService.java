package com.mycompany.myapp.service;

import com.mycompany.myapp.dto.Member;

public interface DBService {
	
	public void memberJoin(Member member);
	public String memberCheckMid(String mid);
	public Member login(String mid, String mpassword);

}
