package com.example.houshuai.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by HouShuai on 2016/6/23.
 */

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        Window window = getWindow();
//        WindowManager.LayoutParams attributes =
//                window.getAttributes();
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
//            if ((attributes.flags & bits) == 0) {
//                attributes.flags |= bits;
//                window.setAttributes(attributes);
//            }
//        }
        super.onCreate(savedInstanceState);
        setContentView(inflateLayoutId());
        ButterKnife.bind(this);
        initView();
        initLayout();

    }


    protected abstract void initView();

    protected abstract void initLayout();

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    protected abstract int inflateLayoutId();

}
