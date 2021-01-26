package com.inflearn;

import com.inflearn.member.Grade;
import com.inflearn.member.Member;
import com.inflearn.member.MemberService;
import com.inflearn.member.MemberServiceimpl;

public class MemberApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceimpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new Member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}
