package HttpHelper;


import android.content.Context;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OKhttphelper implements IHttpHelper {
    private static final OKhttphelper ourInstance = new OKhttphelper();

     public static OKhttphelper getInstance() {
        return ourInstance;
    }

    private Gson gson;
    private OkHttpClient okHttpClient;
    private Context context;

    private OKhttphelper() {
        gson = new Gson();
        okHttpClient = new OkHttpClient();
    }

    @Override
    public void HttpPostData(String url, Map<String, Object> mapobject, final OKcallback oKcallback ) {
        FormBody.Builder requestBody = new FormBody.Builder();
        Iterator keyvalue = mapobject.entrySet().iterator();
        for (int i = 0; i < mapobject.size();i++){
            Map.Entry entry = (Map.Entry)keyvalue.next();
            String key = entry.getKey().toString();
            String value = entry.getValue().toString();
            requestBody.add(key,value);
        }

        RequestBody body =  requestBody.build();
        Request request = new Request.Builder()
                .url(url).post(body).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                oKcallback.Fail(call,e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                  oKcallback.Success(call,response);
            }
        });
    }

    @Override
    public void HttpGetData(String url, Map<String, Object> mapobject, OKcallback oKcallback) {

    }

    public interface  OKcallback{
        void Success(Call call,Response response) throws IOException;
        void Fail(Call call,IOException e);
    }

}
