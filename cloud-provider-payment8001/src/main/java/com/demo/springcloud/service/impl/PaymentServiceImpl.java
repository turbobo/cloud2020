package com.demo.springcloud.service.impl;

import com.demo.springcloud.dao.PaymentDao;
import com.demo.springcloud.entities.Payment;
import com.demo.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author Jusven
 * @Date 2020/9/21 18:32
 */
@Service    //Service层注解  Bean对象
public class PaymentServiceImpl implements PaymentService {
    @Resource    //依赖注入，将其他用作属性注入本对象中
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
