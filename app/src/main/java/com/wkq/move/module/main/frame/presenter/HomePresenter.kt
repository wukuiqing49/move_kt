package com.wkq.move.module.main.frame.presenter

import android.util.Log
import com.wkq.base.frame.mosby.MvpBasePresenter
import com.wkq.move.module.main.frame.view.HomeView
import com.wkq.net.model.USTVShowInfo
import com.wkq.net.net.UsTvShowDataCallBack
import com.wkq.net.net.UsTvShowHtmlUtil

/**
 *
 * 作者:吴奎庆
 *
 * 时间:2020/5/15
 *
 * 用途:
 */


class HomePresenter :MvpBasePresenter<HomeView> (){
    fun getData() {
        UsTvShowHtmlUtil.getHomeUsTvShowData(object : UsTvShowDataCallBack<List<USTVShowInfo>> {
            override fun onFail(message: String?) {
                Log.e("", "")
            }

            override fun onSuccess(lists: List<USTVShowInfo>?) {
               if(view!=null)view.initData(lists)

            }

            override fun onLoading() {
                Log.e("", "")
            }
        });
    }
}