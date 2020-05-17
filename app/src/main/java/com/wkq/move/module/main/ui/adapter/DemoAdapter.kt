package com.wkq.move.module.main.ui.adapter

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.wkq.lib_base.adapter.KtDataBindingAdapter
import com.wkq.lib_base.adapter.KtDataBindingViewHolder
import com.wkq.move.databinding.ItemDemoBinding

/**
 * 作者: 吴奎庆
 *
 * 时间: 2020/5/14
 *
 * 简介:
 */
class DemoAdapter(context: Context, layoutId: Int) :
    KtDataBindingAdapter<String>(context, layoutId) {

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        val videoListViewHolder: KtDataBindingViewHolder = holder as KtDataBindingViewHolder
        var itemBinding: ItemDemoBinding = videoListViewHolder.getBinding() as ItemDemoBinding
        itemBinding.tvTest.setText(getItem(position))
    }

}