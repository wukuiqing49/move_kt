package com.wkq.lib_base.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

/**
 * 作者: 吴奎庆
 *
 * 时间: 2020/5/9
 *
 * 简介:
 */
open class KtDataBindingAdapter<T>(context: Context, layoutId: Int) : KtBaseRvAdapter<T>(context) {

    var layoutId: Int

    init {
        this.mContext = context
        this.layoutId = layoutId
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var viedataBinding: ViewDataBinding =
            DataBindingUtil.inflate(LayoutInflater.from(mContext), layoutId, parent, false)
        var dataBindingViewHolder: KtDataBindingViewHolder =
            KtDataBindingViewHolder(viedataBinding.root)
        dataBindingViewHolder.setBinding(viewBinding = viedataBinding)
        return dataBindingViewHolder

    }

    override fun getItemCount(): Int {
        return itemList?.size ?: 0
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var ktHolder = holder as? KtDataBindingViewHolder
        ktHolder?.getBinding()?.executePendingBindings()
    }
}