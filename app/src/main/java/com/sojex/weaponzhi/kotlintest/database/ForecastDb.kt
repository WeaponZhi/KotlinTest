package com.sojex.weaponzhi.kotlintest.database

import com.sojex.weaponzhi.kotlintest.common.domain.ForecastDataMapper

/**
 * Created by admin on 2017/6/23.
 */
class ForecastDb(
    val forecastDbHelper:ForecastDbHelper = ForecastDbHelper.instance,
    val dataMapper:ForecastDataMapper = ForecastDataMapper()){

    fun requestForecastByZipCode(zipCode:Long,date:Long) = forecastDbHelper.use {  }
}
