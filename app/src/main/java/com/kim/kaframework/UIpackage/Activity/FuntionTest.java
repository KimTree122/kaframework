package com.kim.kaframework.UIpackage.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.kim.kaframework.MessageEvent;
import com.kim.kaframework.sysData;
import com.kim.kaframework.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import BaseActivity.AbsBaseActivity;
import HttpHelper.OKhttphelper;
import okhttp3.Call;
import okhttp3.Response;


public class FuntionTest extends AbsBaseActivity implements View.OnClickListener {

    private TextView funtiontest_tv_title;
    private Button funtiontest_btn_1;
    private Button funtiontest_btn_2;
    private Button funtiontest_btn_3;
    private Button funtiontest_btn_4;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funtiontest);
        InitLayout();
        InitData();
    }

    private void InitData() {
//        userInfoDao = DBHelper.getInstances().getDaoSession().getUserInfoDao();
        EventBus.getDefault().register(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void OnMessageEvent(Objects objects){
        Log.e(sysData.TAG,objects.toString());
    }

    private void InitLayout() {
        funtiontest_tv_title = (TextView)findViewById(R.id.funtiontest_tv_title);
        funtiontest_btn_1 =(Button)findViewById(R.id.funtiontest_btn_1);
        funtiontest_btn_1.setOnClickListener(this);
        funtiontest_btn_2 =(Button)findViewById(R.id.funtiontest_btn_2);
        funtiontest_btn_2.setOnClickListener(this);
        funtiontest_btn_3 =(Button)findViewById(R.id.funtiontest_btn_3);
        funtiontest_btn_3.setOnClickListener(this);
        funtiontest_btn_4 =(Button)findViewById(R.id.funtiontest_btn_4);
        funtiontest_btn_4.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.funtiontest_btn_1:
                Add();
                break;
            case R.id.funtiontest_btn_2:
                Find();
                break;
            case R.id.funtiontest_btn_3:
                SendMessage();
                break;
            case R.id.funtiontest_btn_4:
               MyOKhttpTest();
                break;
        }
    }

    private void MyOKhttpTest() {

        Log.e(sysData.TAG,"kaishi");
        Map<String, Object> mapobject = new HashMap<>();
        HttpPost("http://192.168.61.65:1277/Ntol/NtolData/GetTestData", mapobject, new OKhttphelper.OKcallback() {
            @Override
            public void Success(Call call, Response response) throws IOException {
                Log.e(sysData.TAG,response.body().string());
            }

            @Override
            public void Fail(Call call, IOException e) {

            }
        });

    }

    private void SendMessage() {
        EventBus.getDefault().post(new MessageEvent("funtiontest"));
    }

    private void Find() {
//        List<UserInfo> userInfos = userInfoDao.queryBuilder().where
//                (UserInfoDao.Properties.Id.eq(0)).build().list();
//        Log.e(sysData.TAG,userInfos.toString());

    }

    private void Add() {
//        int count2 = userInfoDao.loadAll().size();
//        Log.e(sysData.TAG,"总数:"+count2);
//        UserInfo userInfo = new UserInfo();
//        userInfo.setUName("kim");
//        userInfo.setUPost("kree");
//        userInfoDao.insert(userInfo);
//
//        List<UserInfo> userInfos = userInfoDao.loadAll();
//        for (UserInfo info : userInfos) {
//            Log.e(sysData.TAG,info.getId()+"--"+ info.getUName());
//        }


    }




}
