package a2018.by.step.musicplayer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_activity)
//        Thread {
//            Thread.sleep(1000)
            startActivity(Intent(applicationContext, MainActivity::class.java))
//        }
    }
}
