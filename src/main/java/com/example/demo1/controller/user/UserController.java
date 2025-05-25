package com.example.demo1.controller.user;


import com.example.demo1.dto.user.request.UserSignupRequestDto;
import com.example.demo1.dto.user.request.UserLoginRequestDto;
import com.example.demo1.dto.user.response.UserLoginResponseDto;
import com.example.demo1.service.user.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody UserSignupRequestDto requestDto) {
        userService.signup(requestDto);
        return ResponseEntity.ok("회원가입 성공!");
    }

    @PostMapping("/login")
    public ResponseEntity<UserLoginResponseDto> login(@RequestBody UserLoginRequestDto requestDto) {
        UserLoginResponseDto response = userService.login(requestDto);
        return ResponseEntity.ok(response);
    }
}
