package com.example.testingweb.validatingforminput.member;

import com.example.testingweb.validatingforminput.domain.Member;
import com.example.testingweb.validatingforminput.domain.Study;

import java.util.Optional;

public interface MemberService {

    Optional<Member> findById(Long memberId);

    void validate(Long memberId);

    void notify(Study newstudy);

    void notify(Member member);
}