package a2018.by.step.musicplayer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mp3List = applicationContext.assets.list("")
            ?.filter { it.contains("mp3") }
        mp3List?.forEach { Timber.d(it) }
    }
}
