package com.example.phillip.materialdesignapp;

import android.content.res.Resources;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.phillip.materialdesignapp.pojo.ToolType;

/**
 * Created by Phillip on 2017/12/6.
 */

public class ToolPagerAdapter extends FragmentPagerAdapter {
    public enum Tab{
        ABOUT(R.string.about),
        HUWAI(R.string.huwai),
        XINGXIU(R.string.xingxiu),
        REMEN(R.string.remen),
        MEISHI(R.string.meishi),
        ERCIYUAN(R.string.erciyuan),
        CHANGLIAO(R.string.changliao),
        YINGPING(R.string.yingping);


        private final int mStringResource;

        Tab(@StringRes int stringResource){
            mStringResource = stringResource;
        }

        public int getStringResource() {
            return mStringResource;
        }
    }

    private final Tab [] mTabs = Tab.values();
    private final CharSequence [] mTitles = new CharSequence[mTabs.length];
    private final ToolType mToolType;
    private final ToolType[] mToolTypes = ToolType.values();


    public ToolPagerAdapter(FragmentManager fm, Resources res, ToolType toolType) {
        super(fm);
        this.mToolType = toolType;
        for (int i =0; i<mTabs.length;i++){
            mTitles[i]=res.getString(mTabs[i].getStringResource());
        }
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return ToolAboutFragment.newInstance(mToolType);
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                return ToolListFragment.newInstance(mToolType,mTabs[position]);
        }
        throw new IllegalArgumentException("Unhandled position: "+ position);
    }

    @Override
    public int getCount() {
        return mTabs.length;
    }

    @Override
    public CharSequence getPageTitle(int position){
        return mTitles[position];
    }

    @Override
    public long getItemId(int position){
        for (int i =0 ;i< mToolTypes.length;i++){
            if(mToolTypes[i] == mToolType){
                return (i * 10) + position;
            }
        }
        throw new IllegalArgumentException("Invalid position (" +position+") or ToolType ("+ mToolType +")");
    }


}
