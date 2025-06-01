package com.example.demo1.validation.test.service;

import org.springframework.stereotype.Service;
import com.example.demo1.validation.apiPayload.code.ErrorStatus;
import com.example.demo1.validation.apiPayload.exception.GeneralException;

@Service
public class TestService {
    public void checkFlag(Integer flag) {
        if (flag != null && flag == 1) {
        throw new GeneralException(ErrorStatus.TEMP_EXCEPTION);
    }
}
}
