package com.example.sxd.thanksgivinghall.notice;

import com.example.sxd.thanksgivinghall.api.AppMainService;
import com.example.sxd.thanksgivinghall.api.ResultListener;
import com.example.sxd.thanksgivinghall.bean.BasicEntity;
import com.example.sxd.thanksgivinghall.bean.CaptureDeviceInfo;
import com.example.sxd.thanksgivinghall.bean.NotifyReceListEntity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2018/3/13.
 */

public class NoticeModelImpl implements NoticeContract.Model{
    String baseUrl = "";

    public NoticeModelImpl(String baseUrl){
        this.baseUrl = baseUrl;
    }
    @Override
    public void request(String id, final ResultListener<NotifyReceListEntity> result) {
        Call<NotifyReceListEntity> call = AppMainService.getNotifyService(baseUrl).selfList(id);
        //请求开始
        result.onStart();
        //执行操作
        call.enqueue(new Callback<NotifyReceListEntity>() {
            @Override
            public void onResponse(Call<NotifyReceListEntity> call, Response<NotifyReceListEntity> response) {
                //请求成功
                result.onSuccess(response.body());
                //请求结束
                result.onEnd();
            }

            @Override
            public void onFailure(Call<NotifyReceListEntity> call, Throwable t) {
                //请求失败
                result.onFailure(t.getMessage());
                //请求结束
                result.onEnd();
            }
        });
    }


}
