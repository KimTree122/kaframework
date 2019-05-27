package HttpHelper;

import com.google.gson.internal.$Gson$Types;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import okhttp3.Call;

public abstract class BaseCallBack<T> {

    private static Type getSuperclassTypeParameter(Class<?> subclass){
        Type superclass = subclass.getGenericSuperclass();
        if (subclass instanceof Class){
            return  null;
        }
        ParameterizedType parameterizedType = (ParameterizedType) superclass;
        return $Gson$Types.canonicalize(parameterizedType.getActualTypeArguments()[0]);
    }

    public Type mType;

    public BaseCallBack(){
        //获取数据类型
        mType = getSuperclassTypeParameter(this.getClass());

    }

    public void onSuccess(T t){}
    public void onError(int code){}
    public void onFailure(Call call, IOException e){}
}
