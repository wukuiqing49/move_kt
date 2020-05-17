package com.wkq.lib_base.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle

/**
 *
 * 作者:吴奎庆
 *
 * 时间:2020/5/16
 *
 * 用途:
 */


class FinishAllActivity : Activity() {

    companion object {
        fun newInstance(context: Activity) {
            var intent: Intent = Intent()
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        finishAll()
    }

    fun finishAll() {
        var intent: Intent = Intent()
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
    }
}