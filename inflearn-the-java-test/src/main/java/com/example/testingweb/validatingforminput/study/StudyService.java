package com.example.testingweb.validatingforminput.study;

import com.example.testingweb.validatingforminput.domain.Member;
import com.example.testingweb.validatingforminput.domain.Study;
import com.example.testingweb.validatingforminput.member.MemberService;

import java.util.Optional;

public class StudyService {

    private final MemberService memberService;
    private final StudyRepository repository;

    public StudyService(MemberService memberService, StudyRepository repository) {
        assert memberService != null;           // assert 키워드를 사용하면, null임을 확인할 수 있다. (AssertException)
        assert repository != null;
        this.memberService = memberService;
        this.repository = repository;
    }

    public Study createNewStudy(Long memberId, Study study) {
        Optional<Member> member = memberService.findById(memberId);
        if (!member.isPresent()) {
            throw new IllegalArgumentException("Member doesn't exist for id: '" + memberId + "'");
        }
        study.setOwnerId(memberId);
        Study newstudy = repository.save(study);
        return newstudy;
    }

}