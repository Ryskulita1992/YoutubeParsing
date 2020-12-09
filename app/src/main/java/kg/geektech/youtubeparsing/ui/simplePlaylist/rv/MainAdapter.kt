package kg.geektech.youtubeparsing.ui.simplePlaylist.rv

import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kg.geektech.youtubeparsing.extensions.loadImage
import kg.geektech.youtubeparsing.R
import kg.geektech.youtubeparsing.databinding.ItemPlaylistBinding
import kg.geektech.youtubeparsing.data.models.Item
import kg.geektech.youtubeparsing.extensions.inflateEx
import kotlinx.android.synthetic.main.item_playlist.view.*

class MainAdapter(private var playlist: MutableList<Item>, var onItemClick: (Item) -> Unit) :
    RecyclerView.Adapter<MainAdapter.PlaylistViewHolder>() {
    lateinit var holder: PlaylistViewHolder


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaylistViewHolder {
        val v = parent.inflateEx(R.layout.item_playlist)
        return PlaylistViewHolder(v)
    }

    override fun getItemCount(): Int {
        return playlist.size
    }

    override fun onBindViewHolder(holder: PlaylistViewHolder, position: Int) {
        this.holder = holder
        holder.bind(playlist[position])
        val item = playlist[position]
        holder.binding.itemPlaylistImage.loadImage(item.snippet?.thumbnails?.medium?.url)
        holder.binding.itemVideoTitle.text = item.snippet?.title
        holder.binding.itemVideoAmount.text = item.snippet?.description

        holder.binding.itemPlaylistImage.setOnClickListener {
            onItemClick(item)
        }
    }

    fun addItems(items: MutableList<Item>) {
        playlist.addAll(items)
        notifyDataSetChanged()
    }

    fun addItem(item: Item) {
        playlist.add(item)
        notifyItemInserted(playlist.lastIndex)
    }

    fun itemRemove(position: Int) {
        playlist.removeAt(position)
        notifyItemRemoved(position)
        Log.v("DELETED_POSITION_AT", "$position")
    }

    fun add(list: Item) {
        playlist.addAll(listOf(list))
        notifyDataSetChanged()

    }

    inner class PlaylistViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val binding = ItemPlaylistBinding.bind(v)

        init {
            itemView.setOnClickListener {

            }

        }

        fun bind(item: Item) {
            binding.itemPlaylistImage.item_playlist_image.loadImage(item.snippet.toString())
            binding.itemVideoTitle.item_video_title.text = ""
            Log.e("TAG", "bind: ")


        }
    }

}