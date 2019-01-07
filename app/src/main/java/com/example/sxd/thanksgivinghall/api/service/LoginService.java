package com.example.sxd.thanksgivinghall.api.service;

import com.example.sxd.thanksgivinghall.bean.UserInfoEntity;
import com.example.sxd.thanksgivinghall.bean.UserLoginEntity;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by sxd on 2018/2/2.
 */

public abstract interface LoginService {

    /**
     * 用户登录
     * @param userAccount  用户账号
     * @param password      密码
     * @return
     */
    @GET("appUser/userLogin")
    Call<UserLoginEntity> userLogin(@Query("userAccount") String userAccount, @Query("password") String password);

    /**
     * 用户信息
     * @param userAccount  用户账号
     * @return
     */
    @GET("appUser/getUserInfo")
    Call<UserInfoEntity> userInfo(@Query("userAccount") String userAccount);

}
