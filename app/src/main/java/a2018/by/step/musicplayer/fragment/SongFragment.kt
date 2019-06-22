package a2018.by.step.musicplayer.fragment

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import a2018.by.step.musicplayer.R

private const val ARG_ID = "arg_id"

class SongFragment : Fragment() {
    private var param1: String? = null
    private var listenerSong: OnSongFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_ID)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_song, container, false)
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
            throw RuntimeException(context.toString() + " must implement OnSongFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listenerSong = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnSongFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        @JvmStaticm
        fun newInstance(param1: String) =
            SongFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_ID, param1)
                }
            }
    }
}
