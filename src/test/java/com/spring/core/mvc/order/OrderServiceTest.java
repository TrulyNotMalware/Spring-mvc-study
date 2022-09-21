package com.spring.core.mvc.order;

import com.spring.core.mvc.member.Grade;
import com.spring.core.mvc.member.Member;
import com.spring.core.mvc.member.MemberService;
import com.spring.core.mvc.member.MemberServiceImpl;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();
    @Test
    void createOrder(){
        Long memberId = 1L;
        Member member1 = new Member(memberId, "testMember", Grade.VIP);
        Member member2 = new Member(memberId, "testMember", Grade.BASIC);
        memberService.join(member1);

        Order order = orderService.createOrder(memberId,"itemA",10000);
        assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
