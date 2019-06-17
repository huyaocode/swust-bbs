package com.team2.service.cmt;

/**
 * @program: CMT_WebApp
 * @description: 短信验证
 * @author: Lyon
 * @create: 2018-12-29 16:43
 **/
public interface VerificationCodeService {
    int sendCode(String phoneNum);
    int checkCode(String phonNum,String code);
}
