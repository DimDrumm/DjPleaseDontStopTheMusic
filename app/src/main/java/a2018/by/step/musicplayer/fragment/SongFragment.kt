package a2018.by.step.musicplayer.fragment

import a2018.by.step.musicplayer.R
import a2018.by.step.musicplayer.model.TempSongRepository
import android.content.Context
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_song.*

private const val ARG_ID = "arg_id"

class SongFragment : Fragment() {
    private var songId: Int = 0
    private var listenerSong: OnSongFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            songId = it.getInt(ARG_ID)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_song, container, false)
        view.findViewById<TextView>(R.id.tv_song_info).text = "Play song #$songId"
        btn_play.setOnClickListener { play() }
        return view
    }

    private fun play() {
//        val player = MediaPlayer()
//        val song = TempSongRepository.ITEMS[songId]
//        player.setDataSource(context,song.uri)
//        player.setAudioStreamType()
    }

    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        listenerSong?.onFragmentInteraction(uri)
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnSongFragmentInteractionListener) {
            listenerSong = context
        } else {
//            throw RuntimeException(context.toString() + " must implement OnSongFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listenerSong = null
    }

    interface OnSongFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: Int) =
            SongFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_ID, param1)
                }
            }
    }
}
