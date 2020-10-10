package com.demo.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author Jusven
 * @Date 2020/9/29 13:49
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
    @LoadBalanced  //赋予RestTemplate负载均衡的能力   8001和8002端口交替使用
    public RestTemplate getRestTemplate(){
        return  new RestTemplate();
    }
}
