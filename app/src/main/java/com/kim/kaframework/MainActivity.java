package com.kim.kaframework;

import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.kim.kaframework.Adapter.ListViewCommonAdapter;
import com.kim.kaframework.Adapter.ListViewHolder;
import com.kim.kaframework.UIpackage.Fragment.MainLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private ListView listView;

    private ListViewCommonAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();

    }

    private void findViews() {
        toolbar = (Toolbar) findViewById(R.id.toolbar_main_comment);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout_main);
        listView = (ListView)findViewById(R.id.drawerLayout_ListView);


        List<String> strings = new ArrayList<>(Arrays.asList("宋江", "卢俊义", "吴用",
                "公孙胜", "关胜", "林冲", "秦明", "呼延灼", "花荣", "柴进", "李应", "朱仝", "鲁智深",
                "武松", "董平", "张清", "杨志", "徐宁", "索超", "戴宗", "刘唐", "李逵", "史进", "穆弘",
                "雷横", "李俊", "阮小二", "张横", "阮小五", " 张顺", "阮小七", "杨雄", "石秀", "解珍"));

        listView.setAdapter(adapter = new ListViewCommonAdapter<String>(this,strings,R.layout.item_lv_test) {
            @Override
            public void convert(ListViewHolder holder, String item) {
                holder.setText(R.id.item_lv_text,
                        item, ContextCompat.getColor(getApplicationContext(),R.color.androidblued));
            }
        });


        toolbar.setTitle("Toolbar");//设置Toolbar标题
        toolbar.setTitleTextColor(ContextCompat.getColor(getApplicationContext(),R.color.white)); //设置标题颜色
//        toolbar.setScrollBarStyle();
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true); //设置返回键可用
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setPopupTheme(R.style.ToolbarPopupTheme);

        mDrawerToggle = new ActionBarDrawerToggle(this,mDrawerLayout,toolbar,R.string.open,R.string.close){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };

        mDrawerToggle.syncState();
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){

                }
                return false;
            }
        });

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        MainLayout mainframe = new MainLayout();
        transaction.replace(R.id.drawerlayout_frameLayout,mainframe);
        transaction.commit();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }
}
