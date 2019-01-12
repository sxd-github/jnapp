package com.example.sxd.thanksgivinghall.bean;

import java.util.List;

/**
 * 获取某一条通知通告详情
 * Created by sxd on 2018/2/2.
 */
public class NotifyDetailEntity {
    private String success;
    private String statusMessage;
    private Data data;
    public class Data{
        private String files;          //附件
        private String title;          //通知通告标题
        private String urgentFlag;     //是否为紧急通知
        private String content;        // 通知通告内容
        private String send_user_name; //发送人
        private String send_date;      // 发送时间

        public String getFiles() {
            return files;
        }

        public void setFiles(String files) {
            this.files = files;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrgentFlag() {
            return urgentFlag;
        }

        public void setUrgentFlag(String urgentFlag) {
            this.urgentFlag = urgentFlag;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getSend_user_name() {
            return send_user_name;
        }

        public void setSend_user_name(String send_user_name) {
            this.send_user_name = send_user_name;
        }

        public String getSend_date() {
            return send_date;
        }

        public void setSend_date(String send_date) {
            this.send_date = send_date;
        }
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "NotifyDetailEntity{" +
                "success='" + success + '\'' +
                ", statusMessage='" + statusMessage + '\'' +
                ", data=" + data +
                '}';
    }
}
