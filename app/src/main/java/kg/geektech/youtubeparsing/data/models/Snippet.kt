package kg.geektech.youtubeparsing.data.models

data class Snippet(
    private val publishedAt: String? = null,
    private val channelId: String? = null,
    val title: String? = null,
    val description: String? = null,
    var contentDetails: ContentDetails? = null,
    val thumbnails: Thumbnails? = null,
    private val channelTitle: String? = null,
    private val localized: Localized? = null,
    private val additionalProperties: Map<String, Any> = HashMap(),
)