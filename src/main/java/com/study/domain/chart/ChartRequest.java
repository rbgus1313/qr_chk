package com.study.domain.chart;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChartRequest {
	private String year;				//년도
	private String month;				//월
	private String userNm;				//사용자명
	private String telNo;				//전화번호(뒤4자리)
}
