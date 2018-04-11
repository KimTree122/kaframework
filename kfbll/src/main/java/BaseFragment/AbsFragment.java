package BaseFragment;


import android.support.v4.app.Fragment;
import android.util.Log;

import com.kim.kfbll.sysData;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.Objects;

public abstract class AbsFragment extends Fragment {



    private  void  InitData(){
        EventBus.getDefault().register(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void OnMessageEvent(Objects objects){
        Log.e(sysData.TAG,objects.toString());
    }

}
