package com.higherAchievers.springboottransactiondemo.dto;

import com.higherAchievers.springboottransactiondemo.entity.Order;
import com.higherAchievers.springboottransactiondemo.entity.Payment;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequest {
    private Order order;
    private Payment payment;
}
