package com.study.domain.com.login;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginService {

	private final LoginMapper loginMapper;
    /**
     * 관리 사용자 정보 조회
     * @return 관리 사용자 정보
     */
    public LoginResponse getUserInfo(LoginRequest param) {
        return loginMapper.getUserInfo(param);
    }
}
