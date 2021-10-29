package com.henu.springcloud.service;

import com.henu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {
    //读和写 ,dao相同
    public int create(Payment payment);
    public Payment getPaymentById(@Param("id") Long id);
}
