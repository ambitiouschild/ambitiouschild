package com.lss.SpringCloud.controller;


import com.lss.SpringCloud.entities.PayDTO;
import com.lss.SpringCloud.resp.ResultData;
import jakarta.annotation.Resource;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class OrderController {

//设定一个访问地址URl
//    public static final String PaymentSrv_URL = "http://localhost:8001";//先写死，硬编码

    //使用consul服务注册中心
    public static final String PaymentSrv_URL = "http://cloud-payment-service";//服务注册中心上的微服务名称，后面默认多个，要负载均衡

    @Resource  //由于我们配了这个RestTemplateConfig配置类，包名又是同一个，自然而然可以扫描的到，相当于这里就把值注入进来
    private RestTemplate restTemplate;


    //ResultData，response已经转为API接入
    //返回对象为响应体中数据转化成的对象，基本可以理解为Json
    @GetMapping(value = "/consumer/pay/add")  //一般我们客户端发的都是get请求，地址和支付一样，一般规范型的写法，那边是支付微服务模块，我调对象尽量跟他保持一致，就在前面加一个consumer，这样不容易报错，告诉你我是客户端调过来的
    public ResultData addOrder(PayDTO payDTO){ //我现在用美团app下了一个外卖，就是新增了一个订单

        //order传递到pay的，pay返回的ResultData，调你和你返回的都是同样一个对象的封装
        //请求地址，输入的参数，返回值
        return restTemplate.postForObject(PaymentSrv_URL + "/pay/add", payDTO, ResultData.class);

    //也就是说我客户端80发的是这个地址，实际而言他调用的是上面那个地址拼装我们的/pay/add，就是8001支付微服务，就是告诉订单，你调用的url地址是哪个
    }

    @GetMapping(value = "/consumer/pay/get/{id}")
    public ResultData getPayInfo(@PathVariable("id") Integer id){

        return restTemplate.getForObject(PaymentSrv_URL+"/pay/get/"+id,ResultData.class,id);

    }

    @GetMapping(value = "/consumer/pay/get/info")
    private String getInfoByConsul()
    {
        return restTemplate.getForObject(PaymentSrv_URL + "/pay/get/info", String.class);
    }

    //编码使用DiscoveryClient动态获取所有上线的服务列表
    @Resource
    private DiscoveryClient discoveryClient; //发现客户端
    @GetMapping("/consumer/discovery")
    public String discovery()
    {
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            System.out.println(element);
        }

        System.out.println("===================================");

        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
        for (ServiceInstance element : instances) {
            System.out.println(element.getServiceId()+"\t"+element.getHost()+"\t"+element.getPort()+"\t"+element.getUri());
        }

        return instances.get(0).getServiceId()+":"+instances.get(0).getPort();
    }//轮询算法原理
}
