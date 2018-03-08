package com.kim.kaframework.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

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
        return viewHolder.getmConvertView();
    }

    private  ListViewHolder getViewHolder(View view,ViewGroup viewGroup){
        return  ListViewHolder.get(mContext,view,viewGroup,mItemLayoutId);
    }

}
