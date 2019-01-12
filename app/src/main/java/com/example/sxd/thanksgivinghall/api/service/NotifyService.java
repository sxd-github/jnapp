package com.example.sxd.thanksgivinghall.api.service;

import com.example.sxd.thanksgivinghall.bean.Base;
import com.example.sxd.thanksgivinghall.bean.NotifyDetailEntity;
import com.example.sxd.thanksgivinghall.bean.NotifyReceListEntity;
import com.example.sxd.thanksgivinghall.bean.OfficeUserEntity;

import java.io.File;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by sxd on 2018/2/2.
 */

public abstract interface NotifyService {


    /**
     * 新增通知通告
     * @param
     * @return
     */
    @POST("infc/infcAddOaNotify/addOaNotify")
    Call<Base> addOaNotify(@Body RequestBody Body);


    /**
     * 获取当前用户的通知通告列表
     * @param userid  当前用户id
     * @return
     */
    @GET("infc/infcoaNotify/selfList")
    Call<NotifyReceListEntity> selfList(@Query("userid") String userid);

    /**
     * 获取通知通告详情
     * @param id  通知通告id
     * @return
     */
    @GET("infc/infcoaNotify/oanotify_detail")
    Call<NotifyDetailEntity> notifyDetail(@Query("id") String id);


}
