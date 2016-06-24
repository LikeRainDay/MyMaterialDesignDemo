package com.example.houshuai.mymaterialdesigndemo;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;

import com.example.houshuai.base.BaseActivity;
import com.example.houshuai.fragment.FirstFragment;
import com.example.houshuai.fragment.ThreeFragment;
import com.example.houshuai.fragment.TwoFragment;

import java.util.LinkedList;
import java.util.List;

import butterknife.BindView;

//登录界面ACtivity
public class MainActivity extends BaseActivity {
    @BindView(R.id.tl_title)
    Toolbar mToolBar;
    @BindView(R.id.tb_BottomTitle)
    TabLayout mTablayout;

    protected void initView() {
        setSupportActionBar(mToolBar);
        // 准备tablayout的数据源
        initTablayoutView();
    }

    private void initTablayoutView() {
        String[] stringArray = getResources().getStringArray(R.array.tabLayoutData);
        for (int i = 0; i < stringArray.length; i++) {
            TabLayout.Tab tab = mTablayout.newTab();
            tab.setText(stringArray[i]);
            mTablayout.addTab(tab);
        }
    }

    private void initTablayout() {
        mTablayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Fragment> fragments = new LinkedList<>();
                fragments.add(new FirstFragment());
                fragments.add(new TwoFragment());
                fragments.add(new ThreeFragment());
                android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                switch (view.getId()) {
                    case R.id.menu_01:
                        fragmentTransaction.replace(R.id.fl_BaseFragment, fragments.get(0)).addToBackStack(null).commit();
                        break;
                    case R.id.menu_02:
                        fragmentTransaction.replace(R.id.fl_BaseFragment, fragments.get(1)).addToBackStack(null).commit();
                        break;
                    case R.id.menu_03:
                        fragmentTransaction.replace(R.id.fl_BaseFragment, fragments.get(2)).addToBackStack(null).commit();
                        break;
                    default:
                        break;
                }
            }
        });
    }


    @Override
    protected void initLayout() {
        //初始化跳转的各个界面
        initTablayout();

    }

    @Override
    protected int inflateLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.bottom_menu, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //收缩CollpaseActionbar


        return true;
    }
}
