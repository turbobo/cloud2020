package com.demo.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @Author Jusven
 * @Date 2020/10/21 9:55
 */
public interface LoadBalancer {
/**
 * 获取存活的服务实例列表
 */
    ServiceInstance instances(List<ServiceInstance> serviceInstanceList);
}
