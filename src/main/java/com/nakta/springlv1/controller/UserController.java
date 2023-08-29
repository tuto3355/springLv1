package com.nakta.springlv1.controller;

import com.nakta.springlv1.dto.LoginRequestDto;
import com.nakta.springlv1.dto.SignupRequestDto;
import com.nakta.springlv1.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user/signup")
    public String signup(@Valid @RequestBody SignupRequestDto requestDto) {
        System.out.println("requestDto = " + requestDto.getUsername());
        return userService.signup(requestDto);
    }

    @PostMapping("/user/login")
    public String login(@RequestBody LoginRequestDto requestDto, HttpServletResponse res) { // 두번쨰 매개변수 확인!!
        return userService.login(requestDto, res);
    }
}
