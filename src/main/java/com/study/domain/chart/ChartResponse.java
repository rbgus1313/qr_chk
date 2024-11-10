package com.study.domain.chart;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ChartResponse {
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
