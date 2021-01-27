package com.inflearn.order;

import com.inflearn.discount.DiscountPolicy;
import com.inflearn.discount.FixDiscountPolicy;
import com.inflearn.member.MemberRepository;
import com.inflearn.member.MemberService;
import com.inflearn.member.MemberServiceimpl;
import com.inflearn.member.MemoryMemberRepository;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceimpl(memberRepository());
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceimpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }
}
