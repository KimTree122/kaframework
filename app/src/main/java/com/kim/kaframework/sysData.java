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


    public static List<PermissionFuntion> getPremession() {
        permissions = new ArrayList<>();
        permissions.add(addnewPF("system","系统",1,0));
        permissions.add(addnewPF("schedue","调度",2,1));
        permissions.add(addnewPF("daywork","日常工作",3,1));
        permissions.add(addnewPF("hardware","接口",4,1));
        permissions.add(addnewPF("review","查看",5,1));
        permissions.add(addnewPF("remark","记录",6,1));
        permissions.add(addnewPF("check","检查",7,1));
        permissions.add(addnewPF("handover","交接",8,1));
        permissions.add(addnewPF("order","订单",9,1));
        permissions.add(addnewPF("tools","工具",10,1));
        permissions.add(addnewPF("report","报表",11,1));
        permissions.add(addnewPF("document","文件",12,1));

        permissions.add(addnewPF("application","应用",13,0));
        permissions.add(addnewPF("calendar","日历",14,13));
        permissions.add(addnewPF("chart","图表",15,13));
        permissions.add(addnewPF("comment","任务",16,13));
        permissions.add(addnewPF("contact","内容",17,13));
        permissions.add(addnewPF("delete","删除",18,13));
        permissions.add(addnewPF("download","下载",19,13));
        permissions.add(addnewPF("edit","编辑",20,13));
        permissions.add(addnewPF("error","错误",21,13));
        permissions.add(addnewPF("folder","文件夹",22,13));
        permissions.add(addnewPF("log_in","登陆",23,13));
        permissions.add(addnewPF("log_out","登出",24,13));
        permissions.add(addnewPF("portfolio","配置",25,13));
        permissions.add(addnewPF("rss","RRS",26,13));
        permissions.add(addnewPF("search","搜索",27,13));
        permissions.add(addnewPF("security","安全",28,13));
        permissions.add(addnewPF("service","服务",29,13));
        permissions.add(addnewPF("shopping_cart","购物车",30,13));
        permissions.add(addnewPF("user_female","女用户",31,13));
        permissions.add(addnewPF("user_male","男用户",32,13));
        return permissions;
    }

    public static List<PermissionFuntion> getFristFuntion(){
        if (permissions.size() == 0){
            permissions = getPremession();
        }
        return  fristFuntion;
    }


    private static PermissionFuntion addnewPF(String en,String cn,int id,int fid){
        PermissionFuntion pf = new PermissionFuntion();
        pf.setFID(fid);
        pf.setID(id);
        pf.setPFEName(en);
        pf.setPFCName(cn);
        return pf;
    }

}
