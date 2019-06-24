package a2018.by.step.musicplayer

import a2018.by.step.musicplayer.model.TempSongRepository
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_activity)
        TempSongRepository.ITEMS
        startActivity(Intent(applicationContext, MainActivity::class.java))
        finish()
    }
}
