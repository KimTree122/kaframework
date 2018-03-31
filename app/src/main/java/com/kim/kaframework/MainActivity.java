package com.kim.kaframework;

import android.content.Intent;
import android.support.v4.app.Fragment;
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
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.kim.kaframework.Adapter.ListViewCommonAdapter;
import com.kim.kaframework.Adapter.ListViewHolder;
import com.kim.kaframework.UIpackage.Activity.FuntionTest;
import com.kim.kaframework.UIpackage.Fragment.MainLayout;
import com.kim.kfdao.Model.PermissionFuntion;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import java.util.List;

import Common.PermissionFuntionServer;
import DialogFragment.EditDialog;
import ImageRes.FindImageRes;

public class MainActivity extends AppCompatActivity implements EditDialog.EditDialogListener {

    private Toolbar toolbar;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private ListView listView;
    private PermissionFuntionServer pfs;

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

        List<PermissionFuntion> funtions = InitData.getAllpflist();

        pfs = new PermissionFuntionServer(funtions);

        final List<PermissionFuntion> mainpermission = pfs.FilterPermissionFuntion(0);

        final FindImageRes fir = new FindImageRes(getApplicationContext());

        listView.setAdapter(adapter = new ListViewCommonAdapter<PermissionFuntion>(this, mainpermission, R.layout.item_lv_sysico) {
            @Override
            public void convert(ListViewHolder holder, PermissionFuntion item) {
                holder.setImage(R.id.item_sysico_iv,fir.getDrawableByStr(item.getPFEName()));
                holder.setText(R.id.item_sysico_tv,item.getPFCName());
            }
        });

        MainFagmentShow(1);

        toolbar.setTitle("Toolbar");//设置Toolbar标题
        toolbar.setTitleTextColor(ContextCompat.getColor(getApplicationContext(),R.color.white)); //设置标题颜色
        setSupportActionBar(toolbar);
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
        mDrawerLayout.addDrawerListener(mDrawerToggle);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){

                }
                return false;
            }
        });


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                MainFagmentShow(mainpermission.get(i).getID());
                mDrawerLayout.closeDrawers();
            }
        });

        EventBus.getDefault().register(this);//注册EvenBus事件

    }

    private void  MainFagmentShow(int fid){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        final MainLayout mainframe = new MainLayout();

        Bundle args = new Bundle();
        args.putInt("fid",fid);
        mainframe.setArguments(args);

        transaction.replace(R.id.drawerlayout_frameLayout,mainframe);
        transaction.commit();

        mainframe.OnRcItemClick(new MainLayout.RcItemClick() {
            @Override
            public void ItemClick(int position) {
                 String str = mainframe.funtions.get(position).getLayoutName();
                OpenFragment(str);
            }
        });

    }


    private void  OpenLayout(String activityName)  {
        Class aClass = null;
        try {
            String Activity = getApplicationContext().getPackageName()+"."+activityName;

            aClass = Class.forName(Activity);
        }catch (ClassNotFoundException e){
            Toast.makeText(getApplicationContext(),
                    getResources().getString(R.string.notfoundclass),Toast.LENGTH_SHORT).show();
            return;
        }
        startActivity(new Intent(MainActivity.this,aClass));
    }

    private void OpenFragment(String frammentName) {
        String fPaht = getApplicationContext().getPackageName()+"."+frammentName;
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        try {
            Fragment fragment = Fragment.instantiate(getApplicationContext(),fPaht);
            transaction.setCustomAnimations(R.anim.slide_right_in,R.anim.slide_left_out);
            transaction.replace(R.id.drawerlayout_frameLayout,fragment);
            transaction.commit();
        }catch (Exception e){
//            Toast.makeText(getApplicationContext(),"打开界面出错，请联系管理员",Toast.LENGTH_SHORT).show();

//            EditDialog f = new EditDialog();
//            f.setCancelable(false);
//            f.show(getFragmentManager(),"show");


//            DialogFragmentHelper.showConfirmDialog(getSupportFragmentManager(), "是否选择 Android？", new IDialogResultListener<Integer>() {
//                @Override
//                public void onDataResult(Integer result) {
//                    showToast("You Click Ok");
//                }
//            }, true, new CommonDialogFragment.OnDialogCancelListener() {
//                @Override
//                public void onCancel() {
//                    showToast("You Click Cancel");
//                }
//            });

            startActivity(new Intent(this, FuntionTest.class));

        }

    }



    private void showToast(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void OnEditInputComplete(String username, String password) {
        Toast.makeText(this, "帐号：" + username + ",  密码 :" + password,
                Toast.LENGTH_SHORT).show();
    }

    @Subscribe(threadMode= ThreadMode.MAIN)//接收EvenBus信息
    public void MessageReviced(MessageEvent messageEvent){
        Log.e(sysData.TAG,messageEvent.getMessage()+"main");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }
}
