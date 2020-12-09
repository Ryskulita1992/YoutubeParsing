package kg.geektech.youtubeparsing.data

import androidx.lifecycle.liveData
import kg.geektech.youtubeparsing.data.localDB.PlaylistDao
import kg.geektech.youtubeparsing.data.remoteDB.YoutubeAPI
import kg.geektech.youtubeparsing.data.remoteDB.Resource
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

open class YoutubeRepository(private var api: YoutubeAPI, private var playlistDao: PlaylistDao) :
    BaseRepository() {


    val part = "snippet,contentDetails"
    val key = "AIzaSyAHFfInYFsMdLO5h8GDO2wm3m84I5_7lyo "
    val channelId = "UCsIEFXNO4bxh0hW3-_z2-0g"


    fun fetchPlaylists() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            val request = api.getPlaylist(part, key, channelId)
            playlistDao.insertPlaylists(request)
            emit(Resource.success(data = request))

        } catch (e: Exception) {
            emit(
                Resource.failure(
                    data = null,
                    message = e.message ?: "failure on getting the playlist"
                )
            )
        }
    }

    fun fetchDetailPlaylists(playlistId: String?, pageToken: String?) = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = api.getDetailPlaylist(part, key, playlistId, pageToken)))

        } catch (e: Exception) {
            emit(Resource.failure(data = null, message = e.message ?: "Error"))
        }
    }
}

open class BaseRepository {

    suspend fun <T> baseRequest(dto: T) = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = dto))
        } catch (e: Exception) {
            emit(Resource.failure(data = null, message = e.message ?: "Error"))
        }
    }

    fun <T> baseRequestWithDB(dto: T, fetchData: T) = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        emit(Resource.fetchFromDB(fetchData))
        try {
            emit(Resource.success(data = dto))
        } catch (e: Exception) {
            emit(Resource.failure(data = null, message = e.message ?: "Error"))
        }
    }
}
