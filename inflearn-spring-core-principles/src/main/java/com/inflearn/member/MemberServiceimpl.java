package com.inflearn.member;

public class MemberServiceimpl implements MemberService{

    // MemberServiceimpl이 MemberRepository(추상화)에도 의존하고 MemoryMemberRepository(구현체)에도 의존한다. DIP 위반반
   private final MemberRepository memberRepository;

    public MemberServiceimpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);

    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}