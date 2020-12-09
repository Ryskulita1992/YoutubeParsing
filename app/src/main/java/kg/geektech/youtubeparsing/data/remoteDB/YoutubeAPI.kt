package kg.geektech.youtubeparsing.data.remoteDB

import kg.geektech.youtubeparsing.data.models.Playlist
import retrofit2.http.GET
import retrofit2.http.Query

interface YoutubeAPI {

    @GET("youtube/v3/playlists")
    suspend fun getPlaylist(
        @Query("part") part: String,
        @Query("key") key: String,
        @Query("channelId") channelId: String
    ): Playlist


    @GET("youtube/v3/playlistItems")
    suspend fun getDetailPlaylist(
        @Query("part") part: String,
        @Query("key") key: String,
        @Query("playlistId") playlistId: String?,
        @Query("pageToken") pageToken: String?
    ): Playlist

}