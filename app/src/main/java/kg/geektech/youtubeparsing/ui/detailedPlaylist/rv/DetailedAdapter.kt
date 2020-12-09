package kg.geektech.youtubeparsing.ui.detailedPlaylist.rv

import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kg.geektech.youtubeparsing.extensions.loadImage
import kg.geektech.youtubeparsing.R
import kg.geektech.youtubeparsing.data.models.Item
import kg.geektech.youtubeparsing.data.models.Playlist
import kg.geektech.youtubeparsing.databinding.ItemDetailedBinding
import kg.geektech.youtubeparsing.extensions.inflateEx

class DetailedAdapter(private var playlist: MutableList<Item>, var onItemClick: (Item) -> Unit) :
    RecyclerView.Adapter<DetailedAdapter.DetailedVH>() {
    lateinit var holder: DetailedVH


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailedVH {
        val v = parent.inflateEx(R.layout.item_detailed)
        return DetailedVH(v)
    }

    override fun getItemCount(): Int {
        return playlist.size
    }


    override fun onBindViewHolder(holder: DetailedVH, position: Int) {
        this.holder = holder
        holder.bind(playlist[position])
        val item = playlist[position]
        holder.binding.itemDetailedImage.loadImage(item.snippet?.thumbnails?.medium?.url)
        Log.d("TAG", "onBindViewHolder: $item")
        holder.binding.itemDetailedVideoTitle.text = item.snippet?.title
        holder.binding.itemDetailedImage.setOnClickListener {
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

    inner class DetailedVH(v: View) : RecyclerView.ViewHolder(v) {
        val binding = ItemDetailedBinding.bind(v)

        init {
            itemView.setOnClickListener {

            }

        }

        fun bind(item: Item) {
//            binding.itemDetailedImage.item_playlist_image.loadImage(item.snippet?.thumbnails?.medium?.url)
//            binding.itemDetailedVideoTitle.item_video_title.text = item.snippet?.title
            Log.e("TAG", "bind: ")


        }
    }


}