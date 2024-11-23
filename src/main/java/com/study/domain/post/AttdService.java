package com.study.domain.post;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AttdService {

    private final AttdMapper attdMapper;

    /**
     * 게시글 저장
     * @param params - 게시글 정보
     * @return Generated PK
     */
    @Transactional
    public Map<String, Object> attdInfoSave(final AttdRequest params) {
    	Map<String, Object> resultMap = new HashMap<String, Object>();
    	if(ObjectUtils.isEmpty(params.getUserId())) {
    		params.setUserId(UUID.randomUUID().toString());
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
    public AttdResponse findByAttdSn(final long AttdSn) {
        return attdMapper.findByAttdSn(AttdSn);
    }

    /**
     * 전에 작성한 출석체크 내용 조회
     * @param id
     * @return 전에 작성한 출석체크 내용
     */
    public AttdResponse findByUserId(final String userId) {
        return attdMapper.findByUserId(userId);
    }

    /**
     * 게시글 수정
     * @param params - 게시글 정보
     * @return PK
     */
    @Transactional
    public Long updateAttdInfo(final AttdRequest params) {
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
    public List<AttdResponse> findAllPost(AttdRequest param) {
        return attdMapper.findAll(param);
    }
}
