package com.henu.springcloud.dao;

import com.henu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

//数据类型接口,跟数据库打交道
@Mapper
public interface PaymentDao {
    //读和写
    public int create(Payment payment);
    public Payment getPaymentById(@Param("id") Long id);

}
