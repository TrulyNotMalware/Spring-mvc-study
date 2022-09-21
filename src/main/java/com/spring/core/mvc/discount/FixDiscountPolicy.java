package com.spring.core.mvc.discount;

import com.spring.core.mvc.member.Grade;
import com.spring.core.mvc.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{

    private static int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) return discountFixAmount;
        else return 0;
    }
}
