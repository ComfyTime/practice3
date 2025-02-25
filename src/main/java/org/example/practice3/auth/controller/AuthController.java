package org.example.practice3.auth.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.example.practice3.auth.dto.AuthLoginRequestDto;
import org.example.practice3.auth.dto.AuthLoginResponseDto;
import org.example.practice3.auth.dto.AuthSignupRequestDto;
import org.example.practice3.auth.service.AuthService;
import org.example.practice3.common.consts.Const;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public void signup(@RequestBody AuthSignupRequestDto dto) {
        authService.signup(dto);
    }

    @PostMapping("/login")
    public void login(@RequestBody AuthLoginRequestDto dto) {
        AuthLoginResponseDto result = authService.login(dto);

        HttpSession session = request.getSession(); // 신규 세션 생성, JSESSIONID 쿠키 발급
        session.setAttribute(Const.LOGIN_MEMBER, result.getMemberId()); // 서버 메모리에 세션 저장
    }

    @PostMapping("/logout")
    public void logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
    }
}
