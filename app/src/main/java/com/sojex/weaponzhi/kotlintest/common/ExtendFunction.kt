package com.sojex.weaponzhi.kotlintest.common

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

/**
 * 扩展函数集中文件
 * author:张冠之
 * time: 2017/6/20 14:09
 * e-mail: guanzhi.zhang@sojex.cn
 */

/**
 * 扩展函数
 */
fun Context.toast(message:String, duration: Int = Toast.LENGTH_SHORT){
    Toast.makeText(this,message,duration).show()
}
operator fun ViewGroup.get(position:Int): View = getChildAt(position)
