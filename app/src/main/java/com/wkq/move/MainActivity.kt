package com.wkq.move

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wkq.base.frame.activity.MvpBindingActivity
import com.wkq.kd.MainPresenter
import com.wkq.kd.MainView
import com.wkq.lib_base.adapter.KtDataBindingAdapter
import com.wkq.lib_base.utlis.StatusBarUtil
import com.wkq.move.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : MvpBindingActivity<MainView, MainPresenter, ActivityMainBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        StatusBarUtil.setTranslucent(this)
        StatusBarUtil.setColor(this, resources.getColor(R.color.color_white),0)

        tv.setOnClickListener { v: View? ->
            Toast.makeText(this, "ceshi", Toast.LENGTH_LONG).show()
        }

        var mAdapter = DemoAdapter(this, R.layout.item_demo)
        mAdapter.addItem("666")
        rv.layoutManager = LinearLayoutManager(this)

        rv.adapter = mAdapter
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }
}
