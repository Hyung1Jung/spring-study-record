package com.inflearn;

import com.inflearn.member.Grade;
import com.inflearn.member.Member;
import com.inflearn.member.MemberService;
import com.inflearn.order.Order;
import com.inflearn.order.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {

//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA",20000);

        System.out.println("order = " + order.toString());
        System.out.println("order.calculatePrice(). = " + order.calculatePrice());
    }
}
