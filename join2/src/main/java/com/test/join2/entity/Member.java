package com.test.join2.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Member {
	@Id
	
	
	@Column(unique = true)
	private String mbId;

	private String mbPw;

	@Column
	private String mbName;

	@Column(unique = true)
	private String mbCompany;

	private LocalDateTime joinedAt; // 회원가입한 날짜

	private LocalDateTime lastAt; // 마지막 로그인 날짜

	@Column(length = 1000, columnDefinition = "varchar2(1000) default 'local'")
	private String profileImg; // 프로필 이미지

}
