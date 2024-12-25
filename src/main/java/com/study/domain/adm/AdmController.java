package com.study.domain.adm;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.domain.com.login.LoginVO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AdmController {
	private final AdmService admService;

	/**
	 * 관리자 비밀번호 변경 페이지
	 * @param model
	 * @return
	 */
	@GetMapping("/adm/admInfo.do")
	public String goAdmInfo(Model model, HttpServletRequest request) {
		LoginVO member = (LoginVO) request.getSession().getAttribute("loginMember");
		model.addAttribute("member", member);
		return "adm/admInfo";
	}

	/**
	 * 관리자 비밀번호 수정
	 * @param model
	 * @return
	 */
	@PostMapping("/adm/admUpdate.do")
	@ResponseBody
	public String admUpdate(AdmVO params, Model model, HttpServletRequest request) {
		admService.admUpdate(params, request.getSession());
		return "adm/admInfo";
	}
}
