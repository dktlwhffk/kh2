package com.kh.sts15.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.kh.sts15.dto.MemberDto;
import com.kh.sts15.repository.MemberDao;
import com.kh.sts15.repository.MemberProfileDao;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	private MemberDao memberDao;
	@Autowired 
	private MemberProfileDao memberProfileDao;

	@Override
	public void store(@ModelAttribute MemberDto memberDto) {
		int no = memberDto.getMember_no();
		MemberDto dto = MemberDto.builder()
													.member_no(no)
													.member_id(memberDto.getMember_id())
													.member_pw(memberDto.getMember_pw())
													.member_nick(memberDto.getMember_nick())
													.build();
//		System.out.println(memberDto.toString());
		memberDao.regist(dto);
		
	}
}
