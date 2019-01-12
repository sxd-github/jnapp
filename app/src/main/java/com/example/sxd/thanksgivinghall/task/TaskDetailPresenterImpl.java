package com.example.sxd.thanksgivinghall.task;

import android.content.Context;

import com.example.sxd.thanksgivinghall.R;
import com.example.sxd.thanksgivinghall.api.ResultListener;
import com.example.sxd.thanksgivinghall.base.BasePresenterImpl;
import com.example.sxd.thanksgivinghall.bean.NotifyDetailEntity;

/**
 * Created by Administrator on 2018/3/13.
 */

public class TaskDetailPresenterImpl extends BasePresenterImpl implements TaskDetailContract.Presenter{
    private TaskDetailContract.View mView;
    private TaskDetailContract.Model mModel;
    private Context context;

    public TaskDetailPresenterImpl(Context context, TaskDetailContract.View mView) {
        this.mView = mView;
        this.context = context;
        mModel = new TaskDetailModelImpl(getBaseUrl(context));
    }
    @Override
    public void request(String companyid) {
        this.mModel.request(companyid, new ResultListener<NotifyDetailEntity>() {
            @Override
            public void onStart() {
            }

            @Override
            public void onEnd() {
            }

            @Override
            public void onSuccess(NotifyDetailEntity data) {
                if (data != null) {
                    if(data.getStatusMessage().equals("ok")) {
                        mView.requestSuccess(data);
                    }else{
                        mView.showMessage(data.getStatusMessage());
                    }
                } else {
                    mView.showMessage(context.getString(R.string.login_activity_loginfail_toast));
                }
            }

            @Override
            public void onFailure(String message) {
                mView.showMessage(context.getString(R.string.login_activity_loginfail_toast));
            }
        });
    }



    @Override
    public void attachView(TaskDetailContract.View paramT) {

    }

    @Override
    public void detachView() {

    }
}
