package com.kim.kfbll;


import com.kim.kfdao.Model.PermissionFuntion;
import com.kim.kfdao.Model.UserInfo;

import java.util.List;

import HttpHelper.BaseCallBack;
import HttpHelper.SimpleHttpClient;

public class sysData {
    public static String TAG = "kim";
    private static UserInfo muserInfo;
    private static List<PermissionFuntion> permissions;
    private static List<PermissionFuntion> fristFuntion;


    public static UserInfo getMuserInfo() {
        return muserInfo == null ? new UserInfo(): muserInfo;
    }

    public static void setMuserInfo(UserInfo muserInfo) {
        sysData.muserInfo = muserInfo;
    }

    public void test()
    {
        SimpleHttpClient.newBuilder().addParm("","").json().rul("").build().enqueue(new BaseCallBack<PermissionFuntion>() {
            @Override
            public void onSuccess(PermissionFuntion permissionFuntion) {
                super.onSuccess(permissionFuntion);
            }
        });
    }

}
