package com.team2.service.cmt;

/**
 * @program: CMT_WebApp
 * @description: 网易云信IM
 * @author: Lyon
 * @create: 2018-12-30 13:14
 **/
public interface IMService {
     int CreateAccount(String accid,String name);
     int UpdateAccount(String accid,String token);
}
