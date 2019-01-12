package com.example.sxd.thanksgivinghall.notice;

import android.content.Context;

import com.example.sxd.thanksgivinghall.R;
import com.example.sxd.thanksgivinghall.api.ResultListener;
import com.example.sxd.thanksgivinghall.base.BasePresenterImpl;
import com.example.sxd.thanksgivinghall.bean.BasicEntity;
import com.example.sxd.thanksgivinghall.bean.CaptureDeviceInfo;
import com.example.sxd.thanksgivinghall.bean.NotifyDetailEntity;
import com.example.sxd.thanksgivinghall.bean.NotifyReceListEntity;

/**
 * Created by Administrator on 2018/3/13.
 */

public class NoticeDetailPresenterImpl extends BasePresenterImpl implements NoticeDetailContract.Presenter{
    private NoticeDetailContract.View mView;
    private NoticeDetailContract.Model mModel;
    private Context context;

    public NoticeDetailPresenterImpl(Context context, NoticeDetailContract.View mView) {
        this.mView = mView;
        this.context = context;
        mModel = new NoticeDetailModelImpl(getBaseUrl(context));
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
    public void attachView(NoticeDetailContract.View paramT) {

    }

    @Override
    public void detachView() {

    }
}
