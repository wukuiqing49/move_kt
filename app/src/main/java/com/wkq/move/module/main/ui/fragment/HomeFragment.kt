package com.wkq.move.module.main.ui.fragment

import android.os.Bundle
import android.view.View
import com.wkq.base.frame.fragment.MvpBindingFragment
import com.wkq.move.R
import com.wkq.move.databinding.FragmentHomeBinding
import com.wkq.move.module.main.frame.presenter.HomePresenter
import com.wkq.move.module.main.frame.view.HomeView

/**
 *
 * 作者:吴奎庆
 *
 * 时间:2020/5/15
 *
 * 用途:
 */


class HomeFragment : MvpBindingFragment<HomeView, HomePresenter, FragmentHomeBinding>() {
    companion object {
        fun newInstance(): HomeFragment {
            var bandle: Bundle = Bundle()
            bandle.putString("key", "1")
            var home: HomeFragment = HomeFragment()
            home.arguments = bandle
            return home

        }
    }

    var isExpend = false

    override fun getLayoutId(): Int {
        return R.layout.fragment_home
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (mvpView != null) mvpView.initView()
        if (getPresenter() != null) getPresenter().getData()
    }

}