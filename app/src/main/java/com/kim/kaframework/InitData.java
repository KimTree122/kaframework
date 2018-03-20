package com.kim.kaframework;


import com.kim.kfdao.Model.PermissionFuntion;

import java.util.ArrayList;
import java.util.List;

public class InitData {
    
    private static List<PermissionFuntion> allpflist;
    private static List<PermissionFuntion> fristpflist;
    

    public static List<PermissionFuntion> getAllpflist() {
        if (allpflist == null )InitAllPF();
        return allpflist;
    }

    public static void setAllpflist(List<PermissionFuntion> allpflist) {
        InitData.allpflist = allpflist;
    }

    public static List<PermissionFuntion> getFristpflist() {
        if (fristpflist == null) SetFristFuntion();
        return fristpflist;
    }

    public static void setFristpflist(List<PermissionFuntion> fristpflist) {
        InitData.fristpflist = fristpflist;
    }

    public static void SetFristFuntion(){
        fristpflist = new ArrayList<>();
        List<PermissionFuntion> pflist = new ArrayList<>();
        for (PermissionFuntion permission : allpflist) {
            if (permission.getFID() == 0){
                pflist.add(permission);
            }
        }
        int fristfid = pflist.get(0).getID();
        for (PermissionFuntion permission : allpflist) {
            if (permission.getFID() == fristfid){
                fristpflist.add(permission);
            }
        }
    }

    public static void InitAllPF() {
        allpflist = new ArrayList<>();
        allpflist.add(addnewPF("system","系统",1,0));
        allpflist.add(addnewPF("schedue","调度",2,1));
        allpflist.add(addnewPF("daywork","日常工作",3,1));
        allpflist.add(addnewPF("hardware","接口",4,1));
        allpflist.add(addnewPF("review","查看",5,1));
        allpflist.add(addnewPF("remark","记录",6,1));
        allpflist.add(addnewPF("check","检查",7,1));
        allpflist.add(addnewPF("handover","交接",8,1));
        allpflist.add(addnewPF("order","订单",9,1));
        allpflist.add(addnewPF("tools","工具",10,1));
        allpflist.add(addnewPF("report","报表",11,1));
        allpflist.add(addnewPF("document","文件",12,1));

        allpflist.add(addnewPF("application","应用",13,0));
        allpflist.add(addnewPF("calendar","日历",14,13));
        allpflist.add(addnewPF("chart","图表",15,13));
        allpflist.add(addnewPF("comment","任务",16,13));
        allpflist.add(addnewPF("contact","内容",17,13));
        allpflist.add(addnewPF("delete","删除",18,13));
        allpflist.add(addnewPF("download","下载",19,13));
        allpflist.add(addnewPF("edit","编辑",20,13));
        allpflist.add(addnewPF("error","错误",21,13));
        allpflist.add(addnewPF("folder","文件夹",22,13));
        allpflist.add(addnewPF("log_in","登陆",23,13));
        allpflist.add(addnewPF("log_out","登出",24,13));
        allpflist.add(addnewPF("portfolio","配置",25,13));
        allpflist.add(addnewPF("rss","RRS",26,13));
        allpflist.add(addnewPF("search","搜索",27,13));
        allpflist.add(addnewPF("security","安全",28,13));
        allpflist.add(addnewPF("service","服务",29,13));
        allpflist.add(addnewPF("shopping_cart","购物车",30,13));
        allpflist.add(addnewPF("user_female","女用户",31,13));
        allpflist.add(addnewPF("user_male","男用户",32,13));
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
