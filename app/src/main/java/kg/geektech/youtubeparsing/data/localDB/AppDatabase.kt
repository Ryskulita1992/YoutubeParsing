package kg.geektech.youtubeparsing.data.localDB

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import kg.geektech.youtubeparsing.data.models.Playlist
import kg.geektech.youtubeparsing.data.models.converter.ItemsConverter

@Database(entities = [Playlist::class], version = 1, exportSchema = false)
abstract class AppDatabase() : RoomDatabase() {
    abstract fun playlistDao(): PlaylistDao
}