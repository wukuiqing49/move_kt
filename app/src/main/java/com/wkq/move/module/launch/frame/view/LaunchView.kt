package com.wkq.move.module.launch.frame.view

import android.content.Intent
import android.os.Build
import android.view.View
import android.view.WindowManager
import com.wkq.base.frame.mosby.delegate.MvpView
import com.wkq.lib_base.utlis.StatusBarUtil
import com.wkq.move.MainActivity
import com.wkq.move.module.launch.ui.LaunchActivity

/**
 * 作者: 吴奎庆
 *
 * 时间: 2020/5/14
 *
 * 简介:
 */
class LaunchView : MvpView {

    var mContext: LaunchActivity

    constructor(mContext: LaunchActivity) {
        this.mContext = mContext
    }


    fun initView() {
        StatusBarUtil.setTransparentForWindow(mContext)
        StatusBarUtil.addTranslucentView(mContext, 0)
        StatusBarUtil.setLightMode(mContext)
        processFullScreen()
        mContext.presenter.startTimer(3000)
    }

    /**
     *   处理刘海屏全屏问题
     */
    fun processFullScreen() {

        val lp: WindowManager.LayoutParams = mContext.getWindow().getAttributes()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            lp.layoutInDisplayCutoutMode =
                WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES
        }
        mContext.getWindow().setAttributes(lp)
        // 设置页面全屏显示
        val decorView: View = mContext.getWindow().getDecorView()
        decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
    }

    fun finishTimer() {

        var intent :Intent =Intent();
        intent.setClass(mContext,MainActivity().javaClass)
        mContext.startActivity(intent)

    }

    fun onInterval(time: Long) {
        val x = (time + 1000) /1000 as Int
        mContext.binding.tvAdTime.setText("跳过  $x")
    }

}