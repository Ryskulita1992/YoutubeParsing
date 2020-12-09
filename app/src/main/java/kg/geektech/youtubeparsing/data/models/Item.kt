package kg.geektech.youtubeparsing.data.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Item(

 var kind: String? = null,
 var etag: String? = null,
 var id: String? = null,
 var snippet: Snippet? = null,
 var contentDetails: ContentDetails? = null,
 @SerializedName("videoId")
 var additionalProperties: Map<String, Any> = HashMap()
) : Serializable

data class ContentDetails(
 var itemCount: String? = null,
 var videoId: String? = null,
 var videoPublishedAt: String? = null
)

data class VideoId(
 var idVideo: String? = null

) : Serializable


