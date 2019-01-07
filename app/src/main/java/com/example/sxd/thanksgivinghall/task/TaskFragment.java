package com.example.sxd.thanksgivinghall.task;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sxd.thanksgivinghall.R;
import com.example.sxd.thanksgivinghall.adapter.FragmentAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class TaskFragment extends Fragment {

    @BindView(R.id.viewpager)
    ViewPager mViewPager;
    private TabLayout mTabLayout;
    Integer size = 2;

    Unbinder unbinder;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_notice_main, container, false);
        mTabLayout =  view.findViewById(R.id.tabs);
        unbinder = ButterKnife.bind(this, view);
        initViewPager();
        return view;
    }

    private void initViewPager() {

        List<String> titles = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            titles.add("待办任务");
            titles.add("已发布任务");
        }
        for (int i = 0; i < size; i++) {
            mTabLayout.addTab(mTabLayout.newTab().setText(titles.get(i)));
        }
        List<Fragment> fragments = new ArrayList<>();

        fragments.add(new ToDoTaskFragment());
        fragments.add(new PublishedTaskActivity());


        FragmentAdapter mFragmentAdapteradapter =
                new FragmentAdapter(getFragmentManager(), fragments, titles);
        //给ViewPager设置适配器
        mViewPager.setAdapter(mFragmentAdapteradapter);
        //将TabLayout和ViewPager关联起来。
        mTabLayout.setupWithViewPager(mViewPager);
        //给TabLayout设置适配器
        mTabLayout.setTabsFromPagerAdapter(mFragmentAdapteradapter);
    }
}
