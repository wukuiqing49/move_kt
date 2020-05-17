package com.wkq.move.module.main.ui.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.wkq.move.module.main.ui.fragment.HomeFragment

/**
 *
 * 作者:吴奎庆
 *
 * 时间:2020/5/17
 *
 * 用途:
 */


class ClassificationAdapter : FragmentPagerAdapter {

    var mContext: Context

    constructor(context: Context, fm: FragmentManager) : super(fm) {

        mContext = context

    }

    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = HomeFragment.Companion.newInstance()
            1 -> fragment = HomeFragment.Companion.newInstance()
            2 -> fragment = HomeFragment.Companion.newInstance()
            3 -> fragment = HomeFragment.Companion.newInstance()
            4 -> fragment = HomeFragment.Companion.newInstance()
            5 -> fragment = HomeFragment.Companion.newInstance()

        }

        return fragment!!
    }

    override fun getCount(): Int {
        return 6
    }

}