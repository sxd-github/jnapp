package com.example.sxd.thanksgivinghall.bean;

/**
 * 获取待办任务详情
 * Created by sxd on 2018/2/2.
 */
public class TaskReceDetailEntity {
    private String success;
    private String statusMessage;
    private Data data;
    public class Data{
        private String file;          //附件
        private String title;          //任务标题
        private String forwoadFlag;     //是否为紧急任务
        private String content;        // 任务内容
        private String senduser; //发送人
        private String sendDate;      // 发送时间

        public String getFile() {
            return file;
        }

        public void setFile(String file) {
            this.file = file;
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

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getSenduser() {
            return senduser;
        }

        public void setSenduser(String senduser) {
            this.senduser = senduser;
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
        return "TaskReceDetailEntity{" +
                "success='" + success + '\'' +
                ", statusMessage='" + statusMessage + '\'' +
                ", data=" + data +
                '}';
    }
}
