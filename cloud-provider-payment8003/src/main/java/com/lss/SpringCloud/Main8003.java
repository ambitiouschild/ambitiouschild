package com.lss.SpringCloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Author: 雒世松
 * @Date: 2025/4/9 22:52
 * @Param:
 * @Return:
 * @Description:
 **/


@SpringBootApplication
@MapperScan("com.lss.SpringCloud.mapper") //import tk.mybatis.spring.annotation.MapperScan;
@EnableDiscoveryClient //服务注册和发现，激活这个consul
@RefreshScope // 动态刷新

public class Main8003 {
    public static void main(String[] args) {


        SpringApplication.run(Main8003.class,args);
        System.out.println("欢迎雒世松启动微服务提供者Main8003~");
    }

}