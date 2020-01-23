package com.kh.sts15.dto;

import com.kh.sts15.dto.MemberDto.MemberDtoBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class MemberProfileDto {
	private int profile_no, profile_size, member_no;
	private String profile_uploadname;
	
}
