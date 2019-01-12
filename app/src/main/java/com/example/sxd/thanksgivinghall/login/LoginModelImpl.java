package com.example.sxd.thanksgivinghall.login;

import com.example.sxd.thanksgivinghall.api.AppMainService;
import com.example.sxd.thanksgivinghall.api.ResultListener;
import com.example.sxd.thanksgivinghall.bean.Base;
import com.example.sxd.thanksgivinghall.bean.UserInfoEntity;

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
    public void login(String username, String password, final ResultListener<Base> result) {
        Call<Base> call = AppMainService.getLoginService(baseUrl).userLogin(username, password);
        //请求开始
        result.onStart();
        //执行操作
        call.enqueue(new Callback<Base>() {
            @Override
            public void onResponse(Call<Base> call, Response<Base> response) {
                //请求成功
                result.onSuccess(response.body());
                //请求结束
                result.onEnd();
            }

            @Override
            public void onFailure(Call<Base> call, Throwable t) {
                //请求失败
                result.onFailure(t.getMessage());
                //请求结束
                result.onEnd();
            }
        });
    }

    @Override
    public void userInfos(String username, final ResultListener<UserInfoEntity> result) {
        Call<UserInfoEntity> call = AppMainService.getLoginService(baseUrl).userInfos(username);
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
