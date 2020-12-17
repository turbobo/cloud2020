package com.demo.springcloudAlibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Jusven
 * @Date 2020/12/16 19:54
 */
@RestController
@RefreshScope // 支持nacos的动态刷新 -- 修改配置文件后，访问会立即更新
public class ConfigClientController {
    @Value("${config.info}")   //读取nacos 8848中的配置文件
    private String configInfo;

    @GetMapping("/config/info")
    public String getConfigInfo(){
        return configInfo;
    }
}