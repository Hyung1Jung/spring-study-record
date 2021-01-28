package com.inflearn.order;

import com.inflearn.discount.DiscountPolicy;
import com.inflearn.discount.RateDiscountPolicy;
import com.inflearn.member.MemberRepository;
import com.inflearn.member.MemberService;
import com.inflearn.member.MemberServiceimpl;
import com.inflearn.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 설정정보, 애플리케이션이 어떻게 구성되는지 구성정보를 담당하는 설정정보
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceimpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceimpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        // return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
