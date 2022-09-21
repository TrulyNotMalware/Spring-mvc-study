package com.spring.core.mvc.discount;

import com.spring.core.mvc.member.Grade;
import com.spring.core.mvc.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {
    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP 10% 할인이 적용되어야 한다.")
    void vip_o(){
        //given
            Member member = new Member(1L,"memverVIP", Grade.VIP);
        //when
            int discount = discountPolicy.discount(member,10000);

            assertThat(discount).isEqualTo(1000);
        //then
    }
    // 항상 실패 테스트도 함께 작성한다.
    @Test
    @DisplayName("VIP 가 아니면 할인이 적용되지 않는다.")
    void vip_x(){
        //given
        Member member = new Member(1L,"memver", Grade.BASIC);
        //when
        int discount = discountPolicy.discount(member,10000);

        assertThat(discount).isEqualTo(1000);
        //then
    }
}