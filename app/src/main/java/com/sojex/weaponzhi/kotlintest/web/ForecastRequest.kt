package com.sojex.weaponzhi.kotlintest.web

/**
 * ForecastRequest 请求类
 * author:张冠之
 * time: 2017/6/19 16:55
 * e-mail: guanzhi.zhang@sojex.cn
 */
public class ForecastRequest(val zipCode:String){
    companion object{
        private val APP_ID = "15646a06818f61f7b8d7823ca833e1ce"
        private val URL = "http://api.openweathermap.org/data/2.5/"+"forecast/daily?mode=json&units=metric&cnt=7"
        private val COMPLETE_URL = "$URL&APPID=$APP_ID&q="
    }

    fun execute():ForecastRequest{
        val forecastJsonStr = URL(COMPLETE_URL + zipCode).readText()
        return 
    }
}