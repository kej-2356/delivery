package com.example.delivery.global.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    NAME_REQUIRED(HttpStatus.BAD_REQUEST, "아이디는 필수입니다."),
    INVALID_NAME_LENGTH(HttpStatus.BAD_REQUEST, "아이디는 4~20자여야 합니다."),
    PASSWORD_REQUIRED(HttpStatus.BAD_REQUEST, "비밀번호는 필수입니다."),
    INVALID_PASSWORD_LENGTH(HttpStatus.BAD_REQUEST, "비밀번호는 8자 이상이어야 합니다."),
    ROLE_REQUIRED(HttpStatus.BAD_REQUEST, "역할은 필수입니다."),

    DUPLICATE_NAME(HttpStatus.CONFLICT, "이미 사용 중인 아이디입니다."),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "서버 오류가 발생했습니다."),

    INVALID_REQUEST(HttpStatus.BAD_REQUEST, "잘못된 요청입니다.");
//    FORBIDDEN(HttpStatus.FORBIDDEN, "권한이 없습니다."),
//    MENU_NOT_FOUND(HttpStatus.NOT_FOUND, "존재하지 않는 메뉴입니다."),
//    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "존재하지 않는 회원입니다.");

    private final HttpStatus status;
    private final String message;

}
