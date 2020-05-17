package com.wkq.move.module.main.ui.adapter

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.request.RequestOptions
import com.wkq.lib_base.adapter.KtDataBindingAdapter
import com.wkq.lib_base.adapter.KtDataBindingViewHolder
import com.wkq.move.R
import com.wkq.move.databinding.ItemHomeBinding
import com.wkq.move.utlis.GlideRoundedCornersTransform
import com.wkq.net.model.USTVShowInfo

/**
 *
 * 作者:吴奎庆
 *
 * 时间:2020/5/17
 *
 * 用途:
 */


class HomeAdapter(context: Context, layoutId: Int) :
    KtDataBindingAdapter<USTVShowInfo>(context, layoutId) {

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        var ktHolder: KtDataBindingViewHolder = holder as KtDataBindingViewHolder
        var binding = ktHolder.getBinding() as ItemHomeBinding
        binding.data = getItem(position)
        val options: RequestOptions = RequestOptions.bitmapTransform(
            GlideRoundedCornersTransform(5f, GlideRoundedCornersTransform.CornerType.ALL)
        ).placeholder(R.drawable.bg_image_loading).error(R.drawable.bg_image_loading)
            .priority(Priority.HIGH)
        Glide.with(mContext).apply { options }.load(getItem(position)?.tvPoster)
            .into(binding.ivHome)
    }
}