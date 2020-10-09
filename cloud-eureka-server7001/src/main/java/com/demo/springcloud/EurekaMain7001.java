package com.demo.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author Jusven
 * @Date 2020/9/30 10:27
 *  eureka服务端启动类  （物业公司，服务提供者都要过来注册）
 */
@SpringBootApplication
@EnableEurekaServer  //标识为sEureka服务端
public class EurekaMain7001 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaMain7001.class, args);

    }
}
