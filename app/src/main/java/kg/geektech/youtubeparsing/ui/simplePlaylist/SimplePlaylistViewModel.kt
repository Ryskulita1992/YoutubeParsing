package kg.geektech.youtubeparsing.ui.simplePlaylist

import androidx.lifecycle.MutableLiveData
import kg.geektech.youtubeparsing.base.BaseViewModel
import kg.geektech.youtubeparsing.data.YoutubeRepository
import kg.geektech.youtubeparsing.data.models.Item
import kg.geektech.youtubeparsing.data.remoteDB.Status

class SimplePlaylistViewModel(var repository: YoutubeRepository) : BaseViewModel() {
    var failureMessage = MutableLiveData<String>()
    var playlist = MutableLiveData<MutableList<Item>>()

    fun fetchPlaylist() {
        repository.fetchPlaylists().observeForever {
            when (it.status) {
                Status.SUCCESS -> playlist.postValue(it.data?.items)
                Status.FAILURE -> failureMessage.postValue(it.message.toString())
            }
        }

    }


}