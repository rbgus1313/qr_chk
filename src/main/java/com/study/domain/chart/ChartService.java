package com.study.domain.chart;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChartService {

    private final ChartMapper ChartMapper;

    /**
     * 시설별 사용자 사용 횟수 조회
     * @return 사용 횟수 정보 조회
     */
    public List<ChartResponse> getListByUseFlctCd() {
        return ChartMapper.getListByUseFlctCd();
    }

    /**
     * 사용자별 통계 화면 그리드 컬럼 조회(그리드에서 보여줄 컬럼 목록 조회, 시설유형)
     * @return 컬럼명 목록
     */
    public List<UseFcltVO> getUseFcltColList() {
        return ChartMapper.getUseFcltColList();
    }

    /**
     * 사용자별 사용시설 통계 목록 조회(view 테이블에서 그대로 조회함)
     * @return 사용자별 사용시설 통계 목록
     */
    public List<UseFcltVO> getUseFcltDataList(UseFcltVO params) {
        return ChartMapper.getUseFcltDataList(params);
    }
}
