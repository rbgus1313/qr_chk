package com.study.domain.adm;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.study.domain.com.login.LoginVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdmService {

    private final AdmMapper admMapper;

    /**
     * 관리자 비밀번호 수정
     * @return SQL result
     */
    public int admUpdate(AdmVO param, HttpSession session) {
    	param.setUserNo(((LoginVO)session.getAttribute("loginMember")).getUserNo());
        return admMapper.admUpdate(param);
    }
}
