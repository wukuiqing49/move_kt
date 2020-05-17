package com.wkq.move.module.main.ui.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.wkq.move.module.main.ui.fragment.ClassificationFragment;
import com.wkq.move.module.main.ui.fragment.HomeFragment;

/**
 * 作者:吴奎庆
 * <p>
 * 时间:2019-12-21
 * <p>
 * 用途:
 */


public class HomeFragmentPagerAdapter extends FragmentPagerAdapter {

    Context context;

    public HomeFragmentPagerAdapter(Context context, @NonNull FragmentManager fm) {
        super(fm);
        this.context = context;
    }

    @NonNull
    @Override

    public Fragment getItem(int position) {

        Fragment fragment = null;

        switch (position) {

            case 0:
//                fragment = MoveDbComingFragment.newInstance(context);
                fragment = HomeFragment.Companion.newInstance();


                break;
            case 1:
                fragment = ClassificationFragment.Companion.newInstance();

                break;
            case 2:
                fragment = HomeFragment.Companion.newInstance();

                break;

            case 3:
                fragment = HomeFragment.Companion.newInstance();

                break;

        }

        return fragment;
    }

    @Override
    public int getCount() {
        return 4;
    }
}
