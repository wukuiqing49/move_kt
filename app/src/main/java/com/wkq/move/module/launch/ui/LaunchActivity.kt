package com.wkq.move.module.launch.ui

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import com.wkq.base.frame.activity.MvpBindingActivity
import com.wkq.move.R
import com.wkq.move.databinding.ActivityLaunchBinding
import com.wkq.move.module.launch.frame.presenter.LaunchPresenter
import com.wkq.move.module.launch.frame.view.LaunchView

/**
 * 作者: 吴奎庆
 *
 * 时间: 2020/5/14
 *
 * 简介:
 */
class LaunchActivity : MvpBindingActivity<LaunchView, LaunchPresenter, ActivityLaunchBinding>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_launch
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (mvpView !=null)mvpView.initView()
    }
}