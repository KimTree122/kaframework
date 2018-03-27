package HttpHelper;

import android.os.Handler;
import android.os.Looper;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import java.util.logging.LogRecord;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OKHttpManager {

    private static OKHttpManager mInstance;
    private OkHttpClient mokHttpClient;
    private Handler handler;
    private Gson mgson;

    private OKHttpManager(){
        initOkhttp();
        handler = new Handler(Looper.getMainLooper());
        mgson = new Gson();
    }

    public static synchronized OKHttpManager getmInstance(){

        if (mInstance == null){
            mInstance = new OKHttpManager();
        }
        return mInstance;
    }

    private void initOkhttp(){
        mokHttpClient= new OkHttpClient().newBuilder().readTimeout(3000, TimeUnit.SECONDS)
                .connectTimeout(3000,TimeUnit.SECONDS).build();
    }


    public void request(SimpleHttpClient client, final BaseCallBack callBack){

        if (callBack == null){
            throw new NullPointerException("");
        }

        mokHttpClient.newCall(client.builderRequest()).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callBack.onFailure(call,e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()){
                    String result = response.body().string();

                    if (callBack.mType == null || callBack.mType == String.class){
                       sendOnSuccessMessage(result);
                    }else {
                        sendOnSuccessMessage(mgson.fromJson(result,callBack.mType));
                    }



                    if (response.body() != null){
                        response.body().close();
                    }

                }else {
//                    sendonFailureMessage();
                }


            }
        });

    }

    private void sendOnSuccessMessage(Object result) {
        handler.post(new Runnable() {
            @Override
            public void run() {

            }
        });
    }

    private void sendonFailureMessage(BaseCallBack callBack){
        handler.post(new Runnable() {
            @Override
            public void run() {

            }
        });
    }



}
