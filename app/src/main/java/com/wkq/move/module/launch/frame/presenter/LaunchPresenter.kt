package com.wkq.move.module.launch.frame.presenter

import android.util.Log
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
    var timerUtil: TimerWaitUtil? = null

    fun startTimer(startTime: Long) {
        timerUtil = TimerWaitUtil()
        timerUtil!!.totalTime = startTime
        timerUtil!!.intervalTime = 100
        timerUtil!!.setTimerLiener(object : TimerWaitUtil.TimeListener {
            override fun onFinish() {
                if (view != null) view.finishTimer()
            }

            override fun onInterval(time: Long) {
                if (view != null) view.onInterval(time)
            }

        })
        timerUtil!!.start()

    }


    fun resume() {
        if (timerUtil != null) timerUtil!!.resume()

    }

    fun stop() {
        if (timerUtil != null) timerUtil!!.pause()

    }

}