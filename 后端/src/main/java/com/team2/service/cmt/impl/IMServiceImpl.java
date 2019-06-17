package com.team2.service.cmt.impl;

import com.team2.service.cmt.IMService;
import com.team2.utils.YunxinUtil;
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
 * @description: 网易云信IM
 * @author: Lyon
 * @create: 2018-12-30 13:22
 **/
@Service
public class IMServiceImpl implements IMService {
    @Override
    public int CreateAccount(String accid,String name) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers=YunxinUtil.CreateHeader();
        MultiValueMap<String, String> params=new LinkedMultiValueMap<String, String>();

        params.add("accid", accid);
        params.add("name", name);
        HttpEntity<MultiValueMap<String, String>> requestEntity =
                new HttpEntity<MultiValueMap<String, String>>(params, headers);
        ResponseEntity<String> response = restTemplate.exchange(YunxinUtil.SERVER_URL_CREATE_ACCOUNT, HttpMethod.POST, requestEntity, String.class);
        if(response.getStatusCode().value()==200){
            try {
                JSONObject object=new JSONObject(response.getBody());
                //System.out.println(response.getBody());
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
    public int UpdateAccount(String accid, String token) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers=YunxinUtil.CreateHeader();
        MultiValueMap<String, String> params=new LinkedMultiValueMap<String, String>();
        params.add("accid", accid);
        params.add("token", token);
        HttpEntity<MultiValueMap<String, String>> requestEntity =
                new HttpEntity<MultiValueMap<String, String>>(params, headers);
        ResponseEntity<String> response = restTemplate.exchange(YunxinUtil.SERVER_URL_UPDATE_ACCOUNT, HttpMethod.POST, requestEntity, String.class);
        if(response.getStatusCode().value()==200){
            try {
                JSONObject object=new JSONObject(response.getBody());
                System.out.println(response.getBody());
                return object.getInt("code");
            } catch (JSONException e) {
                e.printStackTrace();
                return 500;
            }
        }else{
            return response.getStatusCode().value();
        }
    }

}
