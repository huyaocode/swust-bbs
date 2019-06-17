package com.team2.controller.cmt;

import com.team2.controller.base.BaseController;
import com.team2.pojo.ResultResponse;
import com.team2.pojo.cmt.VerificationInfo;
import com.team2.service.cmt.VerificationCodeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @program: CMT_WebApp
 * @description: 短信验证
 * @author: Lyon
 * @create: 2018-12-29 17:57
 **/
@Api(tags = "短信验证")
@RestController
@Validated
@RequestMapping("/code")
public class VerificationCodeController extends BaseController {
    @Autowired
    public VerificationCodeService mService;

    @ApiOperation(value="发送短信验证码")
    @PostMapping(value="/sendcode")
    public ResultResponse<Integer> SendCode(@ApiParam(required=true,value="手机号码")
                                        @RequestBody VerificationInfo recode) {
        Integer statu =mService.sendCode(recode.getPhoneNumber());
        return new ResultResponse<Integer>(statu);
    }

    @ApiOperation(value="校验短信验证码")
    @PostMapping(value="/checkcode")
    public ResultResponse<Integer> CheckCode(@ApiParam(required=true,value="手机号码和验证码")
                                           @RequestBody VerificationInfo recode) {
        Integer statu =mService.checkCode(recode.getPhoneNumber(),recode.getCode());
        return new ResultResponse<Integer>(statu);
    }
}
