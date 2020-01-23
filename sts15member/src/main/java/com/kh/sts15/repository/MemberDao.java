package com.kh.sts15.repository;

import com.kh.sts15.dto.MemberDto;

public interface MemberDao {
	int getSequence();
	void regist(MemberDto memberDto);
}
