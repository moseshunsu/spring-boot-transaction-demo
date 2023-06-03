package com.higherAchievers.springboottransactiondemo.service;

import com.higherAchievers.springboottransactiondemo.dto.OrderRequest;
import com.higherAchievers.springboottransactiondemo.dto.OrderResponse;

public interface OrderService {
    OrderResponse placeOrder(OrderRequest orderRequest);
}
