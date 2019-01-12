package com.example.sxd.thanksgivinghall.notice;

import com.example.sxd.thanksgivinghall.api.ResultListener;
import com.example.sxd.thanksgivinghall.base.BasePresenter;
import com.example.sxd.thanksgivinghall.base.BaseView;
import com.example.sxd.thanksgivinghall.bean.BasicEntity;
import com.example.sxd.thanksgivinghall.bean.CaptureDeviceInfo;
import com.example.sxd.thanksgivinghall.bean.NotifyReceListEntity;

/**
 * Created by Administrator on 2018/3/13.
 */

public interface NoticeContract {
    interface View extends BaseView<Presenter> {
        void showMessage(String message);

        void requestSuccess(NotifyReceListEntity value);

    }

    interface Presenter extends BasePresenter<View> {
        void request(String userid);

    }

    public interface Model {
        public void request(String userid, ResultListener<NotifyReceListEntity> result);

    }
}
