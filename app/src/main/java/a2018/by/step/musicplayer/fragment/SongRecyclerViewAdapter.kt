package a2018.by.step.musicplayer.fragment


import a2018.by.step.musicplayer.R
import a2018.by.step.musicplayer.fragment.SongListFragment.ISongItemClickListener
import a2018.by.step.musicplayer.model.Song
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recyclerview_item_song.view.*
import timber.log.Timber

class SongRecyclerViewAdapter(
    private val list: List<Song>,
    private val listener: ISongItemClickListener?
) : RecyclerView.Adapter<SongRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerview_item_song, parent, false)
        view.setOnClickListener {
            Timber.d("Clicked item! ${view.tag}")
            listener?.onSongClicked(view.tag as Int)
        }
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.titleText.text = item.title
        holder.descriptionText.text = item.artist
        holder.itemView.tag = position
    }

    interface IRecyclerItemClickListener {
        fun onItemClicked(id: Int)
    }

    override fun getItemCount(): Int {
        val size = list.size
        return size
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleText: TextView = view.tv_song_title
        val descriptionText: TextView = view.tv_song_description

        override fun toString(): String {
            return super.toString() + " '" + descriptionText.text + "'"
        }
    }
}
