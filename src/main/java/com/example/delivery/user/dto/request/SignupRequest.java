package com.example.delivery.user.dto.request;

import com.example.delivery.user.entity.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class SignupRequest {
    @NotBlank(message = "NAME_REQUIRED")
    @Size(min = 4, max = 20,  message = "INVALID_NAME_LENGTH")
    private String name;

    @NotBlank(message = "PASSWORD_REQUIRED")
    @Size(min = 8, message = "INVALID_PASSWORD_LENGTH")
    private String password;

    @NotNull(message = "ROLE_REQUIRED")
    private Role role;


}
