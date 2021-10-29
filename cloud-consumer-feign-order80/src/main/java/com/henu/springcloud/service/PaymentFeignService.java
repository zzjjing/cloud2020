package com.henu.springcloud.service;

import com.henu.springcloud.entities.CommonResult;
import com.henu.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//有哪些方法，并找的是哪个微服务名称
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")  //微服务名称
public interface PaymentFeignService
{
    //封装调用Controller层的方法
    @GetMapping(value = "/payment/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    //超时方法
    @GetMapping(value = "/payment/feign/timeout")
    String paymentFeignTimeOut();
}
