package com.study.common.util.file;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FileMapper {

	/**
	 * 파일그룹순번 현재 시퀀스 가져오기
	 * @return 현재 시퀀스
	 */
	int getFileGrpSeq();

    /**
     * 파일 정보 저장
     * @param params - 파일 정보
     */
    int saveFileInfo(FileVO params);

    /**
     * 파일 정보 삭제
     * @param params - 파일 정보
     */
    int deleteFileInfo(FileVO params);
}
