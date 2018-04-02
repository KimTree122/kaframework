package com.kim.kaframework;


import com.kim.kfdao.Model.PermissionFuntion;
import com.kim.kfdao.Model.UserInfo;

import java.util.ArrayList;
import java.util.List;


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

}
