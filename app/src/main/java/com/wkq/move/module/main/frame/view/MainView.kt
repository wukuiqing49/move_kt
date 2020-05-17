package com.wkq.kd

import androidx.core.content.ContextCompat
import com.wkq.base.frame.mosby.delegate.MvpView
import com.wkq.lib_base.utlis.StatusBarUtil
import com.wkq.move.R
import com.wkq.move.module.main.ui.MainActivity
import com.wkq.move.module.main.ui.adapter.HomeFragmentPagerAdapter
import com.wkq.move.module.main.ui.widget.QMUITabSegment

/**
 * 作者: 吴奎庆
 *
 * 时间: 2020/5/8
 *
 * 简介:
 */

class MainView : MvpView {

    var mActivity: MainActivity

    constructor(mActivity: MainActivity) {
        this.mActivity = mActivity
    }

    fun initView() {
        StatusBarUtil.setTransparentForWindow(mActivity)
        StatusBarUtil.addTranslucentView(mActivity, 0)

       var mainAdapter= HomeFragmentPagerAdapter(mActivity,mActivity.supportFragmentManager)

        val component: QMUITabSegment.Tab = QMUITabSegment.Tab(
            ContextCompat.getDrawable(mActivity, R.drawable.ic_index_home_gray),
            ContextCompat.getDrawable(mActivity, R.drawable.ic_index_home),
            "美剧", false
        )

        val util: QMUITabSegment.Tab = QMUITabSegment.Tab(
            ContextCompat.getDrawable(mActivity, R.drawable.ic_index_dashboard_gray),
            ContextCompat.getDrawable(mActivity, R.drawable.ic_index_dashboard),
            "分类", false
        )
        val novel: QMUITabSegment.Tab = QMUITabSegment.Tab(
            ContextCompat.getDrawable(mActivity, R.drawable.ic_index_notifications_gray),
            ContextCompat.getDrawable(mActivity, R.drawable.ic_index_notifications),
            "小说", false
        )
        val lab: QMUITabSegment.Tab = QMUITabSegment.Tab(
            ContextCompat.getDrawable(mActivity, R.drawable.ic_fly_refresh_developer_gray),
            ContextCompat.getDrawable(mActivity, R.drawable.ic_fly_refresh_developer),
            "我的", false
        )

        mActivity.binding.tabs.addTab(component)
            .addTab(util)
            .addTab(novel)
            .addTab(lab)

        mActivity.binding.tabs.setDefaultNormalColor(mActivity.resources.getColor(R.color.color_n))
        mActivity.binding.tabs.setDefaultSelectedColor(mActivity.resources.getColor(R.color.color_s))
        mActivity.binding.pager.adapter = mainAdapter
        mActivity.binding.pager.offscreenPageLimit = 4
        mActivity.binding.tabs.setupWithViewPager(mActivity.binding.pager, false)

        mActivity.binding.tabs.setOnTabClickListener(object : QMUITabSegment.OnTabClickListener{
            override fun onTabClick(index: Int) {
                when(index){
                    0 -> StatusBarUtil.setDarkMode(mActivity)
                    1 -> StatusBarUtil.setDarkMode(mActivity)
                    2 -> StatusBarUtil.setDarkMode(mActivity)
                }
            }
        })

    }

}