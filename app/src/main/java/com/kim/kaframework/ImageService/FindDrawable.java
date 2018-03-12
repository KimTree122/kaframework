package com.kim.kaframework.ImageService;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.kim.kaframework.R;

public class FindDrawable {

    private Context mcontext;

    public FindDrawable(Context context){
        mcontext = context;
    }

    public Drawable getDrawableByStr(String imagename){
        int resID = mcontext.getResources().getIdentifier(imagename,"drawable"
                ,this.mcontext.getPackageName());
        try {
            return   mcontext.getDrawable(resID);
        }catch (Exception e){
            return  mcontext.getDrawable(R.drawable.system);
        }
    }
}
