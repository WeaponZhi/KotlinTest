package com.sojex.weaponzhi.kotlintest.web

import com.sojex.weaponzhi.kotlintest.common.domain.Command
import com.sojex.weaponzhi.kotlintest.common.domain.ForecastDataMapper
import com.sojex.weaponzhi.kotlintest.common.domain.ForecastList

/**
 * Created by admin on 2017/6/20.
 */
class RequestForecastCommand (val zipCode:String):Command<ForecastList>{
    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(forecastRequest.execute())
    }
}