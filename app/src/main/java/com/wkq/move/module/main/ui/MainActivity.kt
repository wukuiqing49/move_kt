package com.wkq.move.module.main.ui

import android.os.Bundle
import com.wkq.base.frame.activity.MvpBindingActivity
import com.wkq.base.utils.AlertUtil
import com.wkq.kd.MainPresenter
import com.wkq.kd.MainView
import com.wkq.lib_base.ui.FinishAllActivity
import com.wkq.move.R
import com.wkq.move.databinding.ActivityMainBinding

class MainActivity : MvpBindingActivity<MainView, MainPresenter, ActivityMainBinding>() {

    private var mainBackPressedTime: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (mvpView != null) mvpView.initView()

    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    /**
     * 返回
     */
    override fun onBackPressed() {
        if (mainBackPressedTime + 2000 > System.currentTimeMillis()) {
            super.onBackPressed()
            // 结束进程（热修复准备完成）
            FinishAllActivity.newInstance(this)
        } else {
            AlertUtil.showDeftToast(this, "再次点击 退出应用")
            mainBackPressedTime = System.currentTimeMillis()
        }

    }
}
