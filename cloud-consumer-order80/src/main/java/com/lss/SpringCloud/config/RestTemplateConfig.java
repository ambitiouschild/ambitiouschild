package com.lss.SpringCloud.config;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.loadbalancer.core.RandomLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ReactorLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.cloud.loadbalancer.support.LoadBalancerClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;



/**
*@Author:雒世松
*@Date: 2025/4/9 21:01
*@Param:
*@Return:
*@Description: RestTemplate提供了多种便捷访问远程Http服务的方法，是一种简单便捷的访问restful服务模板类，
 * 是Spring提供的用于访问Rest服务的客户端模板工具集，说人话就是A去调用B的时候，你们俩之间要有一种沟通，要有一种斜线，要有一种桥梁
 * 就用它，两个微服务之间调用的增删改查的方法他已经封装好了
 *
 * 使用接口非常简单无脑，我订单微服务要去调用给你的支付微服务，那你支付微服务要给我提供一个Rest地址，也就是url，requestMap，也即是我们这映射的你请求传递的
 * 参数也就是DTO，最后ResponseBean.class:HTTP响应转换被转换成的对象类型，也就是响应ResultData
 * 我们图省事，我们用的是getForObject
 *
 *
 *两种方法，你要么在程序里面直接写死new RestTemplate(),得到这么个对象，然后再调用下面的方法，这个一般不这么干，因为我们基本上学过sping和springboot
 * 都是面向容器编程，面向bean，面向接口编程，所以一般我会出一个配置类
 *
 * 上面加入一个Configuration注解下面加一个bean，这样避免了每次调用都要去new一次，这样大家都可以公用同一个
 *
**/


@Configuration  //相当于开了一个配置类
@LoadBalancerClient(//负载均衡算法切换
        //下面的value值大小写一定要和consul里面的名字一样，必须一样
        value = "cloud-payment-service",configuration = RestTemplateConfig.class)  //负载均衡算法切换，我将要对哪个微服务，进行新的配置
public class RestTemplateConfig {

    //相当于给restTemplate重新赋能，配一个轮询算法
    @Bean
    @LoadBalanced //使用@LoadBalanced注解赋予RestTemplate负载均衡的能力，默认多个微服务，需要有负载均衡标签
    public RestTemplate restTemplate()
    {
        return new RestTemplate();
    }

    @Bean
    ReactorLoadBalancer<ServiceInstance> randomLoadBalancer(Environment environment,
                                                            LoadBalancerClientFactory loadBalancerClientFactory) {
        String name = environment.getProperty(LoadBalancerClientFactory.PROPERTY_NAME);

        return new RandomLoadBalancer(loadBalancerClientFactory.getLazyProvider(name, ServiceInstanceListSupplier.class), name);
    }//从轮询算法切换到随机算法
}
