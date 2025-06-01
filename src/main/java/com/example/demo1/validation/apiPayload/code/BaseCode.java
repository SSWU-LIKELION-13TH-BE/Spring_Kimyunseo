package com.example.demo1.validation.apiPayload.code;

import com.example.demo1.validation.apiPayload.dto.ReasonDTO;

public interface BaseCode {
    ReasonDTO getReason();
    ReasonDTO getReasonHttpStatus();
}