package com.study.domain.com.login;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {
	private String loginId;				//관리 사용자 로그인 아이디
	private String loginPw;				//관리 사용자 로그인 패스워드
}
