package com.team2.service.cmt.impl;


import com.team2.service.cmt.VerificationCodeService;
import com.team2.utils.CheckSumBuilder;

import com.team2.utils.YunxinUtil;
import org.aspectj.apache.bcel.classfile.annotation.NameValuePair;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;


/**
 * @program: CMT_WebApp
 * @description: 短信验证
 * @author: Lyon
 * @create: 2018-12-29 16:45
 **/
@Service
public class VerificationCodeServiceImpl implements VerificationCodeService {

    @Override
    public int sendCode(String phoneNum) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers=YunxinUtil.CreateHeader();
        MultiValueMap<String, String> params=new LinkedMultiValueMap<String, String>();
        /*
         * 1.如果是模板短信，请注意参数mobile是有s的，详细参数配置请参考“发送模板短信文档”
         * 2.参数格式是jsonArray的格式，例如 "['13888888888','13666666666']"
         * 3.params是根据你模板里面有几个参数，那里面的参数也是jsonArray格式
         */
        params.add("templateid",YunxinUtil.TEMPLATEID);
        params.add("mobile", phoneNum);
        params.add("codeLen", YunxinUtil.CODELEN);
        HttpEntity<MultiValueMap<String, String>> requestEntity =
                new HttpEntity<MultiValueMap<String, String>>(params, headers);
        ResponseEntity<String> response = restTemplate.exchange(YunxinUtil.SERVER_URL_SEND_CODE, HttpMethod.POST, requestEntity, String.class);
        if(response.getStatusCode().value()==200){
            try {
                JSONObject object=new JSONObject(response.getBody());
                return object.getInt("code");
            } catch (JSONException e) {
                e.printStackTrace();
                return 500;
            }
        }else{
            return response.getStatusCode().value();
        }
    }

    @Override
    public int checkCode(String phoneNum,String code) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers=YunxinUtil.CreateHeader();
        MultiValueMap<String, String> params=new LinkedMultiValueMap<String, String>();

        params.add("mobile", phoneNum);
        params.add("code", code);
        HttpEntity<MultiValueMap<String, String>> requestEntity =
                new HttpEntity<MultiValueMap<String, String>>(params, headers);
        ResponseEntity<String> response = restTemplate.exchange(YunxinUtil.SERVER_URL_CHECK_CODE, HttpMethod.POST, requestEntity, String.class);
        if(response.getStatusCode().value()==200){
            try {
                JSONObject object=new JSONObject(response.getBody());
                return object.getInt("code");
            } catch (JSONException e) {
                e.printStackTrace();
                return 413;
            }
        }else{
            return response.getStatusCode().value();
        }

    }

}
