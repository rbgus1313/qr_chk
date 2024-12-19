package com.study.domain.chart;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.common.dto.MessageDto;

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
	@GetMapping("/chart/useFcltView.do")
	public String useFcltView(ChartVO params, Model model) {
		// 현재 날짜 구하기
		LocalDate now = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy");
		String year = now.format(formatter);

		formatter = DateTimeFormatter.ofPattern("MM");
		String month = now.format(formatter);

		params.setYear(year);
		params.setMonth(month);

		model.addAttribute("param", params);
		return "chart/fcltStatistics";
	}

	// 시설별 통계 검색
	@GetMapping("/chart/useFcltSrch.do")
	@ResponseBody
	public List<ChartVO> useFcltSrch(ChartVO params, Model model) {
		List<ChartVO> data = postService.getListByUseFlctCd(params);
		model.addAttribute("data", data);
		model.addAttribute("param", params);

		return data;
	}

	// 사용자별 통계 페이지 로드
	@GetMapping("/chart/userStaticsView.do")
	public String userStaticsView(ChartVO params, Model model) {
		//통계 그리드 컬럼 목록 조회
		List<ChartVO> colList = postService.getUseFcltColList();
		model.addAttribute("colList", colList);

		//실제 통계 정보 조회
		List<ChartVO> data = postService.getUseFcltDataList(params);
		model.addAttribute("data", data);

		//총 조회 건수
		model.addAttribute("pageCnt", (postService.getUseFcltDataCnt(params) / 10) + 1);
		model.addAttribute("param", params);

		return "chart/userStatistics";
	}

	// 사용자별 통계 검색
	@GetMapping("/chart/userStaticsSrch.do")
	public String userStaticsSrch(ChartVO params, Model model) {
		//통계 그리드 컬럼 목록 조회
		List<ChartVO> colList = postService.getUseFcltColList();
		model.addAttribute("colList", colList);

		//실제 통계 정보 조회
		List<ChartVO> data = postService.getUseFcltDataList(params);
		model.addAttribute("data", data);

		//총 조회 건수
		model.addAttribute("pageCnt", (postService.getUseFcltDataCnt(params) / 10) + 1);
		model.addAttribute("param", params);

		return "chart/userStatistics ::#content";
	}
}
