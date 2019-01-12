package com.example.sxd.thanksgivinghall.api.service;

import com.example.sxd.thanksgivinghall.bean.OfficeUserEntity;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by sxd on 2018/2/2.
 */

public abstract interface OfficeUserService {

    /**
     * 部门及部门用户信息
     * @param
     * @return
     */
    @GET("infc/infcuser/getOfficeAndUser")
    Call<OfficeUserEntity> getOfficeAndUser();

}
