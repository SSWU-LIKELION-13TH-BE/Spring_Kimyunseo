package com.example.demo1.validation.test.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class SampleRequestDto {
     @NotBlank(message = "이름은 필수입니다.")
     private String name;
}
