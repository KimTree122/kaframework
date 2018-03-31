package BaseActivity;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.io.IOException;
import java.util.Map;

import HttpHelper.BaseCallBack;
import HttpHelper.MapParam;
import HttpHelper.OKhttphelper;
import HttpHelper.SimpleHttpClient;
import okhttp3.Call;
import okhttp3.Response;

public class AbsBaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public void HttpPost(String url, Map<String, Object> mapParam , OKhttphelper.OKcallback oKcallback){
        OKhttphelper.getInstance().HttpPostData(url, mapParam , oKcallback);
    }

}
