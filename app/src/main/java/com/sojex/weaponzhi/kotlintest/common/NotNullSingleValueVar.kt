package com.sojex.weaponzhi.kotlintest.common

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * NotNullSingleValueVar 自定义委托
 * author:张冠之
 * time: 2017/6/21 17:24
 * e-mail: guanzhi.zhang@sojex.cn
 */
private class NotNullSingleValueVar<T> : ReadWriteProperty<Any?,T>{
    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        this.value = if (this.value == null) value
        else throw IllegalStateException("already initialized")
    }

    private var value : T? = null
    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return value ?: throw IllegalStateException("not initialized")
    }

}
object DelegatesExt{
    fun <T> notNullSingleValue():ReadWriteProperty<Any?,T> = NotNullSingleValueVar()
}