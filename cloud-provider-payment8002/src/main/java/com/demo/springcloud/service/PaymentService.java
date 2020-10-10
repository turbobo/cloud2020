package com.demo.springcloud.service;

import com.demo.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @Author Jusven
 * @Date 2020/9/21 18:31
 */
public interface PaymentService {
    public int create(Payment payment);
    public Payment getPaymentById(@Param("id") Long id);
}
