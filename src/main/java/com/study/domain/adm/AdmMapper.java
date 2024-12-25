package com.study.domain.adm;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdmMapper {

	/**
     * 관리자 정보 수정
     * @return SQL result
     */
    int admUpdate(AdmVO param);
}
