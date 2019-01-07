package com.example.sxd.thanksgivinghall.bean;

/**
 * Created by sxd on 2018/2/6.
 */
public class UserLoginEntity {
    private String statusCode;
    private String statusMessage;
    private String success;
    public Data data;

    public class Data{
        public String mpushPort;
        public String mpushIp;
        public String photoServerPort;
        public String photoServerIp;

        public String getMpushPort() {
            return mpushPort;
        }

        public void setMpushPort(String mpushPort) {
            this.mpushPort = mpushPort;
        }

        public String getMpushIp() {
            return mpushIp;
        }

        public void setMpushIp(String mpushIp) {
            this.mpushIp = mpushIp;
        }

        public String getPhotoServerPort() {
            return photoServerPort;
        }

        public void setPhotoServerPort(String photoServerPort) {
            this.photoServerPort = photoServerPort;
        }

        public String getPhotoServerIp() {
            return photoServerIp;
        }

        public void setPhotoServerIp(String photoServerIp) {
            this.photoServerIp = photoServerIp;
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

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
