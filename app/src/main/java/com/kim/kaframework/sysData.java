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

//    public static List<PermissionFuntion> getFuntions() {
//        funtions = new ArrayList<>();
//        funtions.add(addnewPF("system","系统"));
//        funtions.add(addnewPF("schedue","调度"));
//        funtions.add(addnewPF("daywork","日常工作"));
//        funtions.add(addnewPF("hardware","接口"));
//        funtions.add(addnewPF("review","查看"));
//        funtions.add(addnewPF("remark","记录"));
//        funtions.add(addnewPF("check","检查"));
//        funtions.add(addnewPF("handover","交接"));
//        funtions.add(addnewPF("order","订单"));
//        funtions.add(addnewPF("tools","工具"));
//        funtions.add(addnewPF("report","报表"));
//        funtions.add(addnewPF("document","文件"));
//        return funtions;
//    }

    public static List<PermissionFuntion> getPremession() {
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

        funtions.add(addnewPF("application","应用"));
        funtions.add(addnewPF("calendar","日历"));
        funtions.add(addnewPF("chart","图表"));
        funtions.add(addnewPF("comment","任务"));
        funtions.add(addnewPF("contact","内容"));
        funtions.add(addnewPF("delete","删除"));
        funtions.add(addnewPF("download","下载"));
        funtions.add(addnewPF("edit","编辑"));
        funtions.add(addnewPF("error","错误"));
        funtions.add(addnewPF("folder","文件夹"));
        funtions.add(addnewPF("log_in","登陆"));
        funtions.add(addnewPF("log_out","登出"));
        funtions.add(addnewPF("portfolio","配置"));
        funtions.add(addnewPF("rss","RRS"));
        funtions.add(addnewPF("search","搜索"));
        funtions.add(addnewPF("security","安全"));
        funtions.add(addnewPF("service","服务"));
        funtions.add(addnewPF("shopping_cart","购物车"));
        funtions.add(addnewPF("user_female","女用户"));
        funtions.add(addnewPF("user_male","男用户"));
        return funtions;
    }


    public static PermissionFuntion addnewPF(String en,String cn){
        PermissionFuntion pf = new PermissionFuntion();
        pf.setPFEName(en);
        pf.setPFCName(cn);
        return pf;
    }

}
