package com.nakta.springlv1.service;

import com.nakta.springlv1.dto.LoginRequestDto;
import com.nakta.springlv1.dto.SignupRequestDto;
import com.nakta.springlv1.entity.User;
import com.nakta.springlv1.jwt.JwtUtil;
import com.nakta.springlv1.repository.UserRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    private final JwtUtil jwtUtil;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    public String signup(SignupRequestDto requestDto) { //void리턴??
        String username = requestDto.getUsername();

        System.out.println("requestDto.getUsername() = " + requestDto.getUsername());
        System.out.println("requestDto.getPassword() = " + requestDto.getPassword());

        String password = passwordEncoder.encode(requestDto.getPassword());

        Optional<User> tmpUser = userRepository.findByUsername(username);
        if (tmpUser.isPresent()) {
            throw new IllegalArgumentException("중복된 아이디입니다");
        }
        User user = new User(username,password);
        userRepository.save(user);
        return "새로운 아이디 저장 성공 ㅋㅋ";

    }

    public String login(LoginRequestDto requestDto, HttpServletResponse res) {
        String username = requestDto.getUsername();
        String password = requestDto.getPassword();

        User user = userRepository.findByUsername(username).orElseThrow(
                ()-> new IllegalArgumentException("일치하는 아이디가 없습니다")
        );
        
        if (!passwordEncoder.matches(password,user.getPassword())) {
            throw new IllegalArgumentException("패스워드가 일치하지 않습니다.");
        }
        String token = jwtUtil.createToken(user.getUsername());
        jwtUtil.addJwtToCookie(token, res);
        return "로그인 성공 ㅋㅋ";

    }
}
