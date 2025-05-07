package com.lss.SpringCloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: 雒世松
 * @Date: 2025/4/9 23:47
 * @Param:
 * @Return:
 * @Description:
 **/

//Feign在消费端使用

@SpringBootApplication
@EnableDiscoveryClient //该注解用于向使用consul为注册中心时注册服务
@EnableFeignClients//启用feign客户端,定义服务+绑定接口，以声明式的方法优雅而简单的实现服务调用
public class MainOpenFeign81 {
    public static void main(String[] args) {
        SpringApplication.run(MainOpenFeign81.class, args);

        System.out.println("欢迎雒世松启动OpenFeign微服务消费者MainOpenFeign81~");
    }
}