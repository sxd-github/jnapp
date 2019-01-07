package com.example.sxd.thanksgivinghall.bean;

/**
 * Created by sxd on 2018/2/2.
 */
public class UserInfoEntity {
    private String statusCode;
    private String statusMessage;
    private String success;
    public data data;
    public class data {
        private String userQQ;
        private Integer userSex;
        private String userWeChat;
        private String companyName;
        private String remark;
        private String userName;
        private String userId;
        private String organNmae;
        private String companyId;
        private String userPortrait;
        private String userMobile;
        private String userAccount;
        private String organId;
        private String userEmail;
        private String userType;

        public String getUserQQ() {
            return userQQ;
        }

        public void setUserQQ(String userQQ) {
            this.userQQ = userQQ;
        }

        public Integer getUserSex() {
            return userSex;
        }

        public void setUserSex(Integer userSex) {
            this.userSex = userSex;
        }

        public String getUserWeChat() {
            return userWeChat;
        }

        public void setUserWeChat(String userWeChat) {
            this.userWeChat = userWeChat;
        }

        public String getCompanyName() {
            return companyName;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getOrganNmae() {
            return organNmae;
        }

        public void setOrganNmae(String organNmae) {
            this.organNmae = organNmae;
        }

        public String getCompanyId() {
            return companyId;
        }

        public void setCompanyId(String companyId) {
            this.companyId = companyId;
        }

        public String getUserPortrait() {
            return userPortrait;
        }

        public void setUserPortrait(String userPortrait) {
            this.userPortrait = userPortrait;
        }

        public String getUserMobile() {
            return userMobile;
        }

        public void setUserMobile(String userMobile) {
            this.userMobile = userMobile;
        }

        public String getUserAccount() {
            return userAccount;
        }

        public void setUserAccount(String userAccount) {
            this.userAccount = userAccount;
        }

        public String getOrganId() {
            return organId;
        }

        public void setOrganId(String organId) {
            this.organId = organId;
        }

        public String getUserEmail() {
            return userEmail;
        }

        public void setUserEmail(String userEmail) {
            this.userEmail = userEmail;
        }

        public String getUserType() {
            return userType;
        }

        public void setUserType(String userType) {
            this.userType = userType;
        }
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public UserInfoEntity.data getData() {
        return data;
    }

    public void setData(UserInfoEntity.data data) {
        this.data = data;
    }

    //定义 输出返回数据 的方法
    public void show() {
        System.out.println("QQ："+data.userQQ);
        System.out.println("性别："+data.userSex);
        System.out.println("微信："+data.userWeChat);
        System.out.println("公司名称："+data.companyName);
        System.out.println("备注："+data.remark);
        System.out.println("用户姓名："+data.userName);
        System.out.println("用户id："+data.userId);
        System.out.println("班组名称："+data.organNmae);
        System.out.println("公司编号："+data.companyId);
        System.out.println("用户头像："+data.userPortrait);
        System.out.println("手机："+data.userMobile);
        System.out.println("用户账号："+data.userAccount);
        System.out.println("班组编号："+data.organId);
        System.out.println("email："+data.userEmail);
        System.out.println("用户类型："+data.userType);
    }
}
