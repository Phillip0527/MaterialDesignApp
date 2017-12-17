package com.example.phillip.materialdesignapp;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;

import jp.wasabeef.glide.transformations.CropCircleTransformation;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG="MainActivity";

    private static final String SELECTED_POSITION="selectedPosition";



    private int mCurrentNavPosition;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle toggle;
    private NavigationView mNavigationView;
    private ImageView pic_iv;
    private Toolbar mToolbar;
    private ToolType [] mToolTypes =ToolType.values();// enum.values()枚举取值

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //toolbar
        mToolbar=findViewById(R.id.toolbar);
        mToolbar.setTitle("木工工具");
        setSupportActionBar(mToolbar);


        mDrawerLayout=findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.about, R.string.about){
            @Override
            public void onDrawerOpened(View drawerView) {
                // 设置状态栏透明
//                getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                // 清除状态栏透明
//                getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                super.onDrawerClosed(drawerView);
            }
        };
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();



        //使抽屉导航栏的开启生效
        mToolbar.setNavigationIcon(R.mipmap.ic_menu_white_24dp);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDrawerLayout.openDrawer(GravityCompat.START);
            }
        });


        //添加一个抽屉导航栏监听器
        mNavigationView=findViewById(R.id.navigation_view);
        mNavigationView.getChildAt(0).setVerticalScrollBarEnabled(false);
        mNavigationView.setNavigationItemSelectedListener(this);

        //glide设置图片
        pic_iv = mNavigationView.getHeaderView(0).findViewById(R.id.pic_iv);
        Glide.with(this)
                .load(R.mipmap.touxiang2)
                .bitmapTransform(new CropCircleTransformation(this))
                .into(pic_iv);

        //设置tab和标题
        if(savedInstanceState==null){
            setupTabs(0);
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.nav_clamps:
                mCurrentNavPosition=0;
                break;
            case R.id.nav_saw:
                mCurrentNavPosition=1;
                break;
            case R.id.nav_drills:
                mCurrentNavPosition=2;
                break;
            case R.id.nav_sanders:
                mCurrentNavPosition=3;
                break;
            case R.id.nav_routers:
                mCurrentNavPosition=4;
                break;
            case R.id.nav_more:
            case R.id.nav_info:
            case R.id.nav_pifu:
            case R.id.nav_share:
                mCurrentNavPosition=5;
                break;
            default:
                Log.w(TAG,"Unknown drawer item selected");
                break;
        }

        menuItem.setChecked(true);
        setupTabs(mCurrentNavPosition);
        mDrawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mCurrentNavPosition=savedInstanceState.getInt(SELECTED_POSITION,0);
        final Menu menu=mNavigationView.getMenu();
        final MenuItem menuItem=menu.getItem(mCurrentNavPosition);
        menuItem.setChecked(true);
        setupTabs(mCurrentNavPosition);

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(SELECTED_POSITION,mCurrentNavPosition);

    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    private void setupTabs(int position) {
        final ViewPager viewPager=findViewById(R.id.viewpager);
        final TabLayout tabLayout=findViewById(R.id.tabs);
        final ToolPagerAdapter toolPagerAdapter=new ToolPagerAdapter(getSupportFragmentManager(),getResources(),mToolTypes[position]);
        tabLayout.removeAllTabs();
        tabLayout.setTabsFromPagerAdapter(toolPagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        viewPager.setAdapter(toolPagerAdapter);
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}
