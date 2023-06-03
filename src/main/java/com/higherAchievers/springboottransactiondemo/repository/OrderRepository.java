package com.higherAchievers.springboottransactiondemo.repository;

import com.higherAchievers.springboottransactiondemo.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
