package a2018.by.step.musicplayer.fragment

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import a2018.by.step.musicplayer.R


import a2018.by.step.musicplayer.fragment.SongFragment.OnListFragmentInteractionListener
import a2018.by.step.musicplayer.fragment.dummy.FakeContent.FakeItem

import kotlinx.android.synthetic.main.recyclerView_item_song.view.*

class SongRecyclerViewAdapter(
    private val list: List<FakeItem>,
    private val listener: OnListFragmentInteractionListener?
) : RecyclerView.Adapter<SongRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerView_item_song, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.idView.text = item.id
        holder.contentView.text = item.content

//        with(holder.view) {
//            tag = item
//            setOnClickListener(mOnClickListener)
//        }
    }

    override fun getItemCount(): Int = list.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val idView: TextView = view.tv_song_title
        val contentView: TextView = view.tv_song_description

        override fun toString(): String {
            return super.toString() + " '" + contentView.text + "'"
        }
    }
}
