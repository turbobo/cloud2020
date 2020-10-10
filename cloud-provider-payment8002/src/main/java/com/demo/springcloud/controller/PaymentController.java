package com.demo.springcloud.controller;

import com.demo.springcloud.entities.CommonResult;
import com.demo.springcloud.entities.Payment;
import com.demo.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author Jusven
 * @Date 2020/9/21 18:37
 */

/*
* 相当于@Controller+@ResponseBody两个注解的结合，
* 返回json数据不需要在方法前面加@ResponseBody注解了，但使用@RestController这个注解，
* 就不能返回jsp,html页面，视图解析器无法解析jsp,html页面*/
@RestController
@Slf4j  //日志
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    /**
     * 端口号
     * 查看负载均衡的效果
     */
    @Value("${server.port}")
    private String serverPort;

    /**
     * 服务发现 获取服务信息（找到所有client）
     */
    @Resource
    DiscoveryClient discoveryClient;

    // 前后端分离，不需要告诉前端人员具体接收什么数据
    @PostMapping(value = "/payment/create")     //post写操作
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("*********插入结果"+result);
        if(result > 0){
            return new CommonResult(200,"插入数据库成功！serverPort："+serverPort,result);
        }else {
            return new CommonResult(444,"插入数据库失败！",null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")     //get读操作
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("*********查询结果"+payment);
        if(payment != null){
            return new CommonResult(200,"查询成功！serverPort："+serverPort,payment);
        }else {
            return new CommonResult(444,"没有对应记录，查询ID"+id,null);
        }
    }

    /**
     * 服务发现
     *
     */
    @GetMapping(value = "payment/discovery")
    public Object discovery() {
        //所有服务(CLOUD-ORDER-SERVICE、CLOUD-PAYMENT-SERVICE)
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            log.info("*****element:" + element);
        }
        // 一个微服务(CLOUD-PAYMENT-SERVICE)下的全部实例(payment8002 , payment8001)
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.debug(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + instance.getUri());
        }
        return this.discoveryClient;
    }
}
