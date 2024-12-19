package com.study.domain.post;

import java.io.File;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AttdVO {
    private Long attdSn;				//출석순번
	private String userId;				//사용자ID(uuid)
	private String regDt;				//등록일자
	private String userNm;				//사용자명
	private String telNo;				//전화번호(뒤4자리)
	private String sexCd;				//성별코드
	private String deviceTypeNm;		//단말기 종류
	private String content;				//내용
	private String delYn;				//삭제여부
	private String useFcltCd;			//사용시설코드
	private String useFcltNm;
	private String slctTypeCd;
	private String srchTxt;
	private int curPage = 1;
	private int startRow = 1;
	private int endRow = 10;
    private int fileGrpSn;
    private String phtoAddr;
    private LocalDateTime regDttm;     // 생성일시
    private LocalDateTime modDttm;    // 최종 수정일시
    private File imgFile;
    private String imgfileNm;
}
