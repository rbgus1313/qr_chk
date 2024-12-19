package com.study.domain.qr;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class QrController {
	/**
	 * QR생성 화면 진입
	 * @param model
	 * @return
	 */
	@GetMapping("/qr/createQr.do")
	public String goCreateQr(Model model) {
		return "qr/createQr";
	}
}
