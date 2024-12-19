package com.study.domain.chart;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChartVO {
	private String year;				//년도
	private String month;				//월
	private String bgnYyMm;				//시작년월
	private String endYyMm;				//종료년월
	private String userNm;				//사용자명
	private String telNo;				//전화번호(뒤4자리)
	private String label;
    private long y;
    private String cnt;
    private String slctTypeCd;
	private String srchTxt;
    private String colNm;
    private String useFcltCd01;
    private String useFcltCd02;
    private String useFcltCd03;
    private String useFcltCd04;
    private String useFcltCd05;
    private String useFcltCd06;
    private String useFcltCd07;
    private int curPage = 1;
    private int startRow = 1;
    private int endRow = 10;
}
