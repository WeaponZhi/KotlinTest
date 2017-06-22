package com.sojex.weaponzhi.kotlintest.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.sojex.weaponzhi.kotlintest.App
import com.sojex.weaponzhi.kotlintest.database.table.CityForecastTable
import com.sojex.weaponzhi.kotlintest.database.table.DayForecastTable
import org.jetbrains.anko.db.*

/**
 * Created by admin on 2017/6/22.
 * 使用依赖注入
 */
class ForecastDbHelper(ctx:Context = App.instance) : ManagedSQLiteOpenHelper(ctx, ForecastDbHelper.DB_NAME, null, ForecastDbHelper.DB_VERSION) {

    companion object {
        val DB_NAME = "forecast.db"
        val DB_VERSION = 1
        //lazy 委托是线程安全的，它可以阻止在不同线程中创建多个对象。
        val instance: ForecastDbHelper by lazy { ForecastDbHelper() }
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.createTable(CityForecastTable.NAME,true,
                CityForecastTable.ID to INTEGER + PRIMARY_KEY,
                CityForecastTable.CITY to TEXT,
                CityForecastTable.COUNTRY to TEXT)

        db.createTable(DayForecastTable.NAME,true,
                DayForecastTable.ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
                DayForecastTable.DESCRIPTION to TEXT,
                DayForecastTable.HIGH to INTEGER,
                DayForecastTable.LOW to INTEGER,
                DayForecastTable.ICON_URL to TEXT,
                DayForecastTable.CITY_ID to INTEGER)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.dropTable(CityForecastTable.NAME,true)
        db.dropTable(DayForecastTable.NAME,true)
        onCreate(db)
    }


}