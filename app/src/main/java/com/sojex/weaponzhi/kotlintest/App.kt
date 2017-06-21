package com.sojex.weaponzhi.kotlintest

import android.app.Application

/**
 * Created by admin on 2017/6/21.
 */
class App : Application(){
    companion object{
        private var instance : Application?=null
        fun instance() = instance!!
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}