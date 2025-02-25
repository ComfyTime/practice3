package org.example.practice3.member.dto;

import lombok.Getter;

@Getter
public class MemberUpdateResponseDto {

    private final Long id;
    private final String email;

    public MemberUpdateResponseDto(Long id, String email) {
        this.id = id;
        this.email = email;
    }
}
