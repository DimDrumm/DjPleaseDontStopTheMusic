package a2018.by.step.musicplayer

import android.app.Application
import timber.log.Timber

class MusicPlayerApp : Application(){
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}