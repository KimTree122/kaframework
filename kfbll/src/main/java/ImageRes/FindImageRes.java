package ImageRes;

import android.content.Context;
import android.graphics.drawable.Drawable;

import com.kim.kfbll.R;

/**
 * Created by xf106918 on 2018-03-16.
 */

public class FindImageRes {
    private Context mcontext;

    public FindImageRes(Context context){
        mcontext = context;
    }

    public Drawable getDrawableByStr(String imagename){
        int resID = mcontext.getResources().getIdentifier(imagename,"drawable"
                ,this.mcontext.getPackageName());
        try {
            return   mcontext.getDrawable(resID);
        }catch (Exception e){
            return  mcontext.getDrawable(R.drawable.application);
        }
    }
}
