package com.kim.kaframework.DBService;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.kim.kaframework.GreenDao.DaoMaster;
import com.kim.kaframework.GreenDao.DaoSession;


public class DBHelper  extends Application{
    private SQLiteDatabase db;
    private DaoSession mDaoSession;
    public static DBHelper instances;

    @Override
    public void onCreate() {
        super.onCreate();
        instances = this;
        setDatabase();
    }
    public static DBHelper getInstances(){
        return instances;
    }

    private void setDatabase() {
        // 在正式的项目中，还应该做一层封装，来实现数据库的安全升级。
        DaoMaster.DevOpenHelper mHelper = new DaoMaster.DevOpenHelper(this, "notes-db", null);
        db = mHelper.getWritableDatabase();
        DaoMaster mDaoMaster = new DaoMaster(db);
        mDaoSession = mDaoMaster.newSession();
    }
    public DaoSession getDaoSession() {
        return mDaoSession;
    }
    public SQLiteDatabase getDb() {
        return db;
    }

}
