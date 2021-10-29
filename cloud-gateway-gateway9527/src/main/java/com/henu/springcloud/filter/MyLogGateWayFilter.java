package com.henu.springcloud.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import java.util.Date;

//容器注入
@Component //必须加，必须加，必须加
public class MyLogGateWayFilter implements GlobalFilter,Ordered
{
    //两个接口的全部方法
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain)
    {
        System.out.println("time:"+new Date()+"\t 执行了自定义的全局过滤器: "+"MyLogGateWayFilter"+"hello");

        String uname = exchange.getRequest().getQueryParams().getFirst("uname");
        //非法用户
        if (uname == null) {
            System.out.println("****用户名为null，无法登录");
            //给一个回应，设置http状态码，不被接受
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            //告诉人家错在哪
            return exchange.getResponse().setComplete();
        }
        //合法用户，过滤链，层层过滤
        return chain.filter(exchange);
    }

    //一个顺序
    @Override
    public int getOrder()
    {
        return 0;
    }
}



