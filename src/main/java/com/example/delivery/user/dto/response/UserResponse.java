package com.example.delivery.user.dto.response;

import com.example.delivery.global.exception.ErrorCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class UserResponse {
    private final int status;
    private final String code;
    private final String message;

    public UserResponse(int status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

    public static UserResponse success(HttpStatus status, String message) {
        return new UserResponse(status.value(), status.getReasonPhrase(), message);
    }

    public static UserResponse error(ErrorCode errorCode) {
        return new UserResponse(errorCode.getStatus().value(), errorCode.name(), errorCode.getMessage());
    }
}
