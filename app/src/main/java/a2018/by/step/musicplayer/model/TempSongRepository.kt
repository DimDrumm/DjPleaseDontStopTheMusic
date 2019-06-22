package a2018.by.step.musicplayer.model

import a2018.by.step.musicplayer.MusicPlayerApp
import android.net.Uri
import timber.log.Timber
import java.util.*

//TODO: Replace all uses of this class before publishing your app.

object TempSongRepository {

    val ITEMS: MutableList<Song> = ArrayList()

    init {
        MusicPlayerApp.gContext().assets?.list("")?.filter { it.endsWith(".mp3") }?.forEach {
            Timber.d(it)
            ITEMS.add(
                Song(
                    it.substring(0, it.lastIndexOf(".mp3")),
                    "Unknown Artist",
                    0, Uri.parse(it)
                )
            )
        }
    }
}
