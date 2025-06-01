package com.example.demo1.validation.apiPayload.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import com.example.demo1.validation.apiPayload.code.BaseErrorCode;
import com.example.demo1.validation.apiPayload.dto.ErrorReasonDTO;

@Getter
@AllArgsConstructor
public class GeneralException extends RuntimeException {
    private final BaseErrorCode code;
    public ErrorReasonDTO getErrorReason() {
        return this.code.getReason();
    }

    public ErrorReasonDTO getErrorReasonHttpStatus() {
        return this.code.getReasonHttpStatus();
    }
}