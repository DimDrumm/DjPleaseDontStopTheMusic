package a2018.by.step.musicplayer

import android.app.Application
import android.content.Context
import timber.log.Timber

class MusicPlayerApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        MusicPlayerApp.context = applicationContext
    }

    companion object {
        private lateinit var context: Context

        fun gContext(): Context {
            return context
        }
    }
}