package com.kim.kaframework.UIpackage.Fragment;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.kim.kaframework.Adapter.RecyclerViewCommonHolder;
import com.kim.kaframework.Adapter.RecyclerViewCommonAdapter;
import com.kim.kaframework.ImageService.FindDrawable;
import com.kim.kaframework.Model.PermissionFuntion;
import com.kim.kaframework.R;
import com.kim.kaframework.UIpackage.Activity.FuntionTest;
import com.kim.kaframework.sysData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainLayout extends Fragment implements View.OnClickListener {

    private Button main_btn;
    private RecyclerView framelayout_main_rv;
    private RecyclerViewCommonAdapter<PermissionFuntion> adapter;

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

//        List<String> strings = new ArrayList<>(Arrays.asList("宋江", "卢俊义", "吴用",
//                "公孙胜", "关胜", "林冲", "秦明", "呼延灼", "花荣", "柴进", "李应", "朱仝", "鲁智深",
//                "武松", "董平", "张清", "杨志", "徐宁", "索超", "戴宗", "刘唐", "李逵", "史进", "穆弘",
//                "雷横", "李俊", "阮小二", "张横", "阮小五", " 张顺", "阮小七", "杨雄", "石秀", "解珍"));
//
//        adapter = new RecyclerViewCommonAdapter<String>(getContext(),strings,R.layout.item_lv_test) {
//            @Override
//            public void convert(RecyclerViewCommonHolder holder, String item, int position, boolean isScrolling) {
//                holder.setText(R.id.item_lv_text,item);
//            }
//        };

        final FindDrawable fd = new FindDrawable(getContext());

        List<PermissionFuntion> funtions = sysData.getFuntions();
        adapter = new RecyclerViewCommonAdapter<PermissionFuntion>(getContext(),funtions,R.layout.item_rv_funtionico) {
            @Override
            public void convert(RecyclerViewCommonHolder holder, PermissionFuntion item, int position, boolean isScrolling) {
                holder.setDrawable(R.id.item_funtion_iv,fd.getDrawableByStr(item.getPFEName()));
                holder.setText(R.id.item_funtion_tv,item.getPFCName());
            }
        };

        framelayout_main_rv.setLayoutManager
                (new GridLayoutManager(getContext(),3));
        framelayout_main_rv.setAdapter(adapter);
        adapter.setOnItemClickListener(new RecyclerViewCommonAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(RecyclerView parent, View view, int position) {
                startActivity(new Intent(getContext(), FuntionTest.class));
            }
        });



        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
//            case R.id.main_btn:
//                Intent i = new Intent(getContext(), ActivitySettings.class);
//                startActivity(i);
//                break;
        }
    }
}
