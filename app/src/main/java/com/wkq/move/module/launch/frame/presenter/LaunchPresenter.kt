package com.wkq.move.module.launch.frame.presenter

import com.wkq.base.frame.mosby.MvpBasePresenter
import com.wkq.lib_base.utlis.TimerWaitUtil
import com.wkq.move.module.launch.frame.view.LaunchView

/**
 * 作者: 吴奎庆
 *
 * 时间: 2020/5/14
 *
 * 简介:
 */
class LaunchPresenter : MvpBasePresenter<LaunchView>() {

    fun startTimer(startTime: Long) {
        var timer: TimerWaitUtil = TimerWaitUtil()
        timer.totalTime = startTime
        timer.intervalTime=100
        timer.setTimerLiener(object :TimerWaitUtil.TimeListener{
            override fun onFinish() {
                if (view!=null)view.finishTimer()
            }

            override fun onInterval(time: Long) {
                if (view!=null)view.onInterval(time)
            }

        })
        timer.start()

    }
}