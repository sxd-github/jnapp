package com.example.sxd.thanksgivinghall.bean;

import java.util.List;

/**
 * 获取已发布任务详情以及接收人的回复列表
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
        private String receNames;     //接收人姓名
        private String sendDate;      // 发送时间
        private List<Reply_List> reply_list;  //接收人的回复列表

        public class Reply_List{
            private String date;      // 回复时间
            private String ReplyFlag;
            private String user;
            private String content;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getReplyFlag() {
                return ReplyFlag;
            }

            public void setReplyFlag(String replyFlag) {
                ReplyFlag = replyFlag;
            }

            public String getUser() {
                return user;
            }

            public void setUser(String user) {
                this.user = user;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }
        }


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

        public String getReceNames() {
            return receNames;
        }

        public void setReceNames(String receNames) {
            this.receNames = receNames;
        }

        public String getSendDate() {
            return sendDate;
        }

        public void setSendDate(String sendDate) {
            this.sendDate = sendDate;
        }

        public List<Reply_List> getReply_list() {
            return reply_list;
        }

        public void setReply_list(List<Reply_List> reply_list) {
            this.reply_list = reply_list;
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
