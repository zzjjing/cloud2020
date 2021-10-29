package com.henu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

//面向接口编程
//收集Euraka上所有活着的机器
public interface LoadBalancer
{
    //得到List对象
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}


