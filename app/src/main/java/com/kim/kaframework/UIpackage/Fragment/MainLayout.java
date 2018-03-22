package com.kim.kaframework.UIpackage.Fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.kim.kaframework.Adapter.RecyclerViewCommonHolder;
import com.kim.kaframework.Adapter.RecyclerViewCommonAdapter;
import com.kim.kaframework.InitData;
import com.kim.kaframework.R;
import com.kim.kfdao.Model.PermissionFuntion;
import java.util.List;
import Common.PermissionFuntionServer;
import ImageRes.FindImageRes;


public class MainLayout extends Fragment {

    private RecyclerView framelayout_main_rv;
    private RecyclerViewCommonAdapter<PermissionFuntion> adapter;
    private PermissionFuntionServer pfs;
    public List<PermissionFuntion> funtions;
    private int Fid;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if (args != null){
            Fid = args.getInt("fid");
            pfs = new PermissionFuntionServer(InitData.getAllpflist());
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main,container, false);
        framelayout_main_rv = view.findViewById(R.id.framelayout_main_rv);

        final FindImageRes fir = new FindImageRes(getContext());

        funtions = pfs.FilterPermissionFuntion(Fid);

        adapter = new RecyclerViewCommonAdapter<PermissionFuntion>(getContext(),funtions,R.layout.item_rv_funtionico) {
            @Override
            public void convert(RecyclerViewCommonHolder holder, PermissionFuntion item, int position, boolean isScrolling) {
                holder.setDrawable(R.id.item_funtion_iv,fir.getDrawableByStr(item.getPFEName()));
                holder.setText(R.id.item_funtion_tv,item.getPFCName());
            }
        };

        framelayout_main_rv.setLayoutManager(new GridLayoutManager(getContext(),3));
        framelayout_main_rv.setAdapter(adapter);
        adapter.setOnItemClickListener(new RecyclerViewCommonAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(RecyclerView parent, View view, int position) {
                if (rcItemClick != null){
                    rcItemClick.ItemClick(position);
                }
            }
        });

        return view;
    }


    public interface RcItemClick {
        void ItemClick(int position);
    }

    public RcItemClick rcItemClick;

    public void OnRcItemClick(RcItemClick click){ rcItemClick = click;}

}
