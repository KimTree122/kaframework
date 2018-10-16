package com.kim.kaframework;


import com.kim.kfdao.Model.PermissionFuntion;
import com.kim.kfdao.Model.UserInfo;

import java.util.List;

import androidkun.com.versionupdatelibrary.entity.VersionUpdateConfig;


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

    public  static  void UpdateVersion(){
        VersionUpdateConfig.getInstance()//获取配置实例
                .setContext(null)//设置上下文
                .setDownLoadURL("url")//设置文件下载链接
                .setNewVersion("1.0.1")//设置即将下载的APK的版本号,避免重复下载
                .setFileSavePath("path")//设置文件保存路径（可不设置）
                .setNotificationIconRes(R.mipmap.ic_continue)//设置通知图标
                .setNotificationSmallIconRes(R.mipmap.ic_continue)//设置通知小图标
                .setNotificationTitle("版本升级Demo")//设置通知标题
                .startDownLoad();//开始下载
    }

}
