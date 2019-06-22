package a2018.by.step.musicplayer

import a2018.by.step.musicplayer.fragment.SongListFragment
import a2018.by.step.musicplayer.model.Song
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import timber.log.Timber

class MainActivity : AppCompatActivity(),SongListFragment.OnListFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().
            replace(R.id.fl_container_song_list,SongListFragment.newInstance()).commit()
        Timber.d("FragmentManager backStack: ${supportFragmentManager.backStackEntryCount}")
    }

    override fun onListFragmentInteraction(item: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
