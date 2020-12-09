package kg.geektech.youtubeparsing.data.models

data class Default (
    var url: String? = null,
    var width: Int? = null,
    var height: Int? = null,
    private val additionalProperties: MutableMap<String, Any> = HashMap(),
)