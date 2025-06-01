package com.example.demo1.validation.test.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.example.demo1.validation.apiPayload.code.SuccessStatus;
import com.example.demo1.validation.apiPayload.dto.ApiResponse;
import com.example.demo1.validation.test.dto.SampleRequestDto;
import com.example.demo1.validation.test.dto.TestResponse;
import com.example.demo1.validation.test.service.TestService;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {
    private final TestService testService;

    @GetMapping("/hello")
    public ApiResponse<TestResponse> hello() {
        return ApiResponse.of(SuccessStatus._OK, new TestResponse("Hello,API!"));
    }
    @GetMapping("/error")
    public ApiResponse<TestResponse> error(@RequestParam(required = false) Integer flag) {
        testService.checkFlag(flag); // flag==1일때 예외 발생
        return ApiResponse.of(SuccessStatus._OK, new TestResponse(" 정상 처리되었습니다."));
    }
    @PostMapping("/validate")
    public ApiResponse<String> validate(@Valid @RequestBody SampleRequestDto dto) {
        return ApiResponse.of(SuccessStatus._OK, "통과되었습니다");
    }

}
