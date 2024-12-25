package com.study.domain.com.login;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginVO {
	private String loginId;				//관리 사용자 로그인 아이디
	private String loginPw;				//관리 사용자 로그인 패스워드
	private Long attdSn;
	private String userId;
	private String userNo;
	private String regDt;
	private String userNm;
	private String telNo;
	private String sexCd;
	private String deviceTypeNm;
	private String content;
	private Boolean delYn;
	private String useFcltCd;
	private String useFcltNm;
	private LocalDateTime regDttm;     // 생성일시
    private LocalDateTime modDttm;    // 최종 수정일시
}
