package a2018.by.step.musicplayer

import a2018.by.step.musicplayer.fragment.SongFragment
import a2018.by.step.musicplayer.fragment.SongListFragment
import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber

const val CODE_REQUEST_READ_EXTERNAL_STORAGE = 501

class MainActivity : AppCompatActivity(), SongListFragment.ISongItemClickListener {
    override fun onSongClicked(item: Int) {
        Timber.d("Activity knows that item $item have been clicked")
        fl_container_song.visibility = View.VISIBLE
        fl_container_song.scaleY = 0.0f
        supportFragmentManager.beginTransaction().replace(
            R.id.fl_container_song,
            SongFragment.newInstance(item)
        ).commit()
        fl_container_song.animate().scaleY(1.0f).setDuration(1000).start()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.READ_EXTERNAL_STORAGE ) == PackageManager.PERMISSION_GRANTED
        ) {
            continueWithPermission()
        } else {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE), CODE_REQUEST_READ_EXTERNAL_STORAGE
            )
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int, permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            CODE_REQUEST_READ_EXTERNAL_STORAGE -> {
                if (permissions[0] == Manifest.permission.READ_EXTERNAL_STORAGE) {
                    if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                        continueWithPermission()
                    } else {
                        continueWithoutPermission()
                    }
                }
            }
        }
    }

    private fun continueWithPermission() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fl_container_song_list, SongListFragment.newInstance())
            .commit()
    }

    private fun continueWithoutPermission() {
        Timber.d("User has denied permission ${Manifest.permission.READ_EXTERNAL_STORAGE}")
        Toast.makeText(this,"You are so rude, maaaan!",Toast.LENGTH_SHORT).show()
        finish()
    }
}
