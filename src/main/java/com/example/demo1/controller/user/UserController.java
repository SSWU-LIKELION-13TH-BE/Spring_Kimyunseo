package com.example.demo1.controller.user;

import com.example.demo1.dto.user.request.UserLoginRequestDto;
import com.example.demo1.dto.user.request.UserPasswordChangeRequestDto;
import com.example.demo1.dto.user.request.UserSignupRequestDto;
import com.example.demo1.dto.user.response.UserLoginResponseDto;
import com.example.demo1.entity.user.User;
import com.example.demo1.repository.user.UserRepository;
import com.example.demo1.service.user.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;

    //  UserRepository도 생성자에 주입
    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
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

    // 사용자 정보 조회 API
    @GetMapping("/me")
    public ResponseEntity<UserDto> getCurrentUser(@AuthenticationPrincipal UserDetails userDetails) {
        User user = userRepository.findByUserId(userDetails.getUsername())
                .orElseThrow(() -> new RuntimeException("사용자를 찾을 수 없습니다."));
        return ResponseEntity.ok(new UserDto(user.getUserId(), user.getName(), user.getProfileImage()));
    }

    // 사용자 정보 응답 DTO
    public record UserDto(String userId, String name, String profileImage) {}

    // 비밀번호 변경 API
    @PatchMapping("/password")
    public ResponseEntity<String> changePassword(@AuthenticationPrincipal UserDetails userDetails,
                                                 @RequestBody UserPasswordChangeRequestDto dto) {
        userService.changePassword(userDetails.getUsername(), dto);
        return ResponseEntity.ok("비밀번호가 성공적으로 변경되었습니다.");
    }
}
