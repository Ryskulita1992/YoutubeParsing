package kg.geektech.youtubeparsing.data.models

data class PageInfo(
    private val totalResults: Int? = null,
    private val resultsPerPage: Int? = null,
    private val additionalProperties: Map<String, Any> = HashMap()
)