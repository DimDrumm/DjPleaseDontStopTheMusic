package a2018.by.step.musicplayer

import a2018.by.step.musicplayer.fragment.SongFragment
import a2018.by.step.musicplayer.fragment.SongListFragment
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber

class MainActivity : AppCompatActivity(), SongListFragment.ISongItemClickListener {
    override fun onSongClicked(item: Int) {
        Timber.d("Activity knows that item $item have been clicked")
        fl_container_song.visibility = View.VISIBLE
        fl_container_song.scaleY=0.0f
        supportFragmentManager.beginTransaction().replace(
            R.id.fl_container_song,
            SongFragment.newInstance(item)
        ).commit()
        fl_container_song.animate().scaleY(1.0f).setDuration(1000).start()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(R.id.fl_container_song_list, SongListFragment.newInstance())
            .commit()
        Timber.d("FragmentManager backStack: ${supportFragmentManager.backStackEntryCount}")
    }
}
