package com.lss.SpringCloud.exp;


import com.lss.SpringCloud.resp.ResultData;
import com.lss.SpringCloud.resp.ReturnCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice  //底层拦截器相关知识
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)//捕捉RuntimeException
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)  //回应状态符合规定,因为我们data的标准严格按照code:message，所以我们的封装也要符合
    public ResultData<String> exception(Exception e){

    System.out.println("#####come in GlobalExceptionHandler");  //后台打印
    log.error("全局异常信息：{}",e.getMessage(),e);  //记录到日志上面

    return ResultData.fail(ReturnCodeEnum.RC500.getCode(), e.getMessage());
    }
}

//以后你在定义异常和bug的时候，HttpStatus这个枚举是最规范和标准的，是spring官网和官方的，那么他也继承了实现了HttpStatusCode这个接口定义了这个枚举