package com.fetch_test.listerdemo.app

import android.app.Application
import com.fetch_test.listerdemo.BuildConfig
import timber.log.Timber

class ListerApp : Application() {
    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}