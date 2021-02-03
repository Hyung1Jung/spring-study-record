package com.inflearn.order;

import com.inflearn.discount.FixDiscountPolicy;
import com.inflearn.member.Grade;
import com.inflearn.member.Member;
import com.inflearn.member.MemoryMemberRepository;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class OrderServiceimplTest {

    @Test
    void  createOrder() {
        MemoryMemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(new Member(1L, "name", Grade.VIP));

        OrderServiceimpl orderService = new OrderServiceimpl(memberRepository, new FixDiscountPolicy());
        Order order = orderService.createOrder(1L, "itemA", 10000);
        assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

}