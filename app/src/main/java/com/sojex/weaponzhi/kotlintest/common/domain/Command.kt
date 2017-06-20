package com.sojex.weaponzhi.kotlintest.common.domain

/**
 * Created by admin on 2017/6/20.
 */
interface Command<T> {
    fun execute():T
}