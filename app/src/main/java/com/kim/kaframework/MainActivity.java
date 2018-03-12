package com.kim.kaframework;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import com.kim.kaframework.Adapter.ListViewCommonAdapter;
import com.kim.kaframework.Adapter.ListViewHolder;
import com.kim.kaframework.ImageService.FindDrawable;
import com.kim.kaframework.Model.PermissionFuntion;
import com.kim.kaframework.UIpackage.Fragment.MainLayout;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private ListView listView;

    private ListViewCommonAdapter<PermissionFuntion> adapter;

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

        List<PermissionFuntion> funtions = new ArrayList<PermissionFuntion>();
        final FindDrawable pd = new FindDrawable(getApplicationContext());
        funtions = sysData.getFuntions();

        listView.setAdapter(adapter = new ListViewCommonAdapter<PermissionFuntion>(this, funtions, R.layout.item_lv_sysico) {
            @Override
            public void convert(ListViewHolder holder, PermissionFuntion item) {
                holder.setImage(R.id.item_sysico_iv,pd.getDrawableByStr(item.getPFEName()));
                holder.setText(R.id.item_sysico_tv,item.getPFCName());
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

        EventBus.getDefault().register(this);

    }

    @Subscribe(threadMode= ThreadMode.MAIN)
    public void MessageReviced(MessageEvent messageEvent){
        Log.e(sysData.TAG,messageEvent.getMessage()+"main");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }
}
