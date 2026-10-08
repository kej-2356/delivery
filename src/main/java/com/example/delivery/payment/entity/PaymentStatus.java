package com.example.delivery.payment.entity;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PaymentStatus {
    PAID("결제 완료"),
    CANCELED("결제 취소");;

    private final String description;

}
