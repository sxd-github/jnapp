package com.example.sxd.thanksgivinghall.api.service;

import com.example.sxd.thanksgivinghall.bean.Base;
import com.example.sxd.thanksgivinghall.bean.TaskDetailEntity;
import com.example.sxd.thanksgivinghall.bean.TaskListEntity;
import com.example.sxd.thanksgivinghall.bean.TaskReceDetailEntity;
import com.example.sxd.thanksgivinghall.bean.TaskReceListEntity;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by sxd on 2018/2/2.
 */

public abstract interface TaskService {


    /**
     * 新增任务
     * @param
     * @return
     */
    @POST("infc/infcAddTask/addTask")
    Call<Base> addOaTask(@Body RequestBody Body);

    /**
     * 获取当前用户的待办任务列表
     * @param userid  当前用户
     * @return
     */
    @GET("infc/infcoaTaskRecord/user_task_list")
    Call<TaskReceListEntity> selfLReceList(@Query("userid") String userid);

    /**
     * 获取待办任务详情
     * @param id  任务id
     * @return
     */
    @GET("infc/infcoaTask/task_record_detail")
    Call<TaskReceDetailEntity> taskReceDetail(@Query("id") String id);

    /**
     * 获取当前用户已发布的任务列表
     * @param userid  当前用户
     * @return
     */
    @GET("infc/infcoaTask/task_own_list")
    Call<TaskListEntity> selfList(@Query("userid") String userid);

    /**
     * 获取当前任务详情以及回复列表
     * @param id  任务id
     * @return
     */
    @GET("infc/infcoaTask/task_reply_detail")
    Call<TaskDetailEntity> taskDetail(@Query("id") String id);

}
