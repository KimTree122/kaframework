package com.kim.kaframework;

import com.kim.kaframework.Model.PermissionFuntion;
import com.kim.kaframework.Model.UserInfo;
import java.util.ArrayList;
import java.util.List;


public class sysData {

    public static String TAG = "kim";
    private static UserInfo muserInfo;
    private static List<PermissionFuntion> funtions;


    public static UserInfo getMuserInfo() {
        return muserInfo == null ? new UserInfo(): muserInfo;
    }

    public static void setMuserInfo(UserInfo muserInfo) {
        sysData.muserInfo = muserInfo;
    }

    public static List<PermissionFuntion> getFuntions() {
        funtions = new ArrayList<>();
        funtions.add(addnewPF("system","系统"));
        funtions.add(addnewPF("schedue","调度"));
        funtions.add(addnewPF("daywork","日常工作"));
        funtions.add(addnewPF("hardware","接口"));
        funtions.add(addnewPF("review","查看"));
        funtions.add(addnewPF("remark","记录"));
        funtions.add(addnewPF("check","检查"));
        funtions.add(addnewPF("handover","交接"));
        funtions.add(addnewPF("order","订单"));
        funtions.add(addnewPF("tools","工具"));
        funtions.add(addnewPF("report","报表"));
        funtions.add(addnewPF("document","文件"));
        return funtions;
    }

    public static PermissionFuntion addnewPF(String en,String cn){
        PermissionFuntion pf = new PermissionFuntion();
        pf.setPFEName(en);
        pf.setPFCName(cn);
        return pf;
    }

}
