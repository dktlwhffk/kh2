package com.kh.sts08.repository;

import com.kh.sts08.entity.MemberDto;

//기존 Dao의 요약판
//- 제어를 위한 상위 형태
//- 추상화 구조를 사용하는 것을 권장
//(스프링에서 제공하는 기능 적용 가능)
public interface MemberDao {
	void regist(MemberDto memberDto);
}
