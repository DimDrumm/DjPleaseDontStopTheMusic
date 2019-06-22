package a2018.by.step.musicplayer.fragment

import a2018.by.step.musicplayer.R
import a2018.by.step.musicplayer.model.TempSongRepository
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import timber.log.Timber

class SongListFragment : Fragment(), SongRecyclerViewAdapter.IRecyclerItemClickListener {

    override fun onItemClicked(id: Int) {
    Timber.d("In recyclerFragment $id was clicked")
        listener?.onSongClicked(id)
    }

    private var listener: ISongItemClickListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_song_list, container, false)
        if (view is RecyclerView) {
            view.layoutManager = LinearLayoutManager(context)
            view.adapter = SongRecyclerViewAdapter(TempSongRepository.ITEMS, listener)
        }
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is ISongItemClickListener) {
            listener = context
        } else {
            Timber.w(
                "${context.javaClass.simpleName} not implementing ${ISongItemClickListener::javaClass}"
            )
            throw RuntimeException("$context must implement ISongItemClickListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson
     * [Communicating with Other Fragments](http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface ISongItemClickListener {
        // TODO: Update argument type and name
        fun onSongClicked(item: Int)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            SongListFragment().apply {
                //TODO add arguments
            }
    }
}
