package com.kim.kaframework.UIpackage.Fragment;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.kim.kaframework.Adapter.RecyclerViewCommonHolder;
import com.kim.kaframework.Adapter.RecyclerViewCommonAdapter;

import com.kim.kaframework.R;
import com.kim.kaframework.sysData;
import com.kim.kfdao.Model.PermissionFuntion;

import java.util.List;

import Common.PermissionFuntionServer;
import ImageRes.FindImageRes;


public class MainLayout extends Fragment {

    private RecyclerView framelayout_main_rv;
    private RecyclerViewCommonAdapter<PermissionFuntion> adapter;
    private PermissionFuntionServer pfs;
    private List<PermissionFuntion> funtions;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main,container, false);
//        main_btn = (Button)view.findViewById(R.id.main_btn);
        framelayout_main_rv = (RecyclerView)view.findViewById(R.id.framelayout_main_rv);
//        main_btn.setOnClickListener(this);

        final FindImageRes fir = new FindImageRes(getContext());

        funtions = sysData.getPremession();

        pfs = new PermissionFuntionServer(funtions);

        adapter = new RecyclerViewCommonAdapter<PermissionFuntion>(getContext(),funtions,R.layout.item_rv_funtionico) {
            @Override
            public void convert(RecyclerViewCommonHolder holder, PermissionFuntion item, int position, boolean isScrolling) {
                holder.setDrawable(R.id.item_funtion_iv,fir.getDrawableByStr(item.getPFEName()));
                holder.setText(R.id.item_funtion_tv,item.getPFCName());
            }
        };

        framelayout_main_rv.setLayoutManager
                (new GridLayoutManager(getContext(),3));
        framelayout_main_rv.setAdapter(adapter);
        adapter.setOnItemClickListener(new RecyclerViewCommonAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(RecyclerView parent, View view, int position) {
                if (rcItemClick != null){
                    rcItemClick.OpenActivity(position);
                }
            }
        });

        return view;
    }

    public void  Refresh(int fid){


        List<PermissionFuntion> funtionList = pfs.FilterPermissionFuntion(fid);

        funtions.clear();
        funtions.addAll(funtionList);

        Log.e(sysData.TAG,funtions.size()+"总数");

        adapter.notifyDataSetChanged();


    }


    public interface RcItemClick {
        void OpenActivity(int position);
    }

    public RcItemClick rcItemClick;

    public void OnRcItemClick(RcItemClick click){ rcItemClick = click;}

}
