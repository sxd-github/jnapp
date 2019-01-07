package com.example.sxd.thanksgivinghall.login;

import com.example.sxd.thanksgivinghall.api.ResultListener;
import com.example.sxd.thanksgivinghall.base.BasePresenter;
import com.example.sxd.thanksgivinghall.base.BaseView;
import com.example.sxd.thanksgivinghall.bean.UserInfoEntity;
import com.example.sxd.thanksgivinghall.bean.UserLoginEntity;

/**
 * Created by Administrator on 2018/3/13.
 */

public interface LoginContract {
    interface View extends BaseView<Presenter> {
        void showMessage(String message);

        void loginSuccess(UserLoginEntity value);

        void getUserInfo(UserInfoEntity value);

    }

    interface Presenter extends BasePresenter<View> {
        void login(String useraccount, String password);

        void getUserInfo(String useraccount);

    }

    public interface Model {
        public void login(String username, String passward, ResultListener<UserLoginEntity> result);

        public void userInfo(String useraccount, ResultListener<UserInfoEntity> result);
    }
}
