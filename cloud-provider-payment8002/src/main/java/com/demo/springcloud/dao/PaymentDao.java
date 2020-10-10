package com.demo.springcloud.dao;

import com.demo.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author Jusven
 * @Date 2020/9/14 18:46
 * @Version 1.0
 */

//比  @Repository好
@Mapper
public interface PaymentDao {
    public int create(Payment payment);   //返回数字判断是否插入成功
    public Payment getPaymentById(@Param("id") Long id);   //@Param 注释传过来的数据名
}
