package com.example.app

import android.app.Application
import com.example.app.hilt.HiltSimple
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

/**
 * @Date 執筆時間 2021/01/11 16:05
 * @Author Caden
 * @Description
 * @Email code_legend@163.com
 * @Vesion 1.0
 */
@HiltAndroidApp
class App : Application() {
    @Inject
    lateinit var mHiltSimple: HiltSimple

    override fun onCreate() {
        super.onCreate()
        mHiltSimple.doSomething()
    }


}