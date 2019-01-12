package com.example.sxd.thanksgivinghall.adapter;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

import com.example.sxd.thanksgivinghall.R;
import com.example.sxd.thanksgivinghall.bean.CaptureDeviceInfo;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.sxd.thanksgivinghall.bean.NotifyReceListEntity;

import java.util.List;

import static android.content.Context.NOTIFICATION_SERVICE;

/**
 * Created by 160905 on 2018/2/3.
 */

public class NotifyReceListAdapter extends BaseQuickAdapter<NotifyReceListEntity.Data, BaseViewHolder> {

    private NotifyReceListAdapter myAdapter;

    public NotifyReceListAdapter(@LayoutRes int layoutResId, @Nullable List<NotifyReceListEntity.Data> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, NotifyReceListEntity.Data item) {

        helper.setText(R.id.notice_title,item.getTitle())
                .setText(R.id.sender,"发布人："+item.getSend_user_name())
                .setText(R.id.send_date,"日期："+item.getSend_date());

        /**
         * 紧急通知
         */
        if(item.getUrgentFlag().equals("1")){
            //设置紧急通知的图片
            helper.setImageResource(R.id.iv_icon,R.mipmap.urgent);

            //通知栏提醒
            NotificationManager manager = (NotificationManager) mContext.getSystemService(NOTIFICATION_SERVICE);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                NotificationChannel channel = manager.getNotificationChannel("notify");
                if (channel.getImportance() == NotificationManager.IMPORTANCE_NONE) {
                    Intent intent = new Intent(Settings.ACTION_CHANNEL_NOTIFICATION_SETTINGS);
                    intent.putExtra(Settings.EXTRA_APP_PACKAGE, mContext.getPackageName());
                    intent.putExtra(Settings.EXTRA_CHANNEL_ID, channel.getId());
                    mContext.startActivity(intent);
                    Toast.makeText(mContext, "请手动将通知打开", Toast.LENGTH_SHORT).show();
                }
            }
            Notification notification = new NotificationCompat.Builder(mContext, "notify")
                    .setContentTitle("您收到一条紧急通知")
                    .setContentText(item.getTitle())
                    .setWhen(System.currentTimeMillis())
                    .setSmallIcon(R.mipmap.urgent)
                    .setLargeIcon(BitmapFactory.decodeResource(mContext.getResources(), R.mipmap.notice))
                    .setAutoCancel(true)
                    .setNumber(2)    ///在Android系统上实现未读角标的效果
                    .build();
            manager.notify(1, notification);
        }
    }
}

