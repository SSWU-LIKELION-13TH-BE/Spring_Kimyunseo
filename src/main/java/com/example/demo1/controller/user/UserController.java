package com.example.demo1.controller.user;

import com.example.demo1.dto.user.request.UserLoginRequestDto;
import com.example.demo1.dto.user.request.UserPasswordChangeRequestDto;
import com.example.demo1.dto.user.request.UserSignupRequestDto;
import com.example.demo1.dto.user.response.UserInfoResponseDto;
import com.example.demo1.dto.user.response.UserLoginResponseDto;
import com.example.demo1.service.user.UserService;
import com.example.demo1.validation.apiPayload.code.SuccessStatus;
import com.example.demo1.validation.apiPayload.dto.ApiResponse;
import com.example.demo1.validation.test.dto.TestResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    // 응답 통일
    public ApiResponse<?> signup(@Valid @RequestBody UserSignupRequestDto requestDto) {
        userService.signup(requestDto);
        return ApiResponse.of(SuccessStatus._OK, new TestResponse("회원가입이 왼료되었습니다."));
    }

    // 로그인
    @PostMapping("/login")
    public ResponseEntity<UserLoginResponseDto> login(@RequestBody UserLoginRequestDto requestDto) {
        UserLoginResponseDto response = userService.login(requestDto);
        return ResponseEntity.ok(response);
    }

    // 사용자 정보 조회
    @GetMapping("/me")
    public ResponseEntity<?> getInfo(Authentication authentication) {

        String userId = authentication.getName();
        UserInfoResponseDto userInfo = userService.getUserInfo(userId);
        return ResponseEntity.ok(userInfo);

    }

    // 비밀번호 변경
    @PatchMapping("/password")
    public ApiResponse<?> changePassword(Authentication authentication, @Valid @RequestBody UserPasswordChangeRequestDto requestDto) {

        String userId = authentication.getName();
        userService.changePassword(userId, requestDto);

        return ApiResponse.of(SuccessStatus._OK, new TestResponse("비밀번호 변경이 완료되었습니다."));
    }
}