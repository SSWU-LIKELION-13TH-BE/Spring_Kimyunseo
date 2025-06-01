package com.example.demo1.validation.apiPayload.code;

import com.example.demo1.validation.apiPayload.dto.ErrorReasonDTO;

public interface BaseErrorCode {
    ErrorReasonDTO getReason();
    ErrorReasonDTO getReasonHttpStatus();
}
