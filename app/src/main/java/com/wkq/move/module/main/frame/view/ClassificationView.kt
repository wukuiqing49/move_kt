package com.wkq.move.module.main.frame.view

import android.content.Context
import com.wkq.base.frame.mosby.delegate.MvpView
import com.wkq.move.module.main.ui.adapter.ClassificationAdapter
import com.wkq.move.module.main.ui.fragment.ClassificationFragment

/**
 *
 * 作者:吴奎庆
 *
 * 时间:2020/5/17
 *
 * 用途:
 */


class ClassificationView : MvpView {

    var mFragment: ClassificationFragment
    var myAdapter: ClassificationAdapter? = null

    constructor(mFragment: ClassificationFragment) {
        this.mFragment = mFragment
    }

    fun initView() {
        myAdapter = ClassificationAdapter(
            mFragment.activity as Context,
            mFragment.activity!!.supportFragmentManager
        )
        mFragment.binding.vpContent.adapter = myAdapter
    }

}