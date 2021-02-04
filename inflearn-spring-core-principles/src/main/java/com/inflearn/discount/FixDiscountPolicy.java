package com.inflearn.discount;

import com.inflearn.member.Grade;
import com.inflearn.member.Member;
import org.springframework.stereotype.Component;

@Component("fixDiscountPolicy")
public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        }
        return 0;
    }
}
