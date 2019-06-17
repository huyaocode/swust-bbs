package com.team2.utils;

import org.springframework.http.HttpHeaders;

/**
 * @program: CMT_WebApp
 * @description: 网易云信工具类
 * @author: Lyon
 * @create: 2018-12-29 21:15
 **/
public class YunxinUtil {
    //发送验证码的请求路径URL
    public static final String SERVER_URL_SEND_CODE="https://api.netease.im/sms/sendcode.action";
    public static final String SERVER_URL_CHECK_CODE="https://api.netease.im/sms/verifycode.action";
    public static final String SERVER_URL_CREATE_ACCOUNT="https://api.netease.im/nimserver/user/create.action";
    public static final String SERVER_URL_UPDATE_ACCOUNT="https://api.netease.im/nimserver/user/update.action";
    //网易云信分配的账号，请替换你在管理后台应用下申请的Appkey
    private static final String
            APP_KEY="ddbbd00a5ee1ff4813df13655544ca9f";
    //网易云信分配的密钥，请替换你在管理后台应用下申请的appSecret
    private static final String APP_SECRET="6967dfac379c";
    //随机数
    private static final String NONCE="0123456789";
    //短信模板ID
    public static final String TEMPLATEID="9284775";

    //验证码长度，范围4～10，默认为4
    public static final String CODELEN="6";

    public static HttpHeaders CreateHeader(){
        HttpHeaders headers = new HttpHeaders();
        String curTime = String.valueOf((System.currentTimeMillis() / 1000L));
        String checkSum = CheckSumBuilder.getCheckSum(APP_SECRET, NONCE, curTime);
        headers.set("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
        headers.set("AppKey", APP_KEY);
        headers.set("Nonce", NONCE);
        headers.set("CurTime", curTime);
        headers.set("CheckSum", checkSum);

        return headers;
    }
}
