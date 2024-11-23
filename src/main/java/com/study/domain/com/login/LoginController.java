package com.study.domain.com.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
//@Slf4j
public class LoginController {

    private final LoginService loginService;

    @GetMapping("/login.do")
	public String goLogin(Model model) {
    	//log.info("log test");
		return "login/login";
	}

    @PostMapping("/login")
    @ResponseBody
	public LoginResponse tryLogin(LoginRequest params, Model model, HttpServletRequest request) {
    	// 1. 회원 정보 조회
    	LoginResponse member = loginService.getUserInfo(params);

    	// 2. 세션에 회원 정보 저장 & 세션 유지 시간 설정
        if (member != null) {
            HttpSession session = request.getSession();
            session.setAttribute("loginMember", member);
            session.setMaxInactiveInterval(60 * 30);
        }

		return member;
	}

 // 로그아웃
    @PostMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login.do";
    }
}
