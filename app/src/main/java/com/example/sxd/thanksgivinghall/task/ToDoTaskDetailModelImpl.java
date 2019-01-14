package com.example.sxd.thanksgivinghall.task;

import com.example.sxd.thanksgivinghall.api.AppMainService;
import com.example.sxd.thanksgivinghall.api.ResultListener;
import com.example.sxd.thanksgivinghall.bean.ToDoTaskDetailEntity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2018/3/13.
 */

public class ToDoTaskDetailModelImpl implements ToDoTaskDetailContract.Model{
    String baseUrl = "";

    public ToDoTaskDetailModelImpl(String baseUrl){
        this.baseUrl = baseUrl;
    }
    @Override
    public void request(String recordId, final ResultListener<ToDoTaskDetailEntity> result) {
        Call<ToDoTaskDetailEntity> call = AppMainService.getTaskService(baseUrl).taskReceDetail(recordId);
        //请求开始
        result.onStart();
        //执行操作
        call.enqueue(new Callback<ToDoTaskDetailEntity>() {
            @Override
            public void onResponse(Call<ToDoTaskDetailEntity> call, Response<ToDoTaskDetailEntity> response) {
                //请求成功
                result.onSuccess(response.body());
                //请求结束
                result.onEnd();
            }

            @Override
            public void onFailure(Call<ToDoTaskDetailEntity> call, Throwable t) {
                //请求失败
                result.onFailure(t.getMessage());
                //请求结束
                result.onEnd();
            }
        });
    }


}
