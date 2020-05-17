package com.wkq.move.module.main.frame.view

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.appbar.AppBarLayout
import com.wkq.base.frame.mosby.delegate.MvpView
import com.wkq.lib_base.utlis.StatusBarUtil
import com.wkq.move.R
import com.wkq.move.module.main.ui.adapter.HomeAdapter
import com.wkq.move.module.main.ui.fragment.HomeFragment
import com.wkq.net.model.USTVShowInfo

/**
 *
 * 作者:吴奎庆
 *
 * 时间:2020/5/15
 *
 * 用途:
 */

class HomeView : MvpView {

    var mFragment: HomeFragment
    var mAdapter: HomeAdapter? = null

    constructor(mFragment: HomeFragment) {
        this.mFragment = mFragment
    }


    fun initView() {
        mFragment.binding.appbarLayout.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
            if (Math.abs(verticalOffset) >= appBarLayout.totalScrollRange) {
                if (!mFragment.isExpend) {
                    StatusBarUtil.setDarkMode(mFragment.activity)
                    mFragment.isExpend = !mFragment.isExpend
                    mFragment.binding.toolbar.visibility = View.VISIBLE
                    mFragment.binding.tvTitle.visibility = View.VISIBLE
                }
            } else {
                if (mFragment.isExpend) {
                    StatusBarUtil.setDarkMode(mFragment.activity)
                    mFragment.isExpend = !mFragment.isExpend
                    mFragment.binding.toolbar.visibility = View.GONE
                    mFragment.binding.tvTitle.visibility = View.GONE
                }
            }
        })

        mFragment.binding.rvSf.isEnableRefresh = false
        mFragment.binding.rvSf.isEnableLoadMore = false

        mAdapter = HomeAdapter(mFragment.activity as Context, R.layout.item_home)

        mFragment.binding.rvMovies.layoutManager = GridLayoutManager(mFragment.activity,3)
        mFragment.binding.rvMovies.adapter = mAdapter
    }

    fun initData(lists: List<USTVShowInfo>?) {
        mAdapter?.addItems(lists?.toMutableList())
    }

}


