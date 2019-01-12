package com.example.sxd.thanksgivinghall.bean;

/**
 * 获取当前任务详情以及回复列表
 * Created by sxd on 2018/2/2.
 */
public class TaskDetailEntity {
    private String success;
    private String statusMessage;
    private Data data;
    public class Data{
        private String id;          //附件
        private String title;          //任务标题
        private String forwoadFlag;     //是否为紧急任务
        private String sendDate;      // 发送时间


        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getForwoadFlag() {
            return forwoadFlag;
        }

        public void setForwoadFlag(String forwoadFlag) {
            this.forwoadFlag = forwoadFlag;
        }

        public String getSendDate() {
            return sendDate;
        }

        public void setSendDate(String sendDate) {
            this.sendDate = sendDate;
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
        return "TaskDetailEntity{" +
                "success='" + success + '\'' +
                ", statusMessage='" + statusMessage + '\'' +
                ", data=" + data +
                '}';
    }
}
