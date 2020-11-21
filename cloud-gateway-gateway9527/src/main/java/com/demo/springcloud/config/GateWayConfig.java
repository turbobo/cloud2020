package com.demo.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author Jusven
 * @Date 2020/10/27 16:59
 */
@Configuration
public class GateWayConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();  //相当于yml文件的routes数组
        routes.route("path_rote_atguigu",  //类似于主键id
                r -> r.path("/guonei")  //匹配路径
                        .uri("http://news.baidu.com/guonei")).build();  //转发路由
        return routes.build();
    }

}
