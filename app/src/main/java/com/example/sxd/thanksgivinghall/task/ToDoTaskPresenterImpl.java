package com.example.sxd.thanksgivinghall.task;

import android.content.Context;

import com.example.sxd.thanksgivinghall.R;
import com.example.sxd.thanksgivinghall.api.ResultListener;
import com.example.sxd.thanksgivinghall.base.BasePresenterImpl;
import com.example.sxd.thanksgivinghall.bean.ToDoTaskListEntity;

/**
 * Created by Administrator on 2018/3/13.
 */

public class ToDoTaskPresenterImpl extends BasePresenterImpl implements ToDoTaskContract.Presenter{
    private ToDoTaskContract.View mView;
    private ToDoTaskContract.Model mModel;
    private Context context;

    public ToDoTaskPresenterImpl(Context context, ToDoTaskContract.View mView) {
        this.mView = mView;
        this.context = context;
        mModel = new ToDoTaskModelImpl(getBaseUrl(context));
    }
    @Override
    public void request(String userId,String completeFlag) {
        this.mModel.request(userId,completeFlag, new ResultListener<ToDoTaskListEntity>() {
            @Override
            public void onStart() {
            }

            @Override
            public void onEnd() {
            }

            @Override
            public void onSuccess(ToDoTaskListEntity data) {
                if (data != null) {
                    if(data.getStatusMessage().equals("ok")) {
                        mView.requestSuccess(data);
                    }else{
                //        mView.showMessage(data.getStatusMessage());
                    }
                } else {
                    mView.showMessage(context.getString(R.string.login_activity_loading_null));
                }
            }

            @Override
            public void onFailure(String message) {
                mView.showMessage(context.getString(R.string.login_activity_loginfail_toast));
            }
        });
    }



    @Override
    public void attachView(ToDoTaskContract.View paramT) {

    }

    @Override
    public void detachView() {

    }
}
