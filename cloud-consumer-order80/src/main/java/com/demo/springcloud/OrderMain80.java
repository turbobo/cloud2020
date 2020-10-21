package com.demo.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author Jusven
 * @Date 2020/9/29 13:24
 *
 *   微服务消费者
 *
 * 订单客户端去调支付服务，只能有控制层
 */
@SpringBootApplication
@EnableEurekaClient
//@RibbonClient(name = "CLOUD-PAYMENT-SERVICE", configuration = MySelfRule.class)   //要调用支付微服务，采用MySelfRulef负载规则
//不注明时，默认采用轮询规则
public class OrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class, args);
    }
}
