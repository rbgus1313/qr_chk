package com.study.domain.post;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import com.study.common.util.file.FileService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AttdService {

    private final AttdMapper attdMapper;

    private final FileService fileService;

    /**
     * 게시글 저장
     * @param params - 게시글 정보
     * @return Generated PK
     */
    @Transactional
    public Map<String, Object> attdInfoSave(final AttdVO params, MultipartFile[] files) {
    	Map<String, Object> resultMap = new HashMap<String, Object>();
    	if(!ObjectUtils.isEmpty(files[0].getOriginalFilename())) {
    		//파일 저장 후 파일그룹순번 세팅
        	params.setFileGrpSn((int)(fileService.saveFiles(files)).get("fileGrpSn"));
        	//작성 게시글 저장
        	if(ObjectUtils.isEmpty(params.getUserId())) {
        		params.setUserId(UUID.randomUUID().toString());
        	}
    	}
    	resultMap.put("regUserId", params.getUserId());
    	resultMap.put("isReg", attdMapper.attdInfoSave(params) > 0 ? "Y" : "N");
        return resultMap;
    }

    /**
     * 게시글 상세정보 조회
     * @param id - PK
     * @return 게시글 상세정보
     */
    public AttdVO findByAttdSn(final long AttdSn) {
        return attdMapper.findByAttdSn(AttdSn);
    }

    /**
     * 전에 작성한 출석체크 내용 조회
     * @param id
     * @return 전에 작성한 출석체크 내용
     */
    public AttdVO findByUserId(final String userId) {
        return attdMapper.findByUserId(userId);
    }

    /**
     * 게시글 수정
     * @param params - 게시글 정보
     * @return PK
     */
    @Transactional
    public Long updateAttdInfo(final AttdVO params) {
    	attdMapper.updateAttdInfo(params);
        return params.getAttdSn();
    }

    /**
     * 게시글 삭제
     * @param id - PK
     * @return PK
     */
    public Long deleteByAttdSn(final Long id) {
    	attdMapper.deleteByAttdSn(id);
        return id;
    }

    /**
     * 게시글 리스트 조회
     * @return 게시글 리스트
     */
    public List<AttdVO> findAllPost(AttdVO param) {
    	int curPage = param.getCurPage();
    	param.setStartRow((curPage - 1) * 10);
    	param.setEndRow(10);
        return attdMapper.findAll(param);
    }

    /**
     * 게시글 수 카운팅
     * @return 게시글 수
     */
    public int findAllCnt(AttdVO param) {
    	return attdMapper.findAllCnt(param);
    }
}
