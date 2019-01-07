package com.example.sxd.thanksgivinghall.bean;

/**
 * Created by sxd on 2018/1/28.
 */
public class Constants {
    private static final String Base_Url = "http://192.168.15.132:8670/";
    public static final String TAG = "STRITL";
    public static final String DISCOVERlASTpAGE = "DISCOVERlASTpAGE";
    public static final String EVENT_ALARM_REFRESH = "EVENT_PUSH_REFRESH";
    public static final String EVENT_OPEN_RESIDELAYOUT = "EVENT_OPEN_RESIDELAYOUT";
    public static final String EVENT_PUSH_REFRESH = "EVENT_PUSH_REFRESH";
    public static final String PHOTO_COUNT = "PHOTO_COUNT";                   //图片数量
    public static final String PHOTO_QUALITY = "PHOTO_QUALITY";
    public static final String PRIMARYCOLOR = "PRIMARYCOLOR";

    public static final String APP_TITLE = "APP_TITLE";                    //系统名称
    public static final String MPUSH_IP = "MPUSH_IP";                      //MPUSH_IP
    public static final String MPUSH_PORT = "MPUSH_PORT";                  //MPUSH_PORT
    public static final String PHOTO_SERVER_IP = "PHOTO_SERVER_IP";                  //MPUSH_PORT
    public static final String PHOTO_SERVER_PORT = "PHOTO_SERVER_PORT";                  //MPUSH_PORT
    public static final String SP_LOGIN_ORGAN_ID = "SP_LOGIN_ORGAN_ID";   //公司ORGAN_ID
    public static final String SP_LOGIN_COMPANY_ID = "SP_LOGIN_COMPANY_ID";   //公司ID
    public static final String SP_LOGIN_COMPANY_NAME = "SP_LOGIN_COMPANY_NAME";//公司名称
    public static final String SP_LOGIN_DATA_SYNC_USER = "SP_LOGIN_DATA_SYNC_USER";
    public static final String SP_LOGIN_IS_LOG_IN = "SP_LOGIN_IS_LOG_IN";      //登陆状态
    public static final String SP_LOGIN_IS_DATA_SYNC = "SP_LOGIN_IS_DATA_SYNC";//数据是否更新
    public static final String SP_LOGIN_ACCOUNT = "SP_LOGIN_ACCOUNT";                 //登陆账号
    public static final String SP_LOGIN_PASSWORD = "SP_LOGIN_PASSWORD";         //登陆密码
    public static final String SP_LOGIN_PERSON_NAME = "SP_LOGIN_PERSON_NAME";
    public static final String SP_LOGIN_RECV_FLAG = "SP_LOGIN_RECV_FLAG";
    public static final String SP_LOGIN_UPLOAD_SERVER = "SP_LOGIN_UPLOAD_SERVER";//上传服务器
    public static final String SP_LOGIN_USER_ID = "SP_LOGIN_USER_ID";           //用户ID
    public static final String SP_LOGIN_USER_NAME = "SP_LOGIN_USER_NAME";       //用户姓名
    public static final String SP_LOGIN_USER_TYPE = "SP_LOGIN_USER_TYPE";       //用户类型
    public static final String SP_LOGIN_USER_PORTRAIT = "SP_LOGIN_USER_PORTRAIT";       //用户头像


    public static final String SP_CAPTURE_NUM = "SP_CAPTURE_NUM";       //图像浏览列数

    public static final int CAMERA_WITH_DATA = 0x01; //跳转相机并拍照返回
    public static final int ALBUM_CHOOSE_IMG = 0x02; //跳转相册获取照片返回
    public static final int FLAG_MODIFY_FINISH = 0x03; //裁剪照片完成
    public static final String SP_UPLOAD_BEGIN_DT = "SP_UPLOAD_BEGIN_DT";        //上传开始时间
    public static final String SP_UPLOAD_END_DT = "SP_UPLOAD_END_DT";            //上传结束时间
    public static final String SP_UPLOAD_INTERVAL = "SP_UPLOAD_INTERVAL";        //上传间隔
    public static final String TIME_INTERVAL = "TIME_INTERVAL";                   //时间间隔
    public static final String TITLECOLOR = "TITLECOLOR";                          //标题颜色
    public static final int TREE_ITEM_TYPE_0 = 0;                                   //父集节点
    public static final int TREE_ITEM_TYPE_1 = 1;                                   //1级节点
    public static final int TREE_ITEM_TYPE_2 = 2;                                   //2级节点
    public static final int TREE_ITEM_TYPE_3 = 3;                                   //3级节点
    public static String getBaseUrl()
    {
        return "http://192.168.15.132:8670/";
    }

    public static final int REQUEST_CODE = 1;

    public static final int RESULT_CODE = 1;

    public static final int DEFAULT_RADIUS_THRESHOLD = 0;

    public static final int PAGE_SIZE = 5000;
    /**
     * 轨迹分析查询间隔时间（1分钟）
     */
    public static final int ANALYSIS_QUERY_INTERVAL = 60;

    /**
     * 停留点默认停留时间（1分钟）
     */
    public static final int STAY_TIME = 60;

    /**
     * 启动停留时间
     */
    public static final int SPLASH_TIME = 3000;

    /**
     * 默认采集周期
     */
    public static final int DEFAULT_GATHER_INTERVAL = 5;

    /**
     * 默认打包周期
     */
    public static final int DEFAULT_PACK_INTERVAL = 30;

    /**
     * 实时定位间隔(单位:秒)
     */
    public static final int LOC_INTERVAL = 10;

    /**
     * 最后一次定位信息
     */
    public static final String LAST_LOCATION = "last_location";
}
