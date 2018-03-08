package com.kim.kaframework.HttpHelper;

import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by xf106918 on 2018-03-08.
 */

public class HttpHelper  {

    private String murl;
    private JSONObject mobjects;
    private OkHttpClient mokHttpClient;

    public HttpHelper(String url , JSONObject jsonObject){
        murl = url;
        mobjects = jsonObject;
        mokHttpClient = HttpHelperInstance.getOkHttpClient();
    }

    public String WebData(){
        final String[] str = {""};
        final Request request = new Request.Builder().url(murl).build();
        Call call = mokHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()){
                    str[0] =  response.body().string();
                }
            }
        });
        return str[0];
    }

}
