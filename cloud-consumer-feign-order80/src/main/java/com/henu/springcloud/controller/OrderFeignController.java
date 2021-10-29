package com.henu.springcloud.controller;

import com.henu.springcloud.entities.CommonResult;
import com.henu.springcloud.entities.Payment;
import com.henu.springcloud.service.PaymentFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderFeignController
{
    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id)
    {
        return paymentFeignService.getPaymentById(id);
    }

    //超时方法
    @GetMapping(value = "/consumer/payment/feign/timeout")
    public String paymentFeignTimeOut()
    {
        //openfeign-ribbon ,客户端一般默认等待一秒钟
        return paymentFeignService.paymentFeignTimeOut();
    }

}


