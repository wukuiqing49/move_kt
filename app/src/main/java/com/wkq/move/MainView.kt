package com.wkq.kd

import com.wkq.base.frame.mosby.delegate.MvpView
import com.wkq.move.MainActivity

/**
 * 作者: 吴奎庆
 *
 * 时间: 2020/5/8
 *
 * 简介:
 */

class MainView : MvpView {
    var test: MainActivity

    constructor(test: MainActivity) {
        this.test = test
    }
}