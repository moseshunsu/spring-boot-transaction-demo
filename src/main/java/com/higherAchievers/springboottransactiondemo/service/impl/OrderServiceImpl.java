package com.higherAchievers.springboottransactiondemo.service.impl;

import com.higherAchievers.springboottransactiondemo.dto.OrderRequest;
import com.higherAchievers.springboottransactiondemo.dto.OrderResponse;
import com.higherAchievers.springboottransactiondemo.entity.Order;
import com.higherAchievers.springboottransactiondemo.entity.Payment;
import com.higherAchievers.springboottransactiondemo.exception.PaymentException;
import com.higherAchievers.springboottransactiondemo.repository.OrderRepository;
import com.higherAchievers.springboottransactiondemo.repository.PaymentRepository;
import com.higherAchievers.springboottransactiondemo.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private PaymentRepository paymentRepository;

    public OrderServiceImpl(OrderRepository orderRepository, PaymentRepository paymentRepository) {
        this.orderRepository = orderRepository;
        this.paymentRepository = paymentRepository;
    }

    @Override
    @Transactional
    public OrderResponse placeOrder(OrderRequest orderRequest) {

        Order order = orderRequest.getOrder();
        order.setStatus("IN PROGRESS");
        order.setOrderTrackingNumber(UUID.randomUUID().toString());
        orderRepository.save(order);

        Payment payment = orderRequest.getPayment();

        if (!payment.getType().equals("DEBIT")){
            throw new PaymentException("Payment card type do not support");
        }

        payment.setOrderId(order.getId());
        paymentRepository.save(payment);

        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrderTrackingNumber(order.getOrderTrackingNumber());
        orderResponse.setStatus(order.getStatus());
        orderResponse.setMessage("SUCCESS");

        return orderResponse;
    }
}
