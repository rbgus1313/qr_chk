package com.study.domain.chart;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ChartMapper {

    /**
     * 게시글 저장
     * @param params - 게시글 정보
     */
    int attdInfoSave(ChartRequest params);

    /**
     * 게시글 상세정보 조회
     * @param attdSn - PK
     * @return 게시글 상세정보
     */
    ChartResponse findByAttdSn(Long attdSn);


    /**
     * 전에 작성한 출석체크 내용 조회
     * @param id
     * @return 전에 작성한 출석체크 내용
     */
    ChartResponse findByUserId(String id);

    /**
     * 게시글 수정
     * @param params - 게시글 정보
     */
    void updateAttdInfo(ChartRequest params);

    /**
     * 게시글 삭제
     * @param id - PK
     */
    void deleteByAttdSn(Long id);

    /**
     * 게시글 리스트 조회
     * @return 게시글 리스트
     */
    List<ChartResponse> findAll();

    /**
     * 게시글 수 카운팅
     * @return 게시글 수
     */
    int count();

}
