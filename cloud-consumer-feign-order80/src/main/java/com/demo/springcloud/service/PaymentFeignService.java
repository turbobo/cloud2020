package com.demo.springcloud.service;

import com.demo.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author Jusven
 * @Date 2020/10/21 15:02
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")  //找到对应服务
public interface PaymentFeignService {

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id);

    @GetMapping(value = "/payment/feign/timeout")
    public String PaymentFeignTimeOut();
}

