package com.example.demo1.dto.user.request;

import lombok.Data;

@Data
public class UserSignupRequestDto {
    private String userId;
    private String password;
    private String name;
    private String profileImage;
}
