package com.lss.SpringCloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *@Author:雒世松
 *@Date: 2025/4/4 0:00
 *@Param:
 *@Return:
 *@Description:
 **/


@Data
@AllArgsConstructor /*全参*/
@NoArgsConstructor  /*通参*/
public class PayDTO implements Serializable {

    /**
    *@Author:雒世松
    *@Date: 2025/4/4 0:00
    *@Param:
    *@Return:
    *@Description:
    **/

    private Integer id;
    //支付流水号
    private String payNo;
    //订单流水号
    private String orderNo;
    //用户账号ID
    private Integer userId;
    //交易金额
    private BigDecimal amount;
}
