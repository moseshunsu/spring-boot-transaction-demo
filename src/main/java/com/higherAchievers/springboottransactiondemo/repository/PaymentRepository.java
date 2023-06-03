package com.higherAchievers.springboottransactiondemo.repository;

import com.higherAchievers.springboottransactiondemo.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
