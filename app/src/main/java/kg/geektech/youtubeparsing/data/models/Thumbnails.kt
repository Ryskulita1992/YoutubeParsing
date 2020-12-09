package kg.geektech.youtubeparsing.data.models

data class Thumbnails(
    private val _default: Default? = null,
    val medium: Medium? = null,
    private val high: High? = null,
    private val standard: Standard? = null,
    private val maxres: Maxres? = null,
    private val additionalProperties: Map<String, Any> = HashMap())