package com.spring.core.mvc.order;

public interface OrderService {

    Order createOrder(Long memberId, String itemName, int itemPrice);
}
