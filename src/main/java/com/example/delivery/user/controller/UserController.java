package com.example.delivery.user.controller;

import com.example.delivery.global.exception.CustomException;
import com.example.delivery.global.exception.ErrorCode;
import com.example.delivery.user.dto.request.SignupRequest;
import com.example.delivery.user.dto.response.UserResponse;
import com.example.delivery.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    @PostMapping("/users")
    public ResponseEntity<UserResponse> signup(@RequestBody @Valid SignupRequest request, BindingResult bindingResult) {

        // 1) 검증 에러: DTO 어노테이션에서 걸린 경우
        if (bindingResult.hasErrors()) {
            try {
                String key = bindingResult.getFieldErrors().get(0).getDefaultMessage();

                return toResponse(UserResponse.error(ErrorCode.valueOf(key)));
            }catch (IllegalArgumentException e) {   // message에 적은 이름이 ErrorCode에 없을 때
                return toResponse(UserResponse.error(ErrorCode.INVALID_REQUEST));
            }
        }

        // 2) 로직 에러: service에서 던진 경우
        try {
            userService.signup(request);
            return toResponse(UserResponse.success(HttpStatus.CREATED, "회원가입이 완료되었습니다."));
        } catch (CustomException e) {
            return toResponse(UserResponse.error(e.getErrorCode()));
        }

    }

    private ResponseEntity<UserResponse> toResponse(UserResponse response) {
        return ResponseEntity.status(response.getStatus()).body(response);
    }

}
