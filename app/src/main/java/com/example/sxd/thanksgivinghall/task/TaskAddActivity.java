package com.example.sxd.thanksgivinghall.task;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sxd.thanksgivinghall.R;
import com.example.sxd.thanksgivinghall.base.BaseActivity;
import com.example.sxd.thanksgivinghall.bean.Base;
import com.example.sxd.thanksgivinghall.bean.Constants;
import com.example.sxd.thanksgivinghall.treelist.base.BasesActivity;
import com.example.sxd.thanksgivinghall.utils.SharedPreUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 160905 on 2018/2/3.
 */

public class TaskAddActivity extends BaseActivity implements TaskAddContract.View {

    @BindView(R.id.logon_bt_logon)
    Button logonBtLogon;
    @BindView(R.id.et_title)
    EditText et_title;
    @BindView(R.id.et_content)
    EditText et_content;
    @BindView(R.id.tv_userids)
    TextView tv_userids;
    @BindView(R.id.rg1)
    RadioGroup rg1;
    String title,content,files,sendUserId,receUserIds,urgentFlag="0";
    private TaskAddContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentLayout(R.layout.activity_task_add);
        ButterKnife.bind(this);
        setTitle("新增任务");
        setBackArrow();//设置返回按钮和点击事件
        mPresenter = new TaskAddPresenterImpl(TaskAddActivity.this, this);

        tv_userids.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), BasesActivity.class);
                startActivityForResult(intent,2);
            }
        });

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
                        urgentFlag ="a";
                        break;
                }
            }
        });
    }

    @Override
    protected void setRightTitleOnClick(View v) {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==2 && resultCode==1){
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
        mPresenter.request(title, content,files, sendUserId,receUserIds,"0");
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
    public void setPresenter(TaskAddContract.Presenter presenter) {
        this.mPresenter = presenter;
    }
}
