package com.example.sxd.thanksgivinghall.notice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sxd.thanksgivinghall.R;
import com.example.sxd.thanksgivinghall.base.BaseActivity;
import com.example.sxd.thanksgivinghall.bean.ToDoNotifyDetailEntity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 待办任务列表
 */
public class NoticeDetailActivity extends BaseActivity implements NoticeDetailContract.View{


    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.tv_content)
    TextView tv_content;
    @BindView(R.id.tv_isurgent)
    TextView tv_isurgent;
    @BindView(R.id.tv_sender)
    TextView tv_sender;
    @BindView(R.id.tv_send_date)
    TextView tv_send_date;
    NoticeDetailContract.Presenter mPresenter;
    String id;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentLayout(R.layout.activity_notice_detail);
        ButterKnife.bind(this);
        setTitle("通知详情");//设置标题
        setBackArrow();//设置返回按钮和点击事件
        mPresenter = new NoticeDetailPresenterImpl(NoticeDetailActivity.this, this);
        initData();
    }


    public void initData() {

        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        mPresenter.request(id);

    }

    @Override
    protected void setRightTitleOnClick(View v) {
    }


    @Override
    public void requestSuccess(final ToDoNotifyDetailEntity value) {
        tv_title.setText(value.getData().getTitle());
        tv_content.setText(value.getData().getContent());
        if(value.getData().getUrgentFlag().equals("1")) {
            tv_isurgent.setText("紧急通知");
        }else{
            tv_isurgent.setText("普通通知");
        }
        tv_sender.setText(value.getData().getSend_user_name());
        tv_send_date.setText(value.getData().getSend_date());


    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setPresenter(NoticeDetailContract.Presenter paramT) {

    }
}
