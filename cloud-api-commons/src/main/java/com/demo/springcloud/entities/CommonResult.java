package com.demo.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author Jusven
 * @Date 2020/9/14 18:39
 * @Version 1.0
 *
 * 通用结果集
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private Integer code;  //404  500 ...
    private String message;   //  success  error
    private T data;  //返回的数据

    public CommonResult(Integer code, String message){
        this(code,message,null);   //data为空时
    }

}
