package org.example.practice3.member.controller;

import lombok.RequiredArgsConstructor;
import org.example.practice3.common.consts.Const;
import org.example.practice3.member.dto.*;
import org.example.practice3.member.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {

    public final MemberService memberService;

    @GetMapping("/members")
    public ResponseEntity<List<MemberResponseDto>> getAll() {
        return ResponseEntity.ok(memberService.findAll());
    }

    @GetMapping("/members")
    public ResponseEntity<MemberResponseDto> getOne(@PathVariable Long memberId) {
        return ResponseEntity.ok(memberService.findById(memberId));
    }

    @PutMapping("/members/")
    public void update(
            @SessionAttribute(name = Const.LOGIN_MEMBER) Long memberId,
            @RequestBody MemberUpdateRequestDto dto
    ) {
        memberService.update(memberId, dto);
    }

    @DeleteMapping("/members/{memberId}")
    public void delete(
            @SessionAttribute(name = Const.LOGIN_MEMBER) Long memberId
    ) {
        memberService.deleteById(memberId);
    }
}
