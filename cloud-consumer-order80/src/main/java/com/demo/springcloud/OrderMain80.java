package com.demo.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author Jusven
 * @Date 2020/9/29 13:24
 *
 *   微服务消费者
 *
 * 订单客户端去调支付服务，只能有控制层
 */
@SpringBootApplication
public class OrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class, args);
    }
}
