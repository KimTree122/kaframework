package com.kim.kaframework.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class ListViewHolder {
    private final SparseArray<View> mViews;
    private View mConvertView;

    private ListViewHolder(Context context, ViewGroup viewGroup, int layoutId) {
        this.mViews = new SparseArray<View>();
        mConvertView = LayoutInflater.from(context).inflate(layoutId,viewGroup,false);
        mConvertView.setTag(this);
    }

    public static ListViewHolder get(Context context,View convertView,
                                     ViewGroup viewGroup,int layoutId){
        if (convertView == null){
            return new ListViewHolder(context,viewGroup,layoutId);
        }
        return  (ListViewHolder)convertView.getTag();
    }

    public <T extends View> T getView(int viewId){
        View view = mViews.get(viewId);
        if (view == null){
            view = mConvertView.findViewById(viewId);
        }mViews.put(viewId,view);
        return (T)view;
    }

    public View getmConvertView(){return mConvertView;}

    //设置文本
    public ListViewHolder setText(int position,String text){
        TextView view = getView(position);
        view.setText(text);
        return  this;
    }
    //设置文本颜色
    public ListViewHolder setText(int position,String text, int color){
        TextView view = getView(position);
        view.setText(text);
        view.setTextColor(color);
        return  this;
    }

    //设置图像
    public ListViewHolder setImage(int viewId, int drawableId) {
        ImageView view = getView(viewId);
        view.setImageResource(drawableId);
        return this;
    }

    //设置图像
    public ListViewHolder setImage(int viewId, Bitmap bm) {
        ImageView view = getView(viewId);
        view.setImageBitmap(bm);
        return this;
    }


}
