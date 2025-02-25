package org.example.practice3.auth.dto;

import lombok.Getter;

@Getter
public class AuthLoginResponseDto {

    private final Long memberId;

    public AuthLoginResponseDto(Long memberId) {
        this.memberId = memberId;
    }
}
