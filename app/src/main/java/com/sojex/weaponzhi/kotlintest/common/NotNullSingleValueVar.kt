package com.sojex.weaponzhi.kotlintest.common

import android.content.Context
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * NotNullSingleValueVar 自定义委托
 * author:张冠之
 * time: 2017/6/21 17:24
 * e-mail: guanzhi.zhang@sojex.cn
 */
private class NotNullSingleValueVar<T> : ReadWriteProperty<Any?, T> {
    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        this.value = if (this.value == null) value
        else throw IllegalStateException("already initialized")
    }

    private var value: T? = null
    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return value ?: throw IllegalStateException("not initialized")
    }

}

/**
 * 泛型 preference 委托
 */
class Preference<T>(val context: Context, val name: String, val default: T)
    : ReadWriteProperty<Any?, T> {

    val prefs by lazy { context.getSharedPreferences("default", Context.MODE_PRIVATE) }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        putPreference(name,value)
    }

    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return findPreference(name,default)
    }

    private fun <T> findPreference(name:String,default:T):T = with(prefs){
        val res:Any = when(default){
            is Long -> getLong(name,default)
            is String -> getString(name,default)
            is Int -> getInt(name,default)
            is Boolean -> getBoolean(name,default)
            is Float -> getFloat(name,default)
            else -> throw IllegalArgumentException("This type can't be saved into Preferences")
        }
        res as T
    }

    private fun <U> putPreference(name:String ,value: U) = with(prefs.edit()){
        when(value){
            is Long -> putLong(name,value)
            is String -> putString(name,value)
            is Int -> putInt(name,value)
            is Boolean -> putBoolean(name,value)
            is Float -> putFloat(name,value)
            else -> throw IllegalArgumentException("This type can't be saved into Preferences")
        }.apply()
    }

}

object DelegatesExt {

    fun <T> notNullSingleValue(): ReadWriteProperty<Any?, T> = NotNullSingleValueVar()

    fun <T:Any> preference(context: Context, name: String, default:T) = Preference(context,name,default)
}