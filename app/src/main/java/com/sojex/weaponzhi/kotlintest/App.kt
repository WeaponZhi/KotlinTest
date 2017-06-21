package com.sojex.weaponzhi.kotlintest

import android.app.Application
import com.sojex.weaponzhi.kotlintest.common.DelegatesExt

/**
 * Created by admin on 2017/6/21.
 */
class App : Application(){
    companion object{
        var instance : App by DelegatesExt.notNullSingleValue()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}