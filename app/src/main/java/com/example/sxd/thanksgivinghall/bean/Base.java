package com.example.sxd.thanksgivinghall.bean;

/**
 * Created by sxd on 2018/3/16.
 */

public class Base {
    private String statusMessage;
    private String success;


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

    @Override
    public String toString() {
        return "Base{" +
                "statusMessage='" + statusMessage + '\'' +
                ", success='" + success + '\'' +
                '}';
    }
}
