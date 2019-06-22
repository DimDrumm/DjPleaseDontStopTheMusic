package a2018.by.step.musicplayer

import a2018.by.step.musicplayer.fragment.SongFragment
import a2018.by.step.musicplayer.fragment.SongListFragment
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import timber.log.Timber

class MainActivity : AppCompatActivity(), SongListFragment.ISongItemClickListener {
    override fun onSongClicked(item: Int) {
        Timber.d("Activity knows that item $item have been clicked")
        supportFragmentManager.beginTransaction().replace(
            R.id.fl_container_song,
            SongFragment.newInstance(item)
        ).commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(R.id.fl_container_song_list, SongListFragment.newInstance())
            .commit()
        Timber.d("FragmentManager backStack: ${supportFragmentManager.backStackEntryCount}")
    }
}
