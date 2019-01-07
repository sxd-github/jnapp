package com.example.sxd.thanksgivinghall.task;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sxd.thanksgivinghall.R;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 待办任务列表
 */
public class ToDoTaskFragment extends Fragment {

    Unbinder unbinder;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_todo_task, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }
}
