package com.lss.SpringCloud.controller;


import cn.hutool.core.util.BooleanUtil;
import com.lss.SpringCloud.entities.Pay;
import com.lss.SpringCloud.entities.PayDTO;
import com.lss.SpringCloud.resp.ResultData;
import com.lss.SpringCloud.resp.ReturnCodeEnum;
import com.lss.SpringCloud.service.PayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;
import java.util.concurrent.TimeUnit;

//Controller，作为对外暴露的接口，前端来调用

@RestController
@Slf4j   //日志
@Tag(name = "可我不敌可爱支付微服务模块",description = "可我不敌可爱支付CRUD")  //swagger.v3测试的Controller注解
public class PayController {


    //调用PayService接口
    @Resource
    private PayService payService;  //调用payservices

    //定义controller的rest接口
    //定义Controller的addPay接口,调用PayService接口add
    @PostMapping(value = "/pay/add")  //先写地址，pay模块下的add
    @Operation(summary = "可我不敌可爱新增",description = "新增支付流水方法,json串做参数") //swagger.v3测试的方法注解
    public ResultData<String> addPay(@RequestBody Pay pay){//包含请求体@RequestBody  //改写为串行

        System.out.println(pay.toString());
        int add = payService.add(pay);
//        return "成功插入记录，返回值" + add;
        return ResultData.success("可我不敌可爱成功插入记录，返回值" + add);
    }


    //定义Controller的deletePay接口,调用PayService接口delete
    @DeleteMapping (value = "/pay/del/{id}")
    @Operation(summary = "可我不敌可爱删除",description = "删除支付流水方法")//swagger.v3测试的方法注解
    public ResultData<Integer> deletePay(@PathVariable("id")Integer id){  //改写为串行

        int i = payService.delete(id);
//        return payService.delete(id) ;
        return ResultData.success(i);

    }

    //定义Controller的updatePay接口,调用PayService接口update //修改是前端页面工程师，那些字段是可以修改，那些字段是不可以修改，参数应该是PayDTO
    @PutMapping(value = "/pay/update")
    @Operation(summary = "可我不敌可爱修改",description = "修改支付流水方法")//swagger.v3测试的方法注解
    public  ResultData<String> updatePay(@RequestBody PayDTO payDTO){  //controller只应该有DTO,如果要把DTO的数据往后传递，最好new一个实体类


        //故意写暂停60秒程序，故意写Bug,测试出feign的默认调用超时时间
        try {
            TimeUnit.SECONDS.sleep(62);
        }catch(InterruptedException e){
            e.printStackTrace();
        }

        //传到后台就不能是DTO,在这里相当于new了一个空的pay实体，因为往后是services层和dto层
        Pay pay = new Pay();
        //services层才允许见到实体类，dao也不要传递到后面
        BeanUtils.copyProperties(payDTO,pay);  //把payDTO拷贝到新new出来的pay，按照分层和对象的规范，尽量做的工程化，严谨化

        int i = payService.update(pay);
//        return "可我不敌可爱成功修改记录，返回值：" + update;
        return ResultData.success("可我不敌可爱成功修改记录，返回值：" + i);



    }

    //定义Controller的getById接口,调用PayService接口getByID
    @GetMapping(value = "/pay/get/{id}")
    @Operation(summary = "可我不敌可爱按照ID查流水",description = "查询支付流水方法")//swagger.v3测试的方法注解
    public ResultData<Pay> getById(@PathVariable("id") Integer id){

        if(id < 0) throw new RuntimeException("id不能为负数");

        Pay pay = payService.getByID(id);
//        return payService.getByID(id);
        return ResultData.success(pay);

    }

    //定义Controller的getById接口,调用PayService接口getByID
    @GetMapping(value = "/pay/error")
    public ResultData<Integer> getPayError(){

        Integer integer = Integer.valueOf(200);

        try
        {
            System.out.println("come is payerror test");
            int age = 10/0;
        }catch(Exception e) {
            e.printStackTrace();
            return ResultData.fail(ReturnCodeEnum.RC500.getCode(),e.getMessage());
        }
        return ResultData.success(integer);

    }

//    @GetMapping(value = "/pay/get/{id}")
//    public List<Pay> getAll(@PathVariable("id") Integer id){
//
//        return payService.getAll(id);
//
//    }


    //测试consul服务配置功能
//    @Value("${server.port}")
//    private String port;
//
//    @GetMapping(value = "/pay/get/info")
//    private String getInfoByConsul(@Value("${lss.info}") String lssInfo)
//    {
//        return "lssInfo: "+ lssInfo+"\t"+"port: "+port;
//    }

    @Value("${server.port}")
    private String port;

    @GetMapping(value = "/pay/get/info")
    public String getInfoByConsul(@Value("${lss.info}") String lssInfo)
    {
        return "可我不敌可爱Info: "+lssInfo+"\t"+"port: "+port;
    }
}
