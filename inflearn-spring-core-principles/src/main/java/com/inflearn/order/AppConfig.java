package com.inflearn.order;

import com.inflearn.discount.FixDiscountPolicy;
import com.inflearn.member.MemberService;
import com.inflearn.member.MemberServiceimpl;
import com.inflearn.member.MemoryMemberRepository;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceimpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceimpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
