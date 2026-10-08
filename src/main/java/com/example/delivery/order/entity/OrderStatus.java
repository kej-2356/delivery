package com.example.delivery.order.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum OrderStatus {
    REQUESTED("주문 요청"),
    CANCELED("주문 취소"),
    ACCEPTED("주문 수락"),
    DELIVERED("배달 완료");

    private final String description;

}
