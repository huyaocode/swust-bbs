package com.team2.pojo.cmt;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @program: CMT_WebApp
 * @description: 手机号码
 * @author: Lyon
 * @create: 2018-12-29 21:02
 **/
public class VerificationInfo implements Serializable {
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @ApiModelProperty(value = "手机号码")
    @Size(min=11, max=11,message="手机号码")
    private String phoneNumber;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @ApiModelProperty(value = "验证码")
    private String code;
}
