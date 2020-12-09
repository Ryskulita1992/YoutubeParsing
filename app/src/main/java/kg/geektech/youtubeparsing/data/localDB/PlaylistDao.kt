package kg.geektech.youtubeparsing.data.localDB

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kg.geektech.youtubeparsing.data.models.Playlist
import retrofit2.Call

@Dao
interface PlaylistDao {

    @Query("SELECT *FROM playlist")
    suspend fun getPlaylist():MutableList<Playlist>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPlaylists(item: Playlist)

}