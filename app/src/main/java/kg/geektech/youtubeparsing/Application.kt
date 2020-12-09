package kg.geektech.youtubeparsing

import android.app.Application
import kg.geektech.youtubeparsing.di.dbModule
import kg.geektech.youtubeparsing.di.networkModule
import kg.geektech.youtubeparsing.di.repositoryModule
import kg.geektech.youtubeparsing.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@App)
                modules(listOf(networkModule, viewModelModule, dbModule, repositoryModule))
            }
    }
}