package com.adi.demo

import android.app.Application
import android.content.Context
import com.adi.ADIConfig
import com.adi.ADIManager
import com.tencent.matrix.iocanary.core.IOCanaryCore

/**
 * @author zhoukewen
 * @since 2019-10-31
 */
class MyApplication : Application() {

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        val core = IOCanaryCore()
        core.start()
        ADIManager.init(this)
        val builder = ADIConfig.Builder()
        builder.setEventType(ADIConfig.Type.BRIEF_INFORMATION)
        ADIManager.start(this, builder.build())
    }

    override fun onCreate() {
        super.onCreate()
    }
}