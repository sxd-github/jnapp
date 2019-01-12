package com.example.sxd.thanksgivinghall.task;

import com.example.sxd.thanksgivinghall.api.AppMainService;
import com.example.sxd.thanksgivinghall.api.ResultListener;
import com.example.sxd.thanksgivinghall.bean.NotifyDetailEntity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2018/3/13.
 */

public class TaskDetailModelImpl implements TaskDetailContract.Model{
    String baseUrl = "";

    public TaskDetailModelImpl(String baseUrl){
        this.baseUrl = baseUrl;
    }
    @Override
    public void request(String id, final ResultListener<NotifyDetailEntity> result) {
        Call<NotifyDetailEntity> call = AppMainService.getNotifyService(baseUrl).notifyDetail(id);
        //请求开始
        result.onStart();
        //执行操作
        call.enqueue(new Callback<NotifyDetailEntity>() {
            @Override
            public void onResponse(Call<NotifyDetailEntity> call, Response<NotifyDetailEntity> response) {
                //请求成功
                result.onSuccess(response.body());
                //请求结束
                result.onEnd();
            }

            @Override
            public void onFailure(Call<NotifyDetailEntity> call, Throwable t) {
                //请求失败
                result.onFailure(t.getMessage());
                //请求结束
                result.onEnd();
            }
        });
    }


}
