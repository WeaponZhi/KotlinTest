package com.sojex.weaponzhi.kotlintest.common

import android.content.Context
import android.os.Build
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

/**
 * 重载 ViewGroup[] 操作符
 */
operator fun ViewGroup.get(position:Int): View = getChildAt(position)

/**
 * 内联函数：检查版本，如果版本大于 lollipop 或者更高版本才能执行
 *
 *   supportsLollipop{
 *
 *       window.setStatusBarColor(Color.BLACK)
 *
 *   }
 *
 */
inline fun supportsLollipop(code:()->Unit){
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
        code()
    }
}
