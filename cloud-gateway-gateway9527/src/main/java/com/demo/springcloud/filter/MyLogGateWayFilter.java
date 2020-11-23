package com.demo.springcloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * @Author Jusven
 * @Date 2020/11/23 11:10
 */
@Component
@Slf4j
public class MyLogGateWayFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("**********come in MyLogGateWayFilter: " + new Date());
        //获得路径参数  get/post请求都可以，只要路径带  ?uname=***
        String uname =  exchange.getRequest().getQueryParams().getFirst("uname");
        if(uname == null){
            log.info("*************用户名为Null，非法用户");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);  //不可接收
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);  //到过滤链的下一个过滤器
    }

    @Override
    public int getOrder() {   //加载过滤器顺序  数值越小，优先级越高
        return 0;
    }
}
