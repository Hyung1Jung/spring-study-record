package com.inflearn;

import com.inflearn.member.Grade;
import com.inflearn.member.Member;
import com.inflearn.member.MemberService;
import com.inflearn.member.MemberServiceimpl;
import com.inflearn.order.Order;
import com.inflearn.order.OrderService;
import com.inflearn.order.OrderServiceimpl;

public class OrderApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceimpl();
        OrderService orderService = new OrderServiceimpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA",10000);

        System.out.println("order = " + order.toString());
        System.out.println("order.calculatePrice(). = " + order.calculatePrice());
    }
}
