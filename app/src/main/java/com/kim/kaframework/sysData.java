package com.kim.kaframework;

import com.kim.kaframework.Model.UserInfo;



public class sysData {

    public static String TAG = "kim";
    private static UserInfo muserInfo;

    public static UserInfo getMuserInfo() {
        return muserInfo == null ? new UserInfo(): muserInfo;
    }

    public static void setMuserInfo(UserInfo muserInfo) {
        sysData.muserInfo = muserInfo;
    }
}
