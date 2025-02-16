package io.agora.scene.base.api;


import io.agora.scene.base.BuildConfig;

public class UrlConstants {
//        public static final String BASE_URL = "http://101.34.19.8";
    public static final String BASE_URL = BuildConfig.SERVER_HOST;
    public static final String BASE_REQUEST_LOGIN_BY_TOKEN = "/api-login";//
//public static final String BASE_REQUEST_LOGIN_BY_TOKEN = "/apaas";
    public static final String BASE_REQUEST_ROOM_BY_TOKEN = "/api-room";//

    //发送验证码
    public static final String REQUEST_SEND_V_CODE = BASE_REQUEST_LOGIN_BY_TOKEN + "/users/verificationCode";

    //登录
    public static final String REQUEST_LOGIN = BASE_REQUEST_LOGIN_BY_TOKEN + "/users/login";

    //获取用户信息
    public static final String REQUEST_USER_INFO = BASE_REQUEST_LOGIN_BY_TOKEN + "/users/getUserInfo";

    //注销用户
    public static final String REQUEST_USER_CANCELLATION = BASE_REQUEST_LOGIN_BY_TOKEN + "/users/cancellation";

    //上传头像
    public static final String REQUEST_USER_UPLOAD_PHOTO = BASE_REQUEST_LOGIN_BY_TOKEN + "/upload";

    //修改用户信息
    public static final String REQUEST_USER_UPDATE = BASE_REQUEST_LOGIN_BY_TOKEN + "/users/update";

}
