package com.example.phillip.materialdesignapp;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;


public class ToolAboutFragment extends Fragment {

    private static final String ARG_TOOL_TYPE = "toolType";

    private ToolType mTooltype;

    private ImageView imageView;
    private ImageView imageView2;

    private Handler handler;
    private Runnable runnable;

//    private OnFragmentInteractionListener mListener;



    public static ToolAboutFragment newInstance(ToolType toolType) {
        final ToolAboutFragment fragment = new ToolAboutFragment();
        final Bundle args = new Bundle();
        args.putString(ARG_TOOL_TYPE, toolType.name());
        fragment.setArguments(args);
        return fragment;
    }

    public ToolAboutFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Bundle args = getArguments();
        if (args == null) {
            throw new IllegalStateException("No arguments set; use newInstance when constructing!");
        }
        mTooltype = ToolType.valueOf(args.getString(ARG_TOOL_TYPE));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_tab,container,false);
        TextView textView = rootView.findViewById(R.id.title);
        textView.setText(mTooltype.getToolNameResourceId());
        textView = rootView.findViewById(R.id.description);
        textView.setText(mTooltype.getToolDescriptionResourceId());


        imageView=rootView.findViewById(R.id.imageview);
        imageView2=rootView.findViewById(R.id.imageview2);
        handler=new Handler();
        runnable=new Runnable() {
            @Override
            public void run() {
                //揭露效果
                if(imageView.getVisibility() == View.GONE
                        || imageView.getVisibility() == View.INVISIBLE){
                    showRevalView();
                }else{
                    hideRevalView();
                }
                if(imageView2.getVisibility() == View.GONE
                        || imageView2.getVisibility() == View.INVISIBLE){
                    showRevalView2();
                }else{
                    hideRevalView2();
                }
                handler.postDelayed(this, 2000);
            }
        };
        handler.postDelayed(runnable, 2000);



        return rootView;
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        handler.removeCallbacks(runnable);
    }

    private void showRevalView() {
        // get the center for the clipping circle
//        int cx = (imageView.getLeft() + imageView.getRight()) / 2;
//        int cy = (imageView.getTop() + imageView.getBottom()) / 2;

        // get the final radius for the clipping circle
        int finalRadius = Math.max(imageView.getWidth(), imageView.getHeight());

        // create the animator for this view (the start radius is zero)
        Animator anim = ViewAnimationUtils.createCircularReveal(
                        imageView,
                        imageView.getWidth()/2,// 开始缩放点x位置
                        imageView.getHeight()/2,// 开始缩放点y位置
                        0,// 开始半径和结束半径
                        (float) Math.hypot(imageView.getWidth(), imageView.getHeight()));//hypot(double ,double ) 斜线的长度
        // make the view visible and start the animation
        imageView.setVisibility(View.VISIBLE);
        anim.setDuration(1000);
         /* Set a natural ease-in/ease-out interpolator. */
        anim.setInterpolator(new AccelerateDecelerateInterpolator());
        anim.start();
    }

    protected void hideRevalView() {
        // get the center for the clipping circle
//        int cx = (imageView.getLeft() + imageView.getRight()) / 2;
//        int cy = (imageView.getTop() + imageView.getBottom()) / 2;

        // get the final radius for the clipping circle
        int finalRadius = Math.max(imageView.getWidth(), imageView.getHeight());

// create the animator for this view (the start radius is zero)
        Animator anim = ViewAnimationUtils.createCircularReveal(
                        imageView,//对应的view
                        imageView.getWidth()/2,// 开始缩放点x位置
                        imageView.getHeight()/2,// 开始缩放点y位置
                        imageView.getWidth(),// 开始半径和结束半径
                        0);
        // make the view visible and start the animation
//        imageView.setVisibility(View.VISIBLE);
        anim.setDuration(1000);
             /* Set a natural ease-in/ease-out interpolator. */
        anim.setInterpolator(new AccelerateDecelerateInterpolator());
        anim.start();
        anim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                imageView.setVisibility(View.GONE);
            }
        });
    }

    private void showRevalView2() {


        Animator anim = ViewAnimationUtils.createCircularReveal(
                        imageView2,//对应的view
                0,// 开始缩放点x位置
                0,// 开始缩放点y位置
                        0,//开始半径
                        // 结束半径    hypot(double ,double ) 表示斜线的长度
                        (float) Math.hypot(imageView2.getWidth(), imageView2.getHeight()));
        // make the view visible and start the animation
        imageView2.setVisibility(View.VISIBLE);
        anim.setDuration(1000);
                    /* Set a natural ease-in/ease-out interpolator. */
        anim.setInterpolator(new AccelerateDecelerateInterpolator());
        anim.start();
    }

    private void hideRevalView2() {


        Animator anim = ViewAnimationUtils.createCircularReveal(
                        imageView2,//对应的view
                0,// 开始缩放点x位置
                0,// 开始缩放点y位置
                        // 开始半径和结束半径
                        (float) Math.hypot(imageView2.getWidth(), imageView2.getHeight()),0);
        // make the view visible and start the animation
//        imageView2.setVisibility(View.VISIBLE);
        anim.setDuration(1000);
                    /* Set a natural ease-in/ease-out interpolator. */
        anim.setInterpolator(new AccelerateDecelerateInterpolator());
        anim.start();
        anim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                imageView2.setVisibility(View.GONE);
            }
        });
    }

}
