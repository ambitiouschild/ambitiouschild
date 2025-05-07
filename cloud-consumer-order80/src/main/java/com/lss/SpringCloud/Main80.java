package com.lss.SpringCloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(exclude ={DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
public class Main80 {
    public static void main(String[] args) {


        SpringApplication.run(Main80.class,args);
        System.out.println("欢迎雒世松启动微服务消费者Main80~");
    }
}

//netstat -ano | findstr :80
//taskkill -pid 38936 -f