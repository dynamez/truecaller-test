package com.example.truecallertest

import android.app.Application
import com.example.truecallertest.di.appModule
import org.koin.core.context.GlobalContext.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(appModule)
        }
    }
}
