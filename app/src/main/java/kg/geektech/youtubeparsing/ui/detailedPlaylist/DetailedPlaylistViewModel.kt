package kg.geektech.youtubeparsing.ui.detailedPlaylist

import android.util.Log
import androidx.lifecycle.MutableLiveData
import kg.geektech.youtubeparsing.base.BaseViewModel
import kg.geektech.youtubeparsing.data.YoutubeRepository
import kg.geektech.youtubeparsing.data.models.Item
import kg.geektech.youtubeparsing.data.models.Playlist
import kg.geektech.youtubeparsing.data.remoteDB.Status

class DetailedPlaylistViewModel(var repository: YoutubeRepository) : BaseViewModel() {

    var detailPlaylists = MutableLiveData<MutableList<Item>>()
    var detail: MutableList<Item>? = mutableListOf()
    var playlistId: String? = null

    fun fetchPlaylistVideo(playlistId: String?, nextPageToken: String? = null) {
        this.playlistId = playlistId
        repository.fetchDetailPlaylists(playlistId, nextPageToken).observeForever {
            when (it.status) {
                Status.SUCCESS -> getAllVideo(it?.data)
                Status.FAILURE -> errorMessage.value = it.message.toString()
            }
        }
    }

    private fun getAllVideo(data: Playlist?) {
        data?.items?.let {
            detail?.addAll(it)
            detailPlaylists.value = detail
        }
    }
}

