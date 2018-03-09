package com.kim.kaframework.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.nineoldandroids.view.ViewHelper;
import com.nineoldandroids.view.ViewPropertyAnimator;

import java.util.List;

/**
 * Created by xf106918 on 2018-03-07.
 */

public abstract class ListViewCommonAdapter<T> extends BaseAdapter {

    private LayoutInflater mInflater;
    private Context mContext;
    private List<T> mDatas;
    private final int mItemLayoutId;

    public ListViewCommonAdapter(Context context, List<T> mDatas,int ItemLayoutId){
        this.mContext = context;
        this.mInflater = LayoutInflater.from(mContext);
        this.mDatas = mDatas;
        this.mItemLayoutId = ItemLayoutId;
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public T getItem(int i) {
        return mDatas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public abstract void convert(ListViewHolder holder,T item);

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
       final ListViewHolder viewHolder = getViewHolder(view,viewGroup);
        convert(viewHolder,getItem(i));
        View anview = viewHolder.getmConvertView();
        ViewHelper.setScaleX(anview, 0.5f);
        ViewHelper.setScaleY(anview, 0.5f);
        //以属性动画放大
        ViewPropertyAnimator.animate(anview).scaleX(1).setDuration(350).start();
        ViewPropertyAnimator.animate(anview).scaleY(1).setDuration(350).start();
        return anview;
    }

    private  ListViewHolder getViewHolder(View view,ViewGroup viewGroup){
        return  ListViewHolder.get(mContext,view,viewGroup,mItemLayoutId);
    }

}
