package com.example.delivery.user.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
    CUSTOMER("손님"),
    OWNER("사장");

    private final String description;
}
