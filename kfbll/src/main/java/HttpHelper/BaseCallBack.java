package HttpHelper;

import java.io.IOException;
import java.lang.reflect.Type;

import okhttp3.Call;

public abstract class BaseCallBack<T> {

    public Type mType;

    public BaseCallBack(){
        //获取数据类型



    }

    void onSuccess(T t){}
    void onError(int code){}
    void onFailure(Call call, IOException e){}
}
