package com.kim.kaframework.UIpackage.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.kim.kaframework.DBService.DBHelper;
import com.kim.kaframework.GreenDao.UserInfoDao;
import com.kim.kaframework.Model.UserInfo;
import com.kim.kaframework.R;

import java.util.List;


public class FuntionTest extends AppCompatActivity implements View.OnClickListener {

    private TextView funtiontest_tv_title;
    private Button funtiontest_btn_1;
    private Button funtiontest_btn_2;
    private UserInfoDao userInfoDao;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funtiontest);
        InitLayout();
        InitData();
    }

    private void InitData() {

        userInfoDao = DBHelper.getInstances().getDaoSession().getUserInfoDao();
    }

    private void InitLayout() {
        funtiontest_tv_title = (TextView)findViewById(R.id.funtiontest_tv_title);
        funtiontest_btn_1 =(Button)findViewById(R.id.funtiontest_btn_1);
        funtiontest_btn_1.setOnClickListener(this);
        funtiontest_btn_2 =(Button)findViewById(R.id.funtiontest_btn_2);
        funtiontest_btn_2.setOnClickListener(this);
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
        }
    }

    private void Find() {
        List<UserInfo> userInfos = userInfoDao.queryBuilder().where
                (UserInfoDao.Properties.Id.eq(1)).build().list();
        Log.e("kim",userInfos.toString());
    }

    private void Add() {
        int count2 = userInfoDao.loadAll().size();
        Log.e("kim","总数:"+count2);
        UserInfo userInfo = new UserInfo();
//        userInfo.setId(count);
        userInfo.setUName("kim");
        userInfo.setUPost("kree");
        userInfoDao.insert(userInfo);

        List<UserInfo> userInfos = userInfoDao.loadAll();
        for (UserInfo info : userInfos) {
            Log.e("kim",info.getId()+"--"+ info.getUName());
        }


    }
}
