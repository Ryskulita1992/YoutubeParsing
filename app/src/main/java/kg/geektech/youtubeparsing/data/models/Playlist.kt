package kg.geektech.youtubeparsing.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import kg.geektech.youtubeparsing.data.models.converter.ItemsConverter
import java.io.Serializable

@Entity(tableName = "playlist")
@TypeConverters(ItemsConverter::class)
data class Playlist(

   @PrimaryKey(autoGenerate = true)
   var id: Int? = null,
   var kind: String? = null,
   var etag: String? = null,
   var items: MutableList<Item>? = null,
):Serializable