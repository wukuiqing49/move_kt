package com.wkq.move.module.main.ui.fragment

import android.os.Bundle
import android.view.View
import com.wkq.base.frame.fragment.MvpBindingFragment
import com.wkq.move.R
import com.wkq.move.databinding.FragmentClassificationBinding
import com.wkq.move.module.main.frame.presenter.ClassificationPresenter
import com.wkq.move.module.main.frame.view.ClassificationView

/**
 *
 * 作者:吴奎庆
 *
 * 时间:2020/5/17
 *
 * 用途:
 */


class ClassificationFragment :
    MvpBindingFragment<ClassificationView, ClassificationPresenter, FragmentClassificationBinding>() {

    companion object {
        fun newInstance(): ClassificationFragment {
            var fragment: ClassificationFragment = ClassificationFragment()
            return fragment
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_classification
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (mvpView != null) mvpView.initView()
    }
}