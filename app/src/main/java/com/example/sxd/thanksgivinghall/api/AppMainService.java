package com.example.sxd.thanksgivinghall.api;

import com.example.sxd.thanksgivinghall.api.service.LoginService;

public class AppMainService
{
    private static LoginService loginService;


    public static LoginService getLoginService(String paramString)
    {
        loginService = (LoginService)BaseApi.retrofit(paramString).create(LoginService.class);
        return loginService;
    }


}