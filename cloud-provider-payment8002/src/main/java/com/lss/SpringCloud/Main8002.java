package com.lss.SpringCloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
//@MapperScan("com.lss.SpringCloud.mapper") //import tk.mybatis.spring.annotation.MapperScan;
@EntityScan(basePackages = "com.lss.SpringCloud.entities")
@EnableJpaRepositories(basePackages = "com.lss.SpringCloud.mapper")
@EnableDiscoveryClient //服务注册和发现
@RefreshScope // 动态刷新
public class Main8002 {
    public static void main(String[] args) {


        SpringApplication.run(Main8002.class,args);
        System.out.println("欢迎雒世松启动微服务提供者Main8002~");

    }
}