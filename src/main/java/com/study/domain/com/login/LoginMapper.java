package com.study.domain.com.login;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper {

	/**
     * 관리사용자 정보 조회
     * @return 관리사용자 정보
     */
    LoginResponse getUserInfo(LoginRequest param);
}
