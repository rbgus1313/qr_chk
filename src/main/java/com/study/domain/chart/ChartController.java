package com.study.domain.chart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.common.dto.MessageDto;
import com.study.domain.post.AttdRequest;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ChartController {

	private final ChartService postService;

	// 사용자에게 메시지를 전달하고, 페이지를 리다이렉트 한다.
	private String showMessageAndRedirect(final MessageDto params, Model model) {
		model.addAttribute("params", params);
		return "common/messageRedirect";
	}

	// 시설별 통계 페이지 로드
	@GetMapping("/chart/useFcltCdView.do")
	public String useFcltCdView(ChartRequest params, Model model) {
		List<ChartResponse> data = postService.getListByUseFlctCd();
		model.addAttribute("data", data);
		model.addAttribute("data2", data);

		return "chart/fcltStatistics";
	}

	// 사용자별 통계 페이지 로드
	@GetMapping("/chart/userStaticsView.do")
	public String userStaticsView(UseFcltVO params, Model model) {
		//통계 그리드 컬럼 목록 조회
		List<UseFcltVO> colList = postService.getUseFcltColList();
		model.addAttribute("colList", colList);

		//실제 통계 정보 조회
		List<UseFcltVO> data = postService.getUseFcltDataList(params);
		model.addAttribute("data", data);

		return "chart/userStatistics";
	}

	// 시설별 통계 검색
	@GetMapping("/chart/userStaticsSrch.do")
	public String useFcltCdSrch(UseFcltVO params, Model model) {
		//통계 그리드 컬럼 목록 조회
		List<UseFcltVO> colList = postService.getUseFcltColList();
		model.addAttribute("colList", colList);

		//실제 통계 정보 조회
		List<UseFcltVO> data = postService.getUseFcltDataList(params);
		model.addAttribute("data", data);

		return "chart/userStatistics ::#content";
	}
}
