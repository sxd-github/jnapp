package com.example.sxd.thanksgivinghall.login;

import com.example.sxd.thanksgivinghall.api.AppMainService;
import com.example.sxd.thanksgivinghall.api.ResultListener;
import com.example.sxd.thanksgivinghall.bean.UserInfoEntity;
import com.example.sxd.thanksgivinghall.bean.UserLoginEntity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2018/3/13.
 */

public class LoginModelImpl implements LoginContract.Model {
    String baseUrl = "";

    public LoginModelImpl(String baseUrl) {
        this.baseUrl = baseUrl;
    }
    @Override
    public void login(String userAccount, String passward, final ResultListener<UserLoginEntity> result) {
        Call<UserLoginEntity> call = AppMainService.getLoginService(baseUrl).userLogin(userAccount, passward);
        //请求开始
        result.onStart();
        //执行操作
        call.enqueue(new Callback<UserLoginEntity>() {
            @Override
            public void onResponse(Call<UserLoginEntity> call, Response<UserLoginEntity> response) {
                //请求成功
                result.onSuccess(response.body());
                //请求结束
                result.onEnd();
            }

            @Override
            public void onFailure(Call<UserLoginEntity> call, Throwable t) {
                //请求失败
                result.onFailure(t.getMessage());
                //请求结束
                result.onEnd();
            }
        });
    }

    @Override
    public void userInfo(String userAccount, final ResultListener<UserInfoEntity> result) {
        Call<UserInfoEntity> call = AppMainService.getLoginService(baseUrl).userInfo(userAccount);
        //请求开始
        result.onStart();
        //执行操作
        call.enqueue(new Callback<UserInfoEntity>() {
            @Override
            public void onResponse(Call<UserInfoEntity> call, Response<UserInfoEntity> response) {
                //请求成功
                result.onSuccess(response.body());
                //请求结束
                result.onEnd();
            }

            @Override
            public void onFailure(Call<UserInfoEntity> call, Throwable t) {
                //请求失败
                result.onFailure(t.getMessage());
                //请求结束
                result.onEnd();
            }
        });
    }
}
