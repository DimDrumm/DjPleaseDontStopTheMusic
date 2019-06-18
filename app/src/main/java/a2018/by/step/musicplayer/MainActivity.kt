package a2018.by.step.musicplayer

import a2018.by.step.musicplayer.fragment.SongFragment
import a2018.by.step.musicplayer.fragment.dummy.FakeContent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import timber.log.Timber

class MainActivity : AppCompatActivity(),SongFragment.OnListFragmentInteractionListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(R.id.main_activity, SongFragment.newInstance()).commit()
    }

    override fun onListFragmentInteraction(item: FakeContent.FakeItem?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
