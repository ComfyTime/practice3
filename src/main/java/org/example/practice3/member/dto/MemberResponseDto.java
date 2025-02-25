package org.example.practice3.member.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class MemberResponseDto {

    private final Long id;
    private final String email;

    public MemberResponseDto(Long id, String email) {
        this.id = id;
        this.email = email;
    }

}
