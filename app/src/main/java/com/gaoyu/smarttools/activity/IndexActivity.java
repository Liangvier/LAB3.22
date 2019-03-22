package com.gaoyu.smarttools.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.widget.Toast;

import com.gaoyu.smarttools.R;
import com.gaoyu.smarttools.fragmentadapter.FragmentAdapter;

import java.util.ArrayList;
import java.util.List;


public class IndexActivity extends BaseActivity implements ViewPager.OnPageChangeListener {
    private List<Fragment> fragmentList;
    private ViewPager pager;
    private PagerTabStrip pagerTabStrip;
    private List<String> stringList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        inItUI();
    }

    //初始化UI
    private void inItUI() {
        //标题
        stringList = new ArrayList<>();
        stringList.add("AIRcontoal");
        stringList.add("TV");
        stringList.add("MORE");
        //数据源
        fragmentList = new ArrayList<>();
        fragmentList.add(new AirConditionerFragment());
        fragmentList.add(new TelevisionFragment());
        fragmentList.add(new TvBoxFragment());
        //标题样式
        pagerTabStrip = (PagerTabStrip) findViewById(R.id.Pt_tab);
        pagerTabStrip.setBackgroundColor(Color.YELLOW);
        pagerTabStrip.setTextColor(Color.RED);
        //分割线
        pagerTabStrip.setDrawFullUnderline(false);
        pagerTabStrip.setTabIndicatorColor(Color.GREEN);
        //viewPager实例化
        pager = (ViewPager) findViewById(R.id.vp_SideSlip);
        FragmentAdapter myfragmentadapter1 = new FragmentAdapter(getSupportFragmentManager(), fragmentList, stringList);
        pager.setAdapter(myfragmentadapter1);
        pager.setOnPageChangeListener(this);

    }

