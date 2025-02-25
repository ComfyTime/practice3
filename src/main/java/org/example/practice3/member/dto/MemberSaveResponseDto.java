package org.example.practice3.member.dto;

import lombok.Getter;

@Getter
public class MemberSaveResponseDto {

    private final Long id;
    private final String email;

    public MemberSaveResponseDto(Long id, String email) {
        this.id = id;
        this.email = email;
    }
}
