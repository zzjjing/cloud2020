package com.henu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor  //3个参数的全参构造方法
@NoArgsConstructor   //空参构造方法
public class Payment implements Serializable {
    private Long id;
    private String serial;
}
