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

public class NoticePresenterImpl extends BasePresenterImpl implements NoticeContract.Presenter{
    private NoticeContract.View mView;
    private NoticeContract.Model mModel;
    private Context context;

    public NoticePresenterImpl(Context context, NoticeContract.View mView) {
        this.mView = mView;
        this.context = context;
        mModel = new NoticeModelImpl(getBaseUrl(context));
    }
    @Override
    public void request(String companyid) {
        this.mModel.request(companyid, new ResultListener<NotifyReceListEntity>() {
            @Override
            public void onStart() {
            }

            @Override
            public void onEnd() {
            }

            @Override
            public void onSuccess(NotifyReceListEntity data) {
                if (data != null) {
                    if(data.getStatusMessage().equals("ok")) {
                        mView.requestSuccess(data);
                    }else{
                        mView.showMessage(data.getStatusMessage());
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
    public void attachView(NoticeContract.View paramT) {

    }

    @Override
    public void detachView() {

    }
}
