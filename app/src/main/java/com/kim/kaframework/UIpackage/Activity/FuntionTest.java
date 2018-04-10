package com.kim.kaframework.UIpackage.Activity;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringDef;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.Xml;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.kim.kaframework.MessageEvent;
import com.kim.kaframework.sysData;
import com.kim.kaframework.R;
import com.kim.kfbll.QRScan.MipcaActivityCapture;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import BaseActivity.AbsBaseActivity;
import HttpHelper.OKhttphelper;
import okhttp3.Call;
import okhttp3.Response;

import static android.support.v4.content.PermissionChecker.PERMISSION_GRANTED;


public class FuntionTest extends AbsBaseActivity implements View.OnClickListener {

    private TextView funtiontest_tv_title;
    private Button funtiontest_btn_1;
    private Button funtiontest_btn_2;
    private Button funtiontest_btn_3;
    private Button funtiontest_btn_4;
    private Button funtiontest_btn_5;
    private Button funtiontest_btn_6;
    private Button funtiontest_btn_7;
    private Button funtiontest_btn_8;

    private EditText funtiontest_et_1;

    private ImageView funtiontest_image;

    private final static int SCANNIN_GREQUEST_CODE = 1;

    private Socket socket;
    private ExecutorService mThreadPool;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funtiontest);
        InitLayout();
        InitData();
    }

    protected void InitData() {
//        userInfoDao = DBHelper.getInstances().getDaoSession().getUserInfoDao();
        EventBus.getDefault().register(this);
        mThreadPool = Executors.newCachedThreadPool();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void OnMessageEvent(Objects objects){
        Log.e(sysData.TAG,objects.toString());
    }

    protected void InitLayout() {
        funtiontest_tv_title = (TextView)findViewById(R.id.funtiontest_tv_title);
        funtiontest_btn_1 =(Button)findViewById(R.id.funtiontest_btn_1);
        funtiontest_btn_1.setOnClickListener(this);
        funtiontest_btn_2 =(Button)findViewById(R.id.funtiontest_btn_2);
        funtiontest_btn_2.setOnClickListener(this);
        funtiontest_btn_3 =(Button)findViewById(R.id.funtiontest_btn_3);
        funtiontest_btn_3.setOnClickListener(this);
        funtiontest_btn_4 =(Button)findViewById(R.id.funtiontest_btn_4);
        funtiontest_btn_4.setOnClickListener(this);
        funtiontest_btn_5 =(Button)findViewById(R.id.funtiontest_btn_5);
        funtiontest_btn_5.setOnClickListener(this);
        funtiontest_btn_6 =(Button)findViewById(R.id.funtiontest_btn_6);
        funtiontest_btn_6.setOnClickListener(this);
        funtiontest_btn_7 =(Button)findViewById(R.id.funtiontest_btn_7);
        funtiontest_btn_7.setOnClickListener(this);
        funtiontest_btn_8 =(Button)findViewById(R.id.funtiontest_btn_8);
        funtiontest_btn_8.setOnClickListener(this);


        funtiontest_et_1 = (EditText)findViewById(R.id.funtiontest_et_1);

        funtiontest_image = (ImageView)findViewById(R.id.funtiontest_image);
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
            case R.id.funtiontest_btn_3:
                SendMessage();
                break;
            case R.id.funtiontest_btn_4:
               MyOKhttpTest();
                break;
            case R.id.funtiontest_btn_5:
               QRScan();
                break;
            case R.id.funtiontest_btn_6:
                ConncetSocket();
                break;
            case R.id.funtiontest_btn_7:
                SendSocketMsg();
                break;
            case R.id.funtiontest_btn_8:
                Revieve();
                break;
        }
    }

    private void ConncetSocket() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    socket = new Socket("192.168.61.65",60000);
                    showLog("连接成功");
                    if (socket.isConnected()){
                        Revieve();
                    }
                }catch (UnknownHostException e){
                   e.printStackTrace();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        });
        t.start();
    }

    private void Revieve(){
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true){
                        InputStream is = socket.getInputStream();
                        int result = is.available();
                        if (result == 0)continue;
                        byte[] data = new  byte[result];
                        is.read(data);
                        String content = new String(data,"utf-8");
                        showLog(content);
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();

    }

    private void SendSocketMsg() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OutputStream outputStream = socket.getOutputStream();
                    String msg = funtiontest_et_1.getText().toString();
                    outputStream.write(msg.getBytes("utf-8"));
                    outputStream.flush();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }

    private void QRScan() {
        Intent intent = new Intent();
        intent.setClass(FuntionTest.this, MipcaActivityCapture.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivityForResult(intent, SCANNIN_GREQUEST_CODE);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case SCANNIN_GREQUEST_CODE:
                if(resultCode == RESULT_OK){
                    Bundle bundle = data.getExtras();
                    //显示扫描到的内容
                    funtiontest_tv_title.setText(bundle.getString("result"));
                    //显示
                    funtiontest_image.setImageBitmap((Bitmap) data.getParcelableExtra("bitmap"));
                }
                break;
        }
    }

    private void MyOKhttpTest() {

        Log.e(sysData.TAG,"kaishi");
        Map<String, Object> mapobject = new HashMap<>();
        HttpPost("http://192.168.61.65:1277/Ntol/NtolData/GetTestData", mapobject, new OKhttphelper.OKcallback() {
            @Override
            public void Success(Call call, Response response) throws IOException {
                Log.e(sysData.TAG,response.body().string());
            }

            @Override
            public void Fail(Call call, IOException e) {

            }
        });

    }

    private void SendMessage() {
        EventBus.getDefault().post(new MessageEvent("funtiontest"));
    }

    private void Find() {
//        List<UserInfo> userInfos = userInfoDao.queryBuilder().where
//                (UserInfoDao.Properties.Id.eq(0)).build().list();
//        Log.e(sysData.TAG,userInfos.toString());

    }

    private void Add() {
//        int count2 = userInfoDao.loadAll().size();
//        Log.e(sysData.TAG,"总数:"+count2);
//        UserInfo userInfo = new UserInfo();
//        userInfo.setUName("kim");
//        userInfo.setUPost("kree");
//        userInfoDao.insert(userInfo);
//
//        List<UserInfo> userInfos = userInfoDao.loadAll();
//        for (UserInfo info : userInfos) {
//            Log.e(sysData.TAG,info.getId()+"--"+ info.getUName());
//        }


    }

    private boolean checkPermissionAllGranted(String[] permissions) {
        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
                // 只要有一个权限没有被授予, 则直接返回 false
                return false;
            }
        }
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1) {
            for (int i = 0; i < permissions.length; i++) {
                if (grantResults[i] == PERMISSION_GRANTED) {
                    Toast.makeText(this, "" + "权限" + permissions[i] + "申请成功", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "" + "权限" + permissions[i] + "申请失败", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    public void requestAllPower() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                                Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
            }
        }
    }
}
