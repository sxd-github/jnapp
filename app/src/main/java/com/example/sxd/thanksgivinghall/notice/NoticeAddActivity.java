package com.example.sxd.thanksgivinghall.notice;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sxd.thanksgivinghall.R;
import com.example.sxd.thanksgivinghall.base.BaseActivity;
import com.example.sxd.thanksgivinghall.bean.Base;
import com.example.sxd.thanksgivinghall.bean.Constants;
import com.example.sxd.thanksgivinghall.treelist.base.BasesActivity;
import com.example.sxd.thanksgivinghall.utils.SharedPreUtils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 160905 on 2018/2/3.
 */

public class NoticeAddActivity extends BaseActivity implements NoticeAddContract.View {

    @BindView(R.id.logon_bt_logon)
    Button logonBtLogon;
    @BindView(R.id.down_userids)
    LinearLayout down_userids;
    @BindView(R.id.et_title)
    EditText et_title;
    @BindView(R.id.et_content)
    EditText et_content;
    @BindView(R.id.tv_userids)
    TextView tv_userids;
    @BindView(R.id.rg1)
    RadioGroup rg1;
    String title,content,files,sendUserId,receUserIds,urgentFlag="0";
    private NoticeAddContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentLayout(R.layout.activity_notice_add);
        ButterKnife.bind(this);
        setTitle("新增通知");//设置标题
        setBackArrow();//设置返回按钮和点击事件
        mPresenter = new NoticeAddPresenterImpl(NoticeAddActivity.this, this);

        //人员选取
        down_userids.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), BasesActivity.class);
                startActivityForResult(intent,1);
            }
        });

        //发布通知
        logonBtLogon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initValue();
            }
        });
        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_normal:
                        urgentFlag ="0";
                        break;
                    case R.id.rb_urgent:
                        urgentFlag ="1";
                        break;
                }
            }
        });
    }

    @Override
    protected void setRightTitleOnClick(View v) {
    }

    /**
     * 获取上一界面回传的接收人的id和name
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==1&&resultCode==1){
            receUserIds = data.getStringExtra("receUserIds");
            tv_userids.setText(data.getStringExtra("userNames"));
        }
    }

    public void initValue() {
//        SimpleDateFormat sdf = new SimpleDateFormatmpleDateFormat("yyyyMMddHHmm", Locale.CHINA);
//        now = sdf.format(new Date());

        title = et_title.getText().toString();
        content = et_content.getText().toString();
        sendUserId = SharedPreUtils.getString(this, Constants.SP_LOGINER_ID);

        //调用新增通知接口
        mPresenter.request(title, content,files, sendUserId,receUserIds,urgentFlag);
    }


    /*<--返回*/
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void requestSuccess(Base value) {
        showMessage("发布成功");
        finish();
    }


    @Override
    public void setPresenter(NoticeAddContract.Presenter presenter) {
        this.mPresenter = presenter;
    }
}