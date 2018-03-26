package HttpHelper;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;



public class OkHttpUtil {
    private static OkHttpClient client;
    private static Request request;
    private static Handler handler = new Handler();

    /**
     * OkHttp的get请求
     */
    static void OkHttpGet(final Context context, String url, final OnDataFinish onDataFinish) {

        request = new Request.Builder().url(url).build();
        OkHttpUtil.getClientInstance().newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Toast.makeText(context, "服务器连接异常!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String result = response.body().string();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        onDataFinish.OnSuccess(result);
                    }
                });
            }
        });
    }

    /**
     * OkHttp的post请求
     */
    static void OkHttpPost(final Context context, String url, RequestBody body, final OnDataFinish onDataFinish) {
        request = new Request.Builder().url(url).post(body).build();
        OkHttpUtil.getClientInstance().newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Toast.makeText(context, "服务器连接异常!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String result = response.body().string();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        onDataFinish.OnSuccess(result);
                    }
                });
            }
        });
    }

    /**
     * 回调接口
     */
    public interface OnDataFinish {
        void OnSuccess(String result);
    }

    /**
     * OkHttpClient单例对象实例
     */
    public static OkHttpClient getClientInstance() {
        if (client == null) {
            synchronized (OkHttpUtil.class) {
                if (client == null) {
                    client = new OkHttpClient();
                }
            }
        }
        return client;
    }


}
