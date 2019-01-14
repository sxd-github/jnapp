package com.example.sxd.thanksgivinghall.task;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.sxd.thanksgivinghall.R;
import com.example.sxd.thanksgivinghall.adapter.ToDoTaskReplyListAdapter;
import com.example.sxd.thanksgivinghall.base.BaseActivity;
import com.example.sxd.thanksgivinghall.bean.Base;
import com.example.sxd.thanksgivinghall.bean.Constants;
import com.example.sxd.thanksgivinghall.bean.ToDoTaskDetailEntity;
import com.example.sxd.thanksgivinghall.treelist.officeUser.BasesActivity;
import com.example.sxd.thanksgivinghall.utils.SharedPreUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 待办任务列表
 */
public class FinishedTaskDetailActivity extends BaseActivity implements ToDoTaskDetailContract.View{


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

    @BindView(R.id.rv_reply_list)
    RecyclerView rvReplyList;
    private ToDoTaskReplyListAdapter mAdapter;
    private int mCurrentCounter = 1;
    private int TOTAL_COUNTER = 1;
    ToDoTaskDetailContract.Presenter mPresenter;
    String recordId;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentLayout(R.layout.activity_finishedtask_detail);
        ButterKnife.bind(this);
        setTitle("任务详情");
        setBackArrow();//设置返回按钮和点击事件
        mPresenter = new ToDoTaskDetailPresenterImpl(this, this);
        initData();
    }


    public void click(View v) {
        switch(v.getId()){
            case R.id.bt_finished:
                finish();
                break;
            case R.id.bt_ongoing:
                Intent intent1  = new Intent(this,ReplyTaskActivity.class);
                intent1.putExtra("recordId",recordId);
                intent1.putExtra("replyFlag","0");
                startActivity(intent1);
                break;
            case R.id.bt_cannotdo:
                Intent intent2  = new Intent(this,ReplyTaskActivity.class);
                intent2.putExtra("recordId",recordId);
                intent2.putExtra("replyFlag","2");
                startActivity(intent2);
                break;
        }
    }

    @Override
    protected void setRightTitleOnClick(View v) {
        Intent intent = new Intent(getApplicationContext(),BasesActivity.class);
        startActivityForResult(intent,2);
    }


    public void initData() {
        Intent intent = getIntent();
        recordId = intent.getStringExtra("id");
        mPresenter.request(recordId);

    }


    @Override
    public void requestSuccess(final ToDoTaskDetailEntity value) {
        tv_title.setText(value.getData().getTitle());
        tv_content.setText(value.getData().getContent());
        if(value.getData().getForwoadFlag().equals("1")) {
            tv_isurgent.setText("转发任务");
        }else{
            tv_isurgent.setText("新建任务");
        }
        tv_sender.setText(value.getData().getSendUser());
        tv_send_date.setText(value.getData().getSendDate());


        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvReplyList.setLayoutManager(layoutManager);
        rvReplyList.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        TOTAL_COUNTER = value.getData().getReplyList().size();
        if (TOTAL_COUNTER == 0) {
            rvReplyList.setAdapter(null);
            Toast.makeText(this,"暂无任何回复记录",Toast.LENGTH_SHORT).show();
            return;
        }
        else {
            mAdapter = new ToDoTaskReplyListAdapter(R.layout.reply_item, value.getData().getReplyList());
            mCurrentCounter = TOTAL_COUNTER;
        }
        rvReplyList.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter mAdapter, View view, int position) {

            }
        });
        mAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                rvReplyList.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (mCurrentCounter >= TOTAL_COUNTER) {
                            //数据全部加载完毕
                            mAdapter.loadMoreEnd();
                        }
                    }
                }, 800);
            }
        }, rvReplyList);
    }

    @Override
    public void forward(Base value) {

    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setPresenter(ToDoTaskDetailContract.Presenter paramT) {

    }


}
