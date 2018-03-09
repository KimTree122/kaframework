package com.kim.kaframework.Adapter;


import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.nineoldandroids.view.ViewHelper;
import com.nineoldandroids.view.ViewPropertyAnimator;

public class RecyclerViewCommonHolder extends RecyclerView.ViewHolder {

    private SparseArray<View> views;
    private Context mcontext;

    public RecyclerViewCommonHolder(Context context, View itemView) {
        super(itemView);
        this.mcontext = context;
        views = new SparseArray<>(8);
    }

    /**
     * 取得一个RecyclerHolder对象
     * @param context 上下文
     * @param itemView 子项
     * @return 返回一个RecyclerHolder对象
     */
    public static RecyclerViewCommonHolder getRecyclerHolder(Context context, View itemView){
        return new RecyclerViewCommonHolder(context,itemView);
    }

    public SparseArray<View> getViews(){
        return this.views;
    }

    /**
     * 通过view的id获取对应的控件，如果没有则加入views中
     * @param viewId 控件的id
     * @return 返回一个控件
     */
    @SuppressWarnings("unchecked")
    public <T extends View> T getView(int viewId){
        View view = views.get(viewId);
        if (view == null ){
            view = itemView.findViewById(viewId);
            views.put(viewId,view);
        }

        ViewHelper.setScaleX(view, 0.5f);
        ViewHelper.setScaleY(view, 0.5f);
        //以属性动画放大
        ViewPropertyAnimator.animate(view).scaleX(1).setDuration(350).start();
        ViewPropertyAnimator.animate(view).scaleY(1).setDuration(350).start();

        return (T) view;
    }

    /**
     * 设置字符串
     */
    public RecyclerViewCommonHolder setText(int viewId, String text){
        TextView tv = getView(viewId);
        tv.setText(text);
        return this;
    }

    /**
     * 设置图片
     */
    public RecyclerViewCommonHolder setImageResource(int viewId, int drawableId){
        ImageView iv = getView(viewId);
        iv.setImageResource(drawableId);
        return this;
    }

    /**
     * 设置图片
     */
    public RecyclerViewCommonHolder setImageBitmap(int viewId, Bitmap bitmap){
        ImageView iv = getView(viewId);
        iv.setImageBitmap(bitmap);
        return this;
    }

    /**
     * 设置图片
     */
    public RecyclerViewCommonHolder setImageByUrl(int viewId, String url){
//        Picasso.with(context).load(url).into((ImageView) getView(viewId));
        //        ImageLoader.getInstance().init(ImageLoaderConfiguration.createDefault(context));
        //        ImageLoader.getInstance().displayImage(url, (ImageView) getView(viewId));
        return this;
    }

}
