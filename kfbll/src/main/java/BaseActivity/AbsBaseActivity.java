package BaseActivity;


import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.kim.kfbll.MessageEvent;
import com.kim.kfbll.R;
import com.kim.kfbll.sysData;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import Common.CrashHandler;
import HttpHelper.OKhttphelper;

public abstract class AbsBaseActivity extends AppCompatActivity {

    private PendingIntent restartIntent;

    @Override
    protected  void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);

        CrashHelperInit();
    }

    //初始化全局崩溃异常代码
    private void CrashHelperInit() {
        CrashHandler.CrashUploader crashUploader = new CrashHandler.CrashUploader() {
            @Override
            public void uploadCrashMessage(ConcurrentHashMap<String, Object> info) {
                //信息上传
            }
        };

        Intent[] intents = new Intent[1];
        Intent intent = new Intent();
        intent.setClassName("com.owen.crashhander","com.kfbll.BaseActivity.main")
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intents[0] = intent;

        restartIntent = PendingIntent.getActivities(getApplicationContext(),0,intents,0);
        CrashHandler.getInstance().init(this,crashUploader,restartIntent);
    }

    public void HttpPost(String url, Map<String, Object> mapParam , OKhttphelper.OKcallback oKcallback){
        OKhttphelper.getInstance().HttpPostData(url, mapParam , oKcallback);
    }

    @Subscribe(threadMode= ThreadMode.MAIN)//接收EvenBus信息
    public void MessageReviced(MessageEvent messageEvent){
        Log.e(sysData.TAG,messageEvent.getMessage()+"main");
    }

    protected abstract void InitLayout();

    protected abstract void InitData();

    private void SendMessage() {
        EventBus.getDefault().post(new MessageEvent("EventBus"));
    }

    /**  得到字符串資源 **/
    public String getResStr(int id)
    {
        return this.getResources().getString(id);
    }

    /** 短暂显示Toast提示(来自res) **/
    protected void showShortToast(int resId) {
        Toast.makeText(this, getString(resId), Toast.LENGTH_SHORT).show();
    }

    /** 短暂显示Toast提示(来自String) **/
    protected void showShortToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    /** Debug输出Log日志 **/
    protected void showLog(String msg) {
        Log.e("kim", msg);
    }

    protected void startActivity(Class<?> cls, Bundle bundle) {
        Intent intent = new Intent();
        intent.setClass(this, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }else{
            showLog( "there is no activity can handle this intent: "+intent.getAction().toString());
        }
        overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
    }

    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.push_right_in, R.anim.push_right_out);
    }

}
