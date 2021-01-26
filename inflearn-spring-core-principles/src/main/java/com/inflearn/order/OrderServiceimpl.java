package com.inflearn.order;

import com.inflearn.discount.DiscountPolicy;
import com.inflearn.discount.FixDiscountPolicy;
import com.inflearn.member.Member;
import com.inflearn.member.MemberRepository;
import com.inflearn.member.MemoryMemberRepository;

public class OrderServiceimpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    public final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
