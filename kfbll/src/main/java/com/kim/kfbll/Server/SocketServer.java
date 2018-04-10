package com.kim.kfbll.Server;


import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SocketServer extends Service {

    private Socket socket;
    private boolean run;
    private String ipAddress;
    private int Port;
    private String setdmsg;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        ipAddress = "";
        Port = 0;
        run = true;
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        while (run){
            ipAddress = intent.getStringExtra("ipAddress");
            Port = intent.getIntExtra("port",0);
            if (ipAddress != null & Port != 0 ){
                run = false;
                ConncetServer();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return super.onStartCommand(intent, flags, startId);
    }

    private void ConncetServer() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    socket = new Socket(ipAddress,Port);
                    if (socket.isConnected()){
                        Recieve();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    private void Recieve() {
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
                        //showLog(content);
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
    }

    private void  SendMessage(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OutputStream outputStream = socket.getOutputStream();
                    String msg = setdmsg;
                    outputStream.write(msg.getBytes("utf-8"));
                    outputStream.flush();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
