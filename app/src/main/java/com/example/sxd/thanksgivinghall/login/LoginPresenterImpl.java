package com.example.sxd.thanksgivinghall.login;

import android.content.Context;

import com.example.sxd.thanksgivinghall.bean.Constants;
import com.example.sxd.thanksgivinghall.R;
import com.example.sxd.thanksgivinghall.api.ResultListener;
import com.example.sxd.thanksgivinghall.base.BasePresenterImpl;
import com.example.sxd.thanksgivinghall.bean.UserInfoEntity;
import com.example.sxd.thanksgivinghall.bean.UserLoginEntity;
import com.example.sxd.thanksgivinghall.utils.NetUtil;
import com.example.sxd.thanksgivinghall.utils.SharedPreUtils;
import com.example.sxd.thanksgivinghall.utils.StringUtils;
import com.blankj.utilcode.utils.EncryptUtils;

/**
 * Created by Administrator on 2018/3/13.
 */

public class LoginPresenterImpl extends BasePresenterImpl implements LoginContract.Presenter{
    private LoginContract.View mView;
    private LoginContract.Model mModel;
    private Context context;

    public LoginPresenterImpl(Context context, LoginContract.View mView) {
        this.mView = mView;
        this.context = context;
        mModel = new LoginModelImpl(getBaseUrl(context));
    }
    @Override
    public void login(String useraccount, String password) {
        if (!StringUtils.notIsBlankAndEmpty(useraccount)) {
            this.mView.showMessage(context.getString(R.string.login_activity_input_username_toast));
            return;
        }
        if (!StringUtils.notIsBlankAndEmpty(password)) {
            this.mView.showMessage(context.getString(R.string.login_activity_input_password_toast));
            return;
        }

        if (password.length() < 6 && password.length() > 20) {
            this.mView.showMessage(context.getString(R.string.login_activity_input_password_error_toast));
            return;
        }
        //密码MD5加密 或者MD5.md5(password）
        password = EncryptUtils.encryptMD5ToString(password.getBytes()).toLowerCase();
        System.out.println(password);
        if(!NetUtil.isNetworkAvailable(context)){
            this.mView.showMessage(context.getString(R.string.login_activity_loginfail_network));
            return;
        }
        this.mModel.login(useraccount, password, new ResultListener<UserLoginEntity>() {
            @Override
            public void onStart() {
                mView.showMessage(context.getString(R.string.login_activity_logining_toast));
            }

            @Override
            public void onEnd() {
            }

            @Override
            public void onSuccess(UserLoginEntity data) {
                if (data != null) {
                    switch (data.getStatusCode()){
                        case "0000":
                            mView.loginSuccess(data);
                            break;
                        case "0001":
                            mView.showMessage(context.getString(R.string.login_error_0001));
                            break;
                        case "0002":
                            mView.showMessage(context.getString(R.string.login_error_0002));
                            break;
                        case "0003":
                            mView.showMessage(context.getString(R.string.login_error_0003));
                            break;
                        case "0004":
                            mView.showMessage(context.getString(R.string.login_error_0004));
                            break;
                        case "0005":
                            mView.showMessage(context.getString(R.string.login_error_0005));
                            break;
                        case "0006":
                            mView.showMessage(context.getString(R.string.login_error_0006));
                            break;
                        case "0007":
                            mView.showMessage(context.getString(R.string.login_error_0007));
                            break;
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
    public void getUserInfo(String useraccount) {
        this.mModel.userInfo(useraccount, new ResultListener<UserInfoEntity>() {
            @Override
            public void onStart() {
            }

            @Override
            public void onEnd() {
            }

            @Override
            public void onSuccess(UserInfoEntity data) {
                if (data != null) {
                    switch (data.getStatusCode()) {
                        case "0000":
                            mView.getUserInfo(data);
                            break;
                        default:
                            mView.showMessage(context.getString(R.string.login_activity_loading_fail_toast));
                            break;
                    }
                }
            }

            @Override
            public void onFailure(String message) {
                mView.showMessage(context.getString(R.string.login_activity_loading_fail_toast));
            }
        });
    }

    @Override
    public void attachView(LoginContract.View paramT) {

    }

    @Override
    public void detachView() {

    }
}
