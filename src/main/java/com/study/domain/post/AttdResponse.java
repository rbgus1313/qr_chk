package com.study.domain.post;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class AttdResponse {
    private Long attdSn;
	private String userId;
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
