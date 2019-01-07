package com.example.sxd.thanksgivinghall.login;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sxd.thanksgivinghall.MainFragment;
import com.example.sxd.thanksgivinghall.bean.Constants;
import com.example.sxd.thanksgivinghall.R;
import com.example.sxd.thanksgivinghall.bean.UserInfoEntity;
import com.example.sxd.thanksgivinghall.bean.UserLoginEntity;
import com.example.sxd.thanksgivinghall.utils.SharedPreUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements LoginContract.View{

    //retrofit  restful api
    //butterkinfe
    //google mvp
    //百度地图+极光推送
    //toolbar
    //
    @BindView(R.id.tv_changePw)
    TextView tvChangePw;
    @BindView(R.id.logon_et_username)
    EditText tvUsername;
    @BindView(R.id.logon_et_password)
    EditText tvPassword;
    @BindView(R.id.logon_bt_logon)
    Button btLogOn;
    @BindView(R.id.login_progress)
    LinearLayout loginProgress;

    LoginContract.Presenter mPresenter;
    String userAccount;
    String password;
    public static final String TAG_EXIT = "exit";
    private boolean mIsExit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_on);
        ButterKnife.bind(this);

        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
//        Utils.init(this);
        tvUsername.setText(SharedPreUtils.getString(LoginActivity.this, Constants.SP_LOGIN_ACCOUNT));
        tvPassword.setText(SharedPreUtils.getString(LoginActivity.this, Constants.SP_LOGIN_PASSWORD));
        initView();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            boolean isExit = intent.getBooleanExtra(TAG_EXIT, false);
            if (isExit) {
                this.finish();
            }
        }
    }

    @Override
    /**
     * 双击返回键退出
     */
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (mIsExit) {
                this.finish();
            } else {
                Toast.makeText(this, "再按一次退出", Toast.LENGTH_SHORT).show();
                mIsExit = true;
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mIsExit = false;
                    }
                }, 2000);
            }
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    private void initView() {

        btLogOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, MainFragment.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();

//                userAccount = tvUsername.getText().toString();
//                password = tvPassword.getText().toString();
////                Toast.makeText(LoginActivity.this, SharedPreUtils.getString(LoginActivity.this, Constants.SP_IP),Toast.LENGTH_LONG).show();
//                mPresenter.login(userAccount, password);
            }
        });
    }

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        //在系统配置成功后再次获取IP地址
        mPresenter = new LoginPresenterImpl(LoginActivity.this, this);
        if(SharedPreUtils.getBoolean(LoginActivity.this, Constants.SP_LOGIN_IS_LOG_IN)){
            returnMainActivity();
            finish();
        }
    }

    @Override
    public void loginSuccess(UserLoginEntity value) {
//        Toast.makeText(LoginActivity.this,value.getStatusCode()+"/"+value.getStatusMessage());
        //保存用户缓存
        SharedPreUtils.putString(LoginActivity.this, Constants.SP_LOGIN_ACCOUNT, userAccount);
        SharedPreUtils.putString(LoginActivity.this, Constants.SP_LOGIN_PASSWORD, password);
        SharedPreUtils.putBoolean(LoginActivity.this, Constants.SP_LOGIN_IS_LOG_IN, true);
        SharedPreUtils.putString(LoginActivity.this, Constants.MPUSH_IP, value.getData().getMpushIp());
        SharedPreUtils.putString(LoginActivity.this, Constants.MPUSH_PORT,value.getData().getMpushPort());
        SharedPreUtils.putString(LoginActivity.this, Constants.PHOTO_SERVER_IP,value.getData().getPhotoServerIp());
        SharedPreUtils.putString(LoginActivity.this, Constants.PHOTO_SERVER_PORT,value.getData().getPhotoServerPort());

        mPresenter.getUserInfo(userAccount);
    }

    @Override
    public void getUserInfo(UserInfoEntity value) {
        SharedPreUtils.putString(this, Constants.SP_LOGIN_COMPANY_ID,value.getData().getCompanyId());
        SharedPreUtils.putString(this, Constants.SP_LOGIN_COMPANY_NAME,value.getData().getCompanyName());
        SharedPreUtils.putString(this, Constants.SP_LOGIN_USER_ID,value.getData().getUserId());
        SharedPreUtils.putString(this, Constants.SP_LOGIN_USER_NAME,value.getData().getUserName());
        SharedPreUtils.putString(this, Constants.SP_LOGIN_USER_TYPE,value.getData().getUserType());
        SharedPreUtils.putString(this, Constants.SP_LOGIN_USER_PORTRAIT,value.getData().getUserPortrait());

        returnMainActivity();
        finish();

        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    /**
     * 跳转到主界面
     */
    private void returnMainActivity() {
        //跳转到MainActivity界面
      //  Intent intent = new Intent(this, MainFragment.class);
        //跳转到的activity若已在栈中存在，则将其上的activity都销掉
     //   intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
     //   startActivity(intent);
        finish();
    }
}
