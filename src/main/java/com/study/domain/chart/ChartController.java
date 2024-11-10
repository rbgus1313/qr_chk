package com.study.domain.chart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

    // 통계 페이지 로드
    @GetMapping("/chart/view.do")
    public String openPostList(Model model) {
		/*
		 * List<ChartResponse> posts = postService.findAllPost();
		 * model.addAttribute("list", posts);
		 */

    	List<Map<Object,Object>> dataPoints1 = new ArrayList<Map<Object,Object>>();
		Map<Object , Object> map1 = new HashMap<Object,Object>();
		map1.put("label", "Chrome");
		map1.put("y", 51.08);
		dataPoints1.add(map1);

		Map<Object , Object> map2 = new HashMap<Object,Object>();
		map2.put("label", "Internet Explorer");
		map2.put("y", 27.34);
		dataPoints1.add(map2);

		Map<Object , Object> map3 = new HashMap<Object,Object>();
		map3.put("label", "Firefox");
		map3.put("y", 10.62);
		dataPoints1.add(map3);

//    	model.addObject("dataPointsList", dataPoints1);

        return "post/chart";
    }
}
