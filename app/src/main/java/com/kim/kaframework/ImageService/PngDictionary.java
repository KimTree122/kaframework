package com.kim.kaframework.ImageService;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;

import com.kim.kaframework.R;
import com.kim.kaframework.sysData;

import java.util.Dictionary;

public class PngDictionary {

    private Dictionary<String,Drawable> sysPng;
    private Context mcontext;

    public PngDictionary(Context context){
        mcontext = context;
    }

    public Dictionary<String, Drawable> getSysPng() {
        sysPng.put("system",mcontext.getDrawable(R.drawable.system));
        sysPng.put("schedue",mcontext.getDrawable(R.drawable.schedue));
        sysPng.put("daywork",mcontext.getDrawable(R.drawable.daywork));
        sysPng.put("hardware",mcontext.getDrawable(R.drawable.hardware));
        sysPng.put("display",mcontext.getDrawable(R.drawable.display));
        sysPng.put("review",mcontext.getDrawable(R.drawable.review));
        sysPng.put("remark",mcontext.getDrawable(R.drawable.remark));
        sysPng.put("check",mcontext.getDrawable(R.drawable.check));
        sysPng.put("car",mcontext.getDrawable(R.drawable.car));
        sysPng.put("handover",mcontext.getDrawable(R.drawable.handover));
        sysPng.put("tools",mcontext.getDrawable(R.drawable.tools));
        sysPng.put("report",mcontext.getDrawable(R.drawable.report));
        sysPng.put("document",mcontext.getDrawable(R.drawable.document));
        sysPng.put("print",mcontext.getDrawable(R.drawable.print));
        sysPng.put("order",mcontext.getDrawable(R.drawable.order));
        return sysPng;
    }

    public Drawable getDrawableByStr(String imagename){
        int resID = mcontext.getResources().getIdentifier(imagename,"drawable"
                ,this.mcontext.getPackageName());
        Log.e(sysData.TAG,resID+"ID");
        try {
            return   mcontext.getDrawable(resID);
        }catch (Exception e){
            return  mcontext.getDrawable(R.drawable.system);
        }
    }



}
