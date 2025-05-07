package com.lss.SpringCloud.resp;


import lombok.Data;
import lombok.experimental.Accessors;

//统一定义返回对象ResultData,通过ResultData.success()对返回结果进行包装后返回给前端
@Data
@Accessors(chain = true) //链式编程
public class ResultData<T> {


    private String code; //结果状态
    private String message;
    private T data;//查询成功，将值塞进T里给前台显示
    private long timestamp;//时间戳，显示查询时间


    //构造方法,没调用一次，把当前系统时间传进去，证明你啥时候调用这个接口，不会出错，这对后面调bug，修数据很有用
    public ResultData() {
        this.timestamp = System.currentTimeMillis();
    }

    //如何返回成功
    public static <T> ResultData<T> success(T data){ //泛型基本功，如果成功返回 <T> ResultData <T>

        ResultData<T> ResultData = new ResultData<>(); //我们就构建这一个对象
        ResultData.setCode(ReturnCodeEnum.RC200.getCode()); //前端传进去的数据后端接受成功了，服务器状态码200，匹配我们的RC200,后端返回给前端相当于填充了我们的code编码
        ResultData.setMessage(ReturnCodeEnum.RC200.getMessage());//前端传进去的数据后端接受成功了，服务器状态码200，匹配我们的RC200,后端返回给前端,相当于填充了我们的message编码
        ResultData.setData(data); //data就是我们传进来的
        return ResultData;
    }

    public static <T> ResultData<T> fail(String code, String message) {  //失败了不可能有数据返回
        ResultData<T> resultData = new ResultData<>();
        resultData.setCode(code);  //前端传什么，后端就返回什么
        resultData.setMessage(message);

        return resultData;
    }

}

