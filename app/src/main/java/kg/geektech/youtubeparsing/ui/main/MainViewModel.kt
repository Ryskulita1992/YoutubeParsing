package kg.geektech.youtubeparsing.ui.main

import androidx.lifecycle.ViewModel
import kg.geektech.youtubeparsing.data.YoutubeRepository

class MainViewModel (var repository: YoutubeRepository): ViewModel() {
    // TODO: Implement the ViewModel
    fun fetchList(){
        repository.fetchPlaylists()
    }
}