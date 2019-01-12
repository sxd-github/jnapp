package com.example.sxd.thanksgivinghall.api;

import com.example.sxd.thanksgivinghall.api.service.DeviceService;
import com.example.sxd.thanksgivinghall.api.service.LoginService;
import com.example.sxd.thanksgivinghall.api.service.NotifyService;
import com.example.sxd.thanksgivinghall.api.service.OfficeUserService;
import com.example.sxd.thanksgivinghall.api.service.TaskService;

public class AppMainService
{
    private static LoginService loginService;
    private static DeviceService deviceService;
    private static OfficeUserService officeUserService;
    private static TaskService taskService;
    private static NotifyService notifyService;


    public static LoginService getLoginService(String paramString)
    {
        loginService = (LoginService)BaseApi.retrofit(paramString).create(LoginService.class);
        return loginService;
    }
    public static DeviceService getDeviceService(String paramString)
    {
        deviceService = (DeviceService)BaseApi.retrofit(paramString).create(DeviceService.class);
        return deviceService;
    }
    public static OfficeUserService getOfficeUserService(String paramString)
    {
        officeUserService = (OfficeUserService)BaseApi.retrofit(paramString).create(OfficeUserService.class);
        return officeUserService;
    }
    public static TaskService getTaskService(String paramString)
    {
        taskService = (TaskService)BaseApi.retrofit(paramString).create(TaskService.class);
        return taskService;
    }
    public static NotifyService getNotifyService(String paramString)
    {
        notifyService = (NotifyService)BaseApi.retrofit(paramString).create(NotifyService.class);
        return notifyService;
    }

}