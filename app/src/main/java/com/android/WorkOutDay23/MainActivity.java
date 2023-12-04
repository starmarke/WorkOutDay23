package com.android.WorkOutDay23;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;

import com.android.WorkOutDay23.adapter.ViewPagerAdapter;
import com.android.WorkOutDay23.base.BaseActivity;
import com.android.WorkOutDay23.databinding.ActivityMainBinding;
import com.android.WorkOutDay23.fragment.HomeFragment;
import com.android.WorkOutDay23.fragment.PersonalFragment;
import com.android.WorkOutDay23.fragment.RewardFragment;
import com.android.WorkOutDay23.fragment.SportFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.gyf.immersionbar.ImmersionBar;

public class MainActivity extends BaseActivity {

    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(mBinding.getRoot());

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new HomeFragment());
        viewPagerAdapter.addFragment(new SportFragment());
        viewPagerAdapter.addFragment(new PersonalFragment());
        viewPagerAdapter.addFragment(new RewardFragment());

        mBinding.viewPager.setAdapter(viewPagerAdapter);

        ImmersionBar.with(this)
                .fitsSystemWindows(true)
                .statusBarColor(R.color.white)
                .statusBarDarkFont(true)
                .init();

        mBinding.bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        mBinding.viewPager.setCurrentItem(0);
                        return true;
                    case R.id.navigation_sport:
                        mBinding.viewPager.setCurrentItem(1);
                        return true;
                    case R.id.navigation_personal:
                        mBinding.viewPager.setCurrentItem(2);
                        return true;
                    case R.id.navigation_reward:
                        mBinding.viewPager.setCurrentItem(3);
                        return true;
                }
                return false;
            }
        });

        mBinding.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                mBinding.bottomNavigationView.getMenu().getItem(position).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

    }
}