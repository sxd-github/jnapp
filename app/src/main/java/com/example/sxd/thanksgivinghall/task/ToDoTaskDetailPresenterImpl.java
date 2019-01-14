package com.example.sxd.thanksgivinghall.task;

import android.content.Context;

import com.example.sxd.thanksgivinghall.R;
import com.example.sxd.thanksgivinghall.api.ResultListener;
import com.example.sxd.thanksgivinghall.base.BasePresenterImpl;
import com.example.sxd.thanksgivinghall.bean.ToDoTaskDetailEntity;

/**
 * Created by Administrator on 2018/3/13.
 */

public class ToDoTaskDetailPresenterImpl extends BasePresenterImpl implements ToDoTaskDetailContract.Presenter{
    private ToDoTaskDetailContract.View mView;
    private ToDoTaskDetailContract.Model mModel;
    private Context context;

    public ToDoTaskDetailPresenterImpl(Context context, ToDoTaskDetailContract.View mView) {
        this.mView = mView;
        this.context = context;
        mModel = new ToDoTaskDetailModelImpl(getBaseUrl(context));
    }
    @Override
    public void request(String recordId) {
        this.mModel.request(recordId, new ResultListener<ToDoTaskDetailEntity>() {
            @Override
            public void onStart() {
            }

            @Override
            public void onEnd() {
            }

            @Override
            public void onSuccess(ToDoTaskDetailEntity data) {
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
    public void attachView(ToDoTaskDetailContract.View paramT) {

    }

    @Override
    public void detachView() {

    }
}
