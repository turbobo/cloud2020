package com.demo.springcloud.service.impl;

import com.demo.springcloud.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @Author Jusven
 * @Date 2020/11/24 16:27
 * ***************不是传统的增删改查业务层，不需要@Service注解，也不要dao
 */
@EnableBinding(Source.class) //定义消息的推送管道---消息生产者
public class MessageProviderImpl implements IMessageProvider
{
    @Resource
    private MessageChannel output; // 消息发送管道

    @Override
    public String send()
    {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build()); //发送消息体
        System.out.println("*****serial: "+serial);
        return null;
    }
}

