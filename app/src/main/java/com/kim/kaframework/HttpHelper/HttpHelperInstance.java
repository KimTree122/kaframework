package com.kim.kaframework.HttpHelper;

import okhttp3.OkHttpClient;

public class HttpHelperInstance {
    private volatile static HttpHelperInstance instance;

    private HttpHelperInstance(){

    }
    public static HttpHelperInstance getInstance(){
        if (instance == null){
            synchronized (HttpHelperInstance.class){
                if (instance == null){
                    instance = new HttpHelperInstance();
                }
            }
        }
        return  instance;
    }

    private volatile static OkHttpClient okHttpClient;

    public  static OkHttpClient getOkHttpClient(){
        if (okHttpClient == null){
            synchronized (HttpHelperInstance.class){
                if (okHttpClient == null){
                    okHttpClient = new OkHttpClient();
                }
            }
        }
        return okHttpClient;
    }



}
