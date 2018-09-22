package bwie.com.zhangjiangxia20180921.data.utils;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class OkHttpUtils  {

    private static OkHttpUtils okHttpUtils;
    private  OkHttpClient okHttpClient;

    private OkHttpUtils(){
        if (null==okHttpClient){
            synchronized (OkHttpClient.class){
                if (null==okHttpClient){
                    okHttpClient = new OkHttpClient.Builder().build();
                }
            }
        }
    }


    public static   OkHttpUtils  getInstance(){
       if (null==okHttpUtils){
           synchronized (OkHttpUtils.class){
               if (null==okHttpUtils){
                   okHttpUtils = new OkHttpUtils();
               }
           }
       }
        return okHttpUtils;
    }

    public  void   get(String stringurl, Callback callback){
        Request request = new Request.Builder().url(stringurl).build();
        okHttpClient.newCall(request).enqueue(callback);
    }

}
