package com.lss.SpringCloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.lss.SpringCloud.mapper") //import tk.mybatis.spring.annotation.MapperScan;
@EnableDiscoveryClient //服务注册和发现，激活这个consul
@RefreshScope // 动态刷新
public class Main8001 {
    public static void main(String[] args) {

        SpringApplication.run(Main8001.class,args);
        System.out.println("欢迎雒世松启动微服务提供者Main8001~  查询t_pay");
    }
}
/*
* (修改Main类名为Main8001，严格按照端口划分，就不会错，默认生成是Java的删掉，对于我们的主启动类，写一个@SpringBootApplication
mainboot,SpringApplication.run,然后注意，主启动类上面由于我们引入了一键生成，mybatis这些加强工具类，所以在主启动类上面
我们不得不引入一个主要的包的扫描工具@MapperScan,请注意他的意思就是引入一个，在主启动类上面引入这一个包，表示在这个包下面的所有mapper
那些丢的增删改查都能够扫描的到，在主启动类上一次定义全局使用就可以了，别来一个写一个mapper)
* */