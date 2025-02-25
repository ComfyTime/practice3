package org.example.practice3.member.service;

import lombok.RequiredArgsConstructor;
import org.example.practice3.member.dto.MemberResponseDto;
import org.example.practice3.member.dto.MemberSaveRequestDto;
import org.example.practice3.member.dto.MemberSaveResponseDto;
import org.example.practice3.member.dto.MemberUpdateRequestDto;
import org.example.practice3.member.entity.Member;
import org.example.practice3.member.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional(readOnly = true)
    public List<MemberResponseDto> findAll() {
        List<Member> members = memberRepository.findAll();

//        List<MemberResponseDto> dtos = new ArrayList<>();
//        for (Member member : members) {
//            dtos.add(new MemberResponseDto(
//                    member.getId(),
//                    member.getEmail()
//            ));
//        }
//        return dtos;
        return members.stream().map(member -> new MemberResponseDto(member.getId(), member.getEmail())).toList();
    }

    @Transactional(readOnly = true)
    public MemberResponseDto findById(Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(
                () -> new IllegalStateException("해당 없음")
        );
        return new MemberResponseDto(member.getId(), member.getEmail());
    }

    @Transactional
    public void update(Long memberId, MemberUpdateRequestDto dto) {
        Member member = memberRepository.findById(memberId).orElseThrow(
                () -> new IllegalStateException("해당 id 없음")
        );
        member.update(dto.getEmail());
    }

    @Transactional
    public void deleteById(Long memberId) {
        memberRepository.deleteById(memberId);
    }
}
