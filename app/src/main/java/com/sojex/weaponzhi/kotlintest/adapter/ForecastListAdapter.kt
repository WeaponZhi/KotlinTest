package com.sojex.weaponzhi.kotlintest.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView
import com.sojex.weaponzhi.kotlintest.common.domain.ForecastList

/**
 * ForecastListAdapter RecyclerView 的 Adapter
 * author:张冠之
 * time: 2017/6/19 15:37
 * e-mail: guanzhi.zhang@sojex.cn
 */
class ForecastListAdapter(val weekForecast:ForecastList):RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {
    override fun getItemCount(): Int = weekForecast.size()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //操作符重载
        with(weekForecast[position]){
            holder.textView.text = "$date - $description - $high/$low"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder?{
        return ViewHolder(TextView(parent.context))
    }

    class ViewHolder(val textView : TextView):RecyclerView.ViewHolder(textView)
}