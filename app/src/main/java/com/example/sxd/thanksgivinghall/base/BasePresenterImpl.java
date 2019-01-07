package com.example.sxd.thanksgivinghall.base;
import android.content.Context;

import com.example.sxd.thanksgivinghall.bean.Constants;
import com.example.sxd.thanksgivinghall.utils.SharedPreUtils;

/**
 * Created by Administrator on 2018/3/13.
 */
public class BasePresenterImpl
{
    public String getBaseUrl(Context paramContext)
    {
//        paramContext = SharedPreUtils.putString(paramContext,"SP_FILE_NAME",);
        return String.format("http://%s:%s/", new Object[] { SharedPreUtils.getString(paramContext,"SP_IP"),  SharedPreUtils.getString(paramContext,"SP_PORT") });
    }

    public String getPhotoUrl(Context paramContext)
    {
        int post = Integer.parseInt(SharedPreUtils.getString(paramContext, Constants.PHOTO_SERVER_PORT));
        post = post -1;
        String POST = String.valueOf(post);
        return String.format("http://%s:%s/", new Object[] { SharedPreUtils.getString(paramContext,"PHOTO_SERVER_IP"),POST});
    }
}