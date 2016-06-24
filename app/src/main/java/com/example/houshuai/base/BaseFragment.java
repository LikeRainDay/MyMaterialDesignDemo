package com.example.houshuai.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Fragment的基类
 * Created by HouShuai on 2016/6/23.
 */

public abstract class BaseFragment extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initCreate();
        ButterKnife.bind(getActivity());
    }

    protected abstract void initCreate();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(setLayoutResID(), container, false);
        initView(view);
        return view;
    }

    protected abstract void initView(View view);

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initLayout();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }

    protected abstract void initLayout();

    protected abstract int setLayoutResID();

}
