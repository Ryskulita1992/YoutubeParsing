package kg.geektech.youtubeparsing.data.models

data class Medium(
val url: String? = null,
private val width: Int? = null,
private val height: Int? = null,
private val additionalProperties: Map<String, Any> = HashMap())