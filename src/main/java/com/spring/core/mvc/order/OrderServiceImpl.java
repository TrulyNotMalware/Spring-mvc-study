package com.spring.core.mvc.order;

import com.spring.core.mvc.discount.DiscountPolicy;
import com.spring.core.mvc.discount.FixDiscountPolicy;
import com.spring.core.mvc.discount.RateDiscountPolicy;
import com.spring.core.mvc.member.Member;
import com.spring.core.mvc.member.MemberRepository;
import com.spring.core.mvc.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{
    // 구현체를 빼버리면 NullPointerException..
    private final MemberRepository memberRepository = new MemoryMemberRepository();
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = this.memberRepository.findById(memberId);
        // 이 부분에서, 설계가 잘 이루어져서, 만약 추후에 할인 정책이 변경된다고 해도, 주문쪽 함수는 변경될 필요가 없음.
        // SRP 를 잘 지킨 설계를 했다.
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId,itemName,itemPrice,discountPrice);
    }
}
