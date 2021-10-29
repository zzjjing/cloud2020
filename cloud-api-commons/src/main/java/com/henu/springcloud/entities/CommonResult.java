package com.henu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor  //3个参数的全参构造方法
@NoArgsConstructor   //空参构造方法
//返回前端的通用实体串
public class CommonResult<T> {
    //404 not found
    private Integer code;   //类似404的数值编码
    private String message;    //前端提示
    private T data;    //泛型   比较通用    全部相关实体属性


    //data可能是null
    public CommonResult(Integer code, String message) {
        this(code, message, null);
    }

}
