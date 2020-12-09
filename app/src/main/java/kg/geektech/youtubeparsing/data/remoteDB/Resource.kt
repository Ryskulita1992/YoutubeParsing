package kg.geektech.youtubeparsing.data.remoteDB

import android.annotation.SuppressLint
import android.util.Log

data class Resource<out T>(val status: Status, val data: T?, val message: String?) {
    companion object {

        fun <T> fetchFromDB(data: T?): Resource<T> {
            return if (data != null) Resource(status = Status.SUCCESS, data = data, message = null)
            else Resource(status = Status.FAILURE, data = null, message = null)
        }

        fun <T> success(data: T?): Resource<T> =
            Resource(status = Status.SUCCESS, data = data, message = null)


        @SuppressLint("LongLogTag")
        fun <T> failure(data: T, message: String): Resource<T> {
            val result = Resource(status = Status.FAILURE, data = data, message = message)
            Log.e("Failure on resource request:", result.toString())
            return result

        }

        fun <T> loading(data: T?): Resource<T> =
            Resource(status = Status.LOADING, data = data, message = null)

    }
}


enum class Status {
    SUCCESS,
    FAILURE,
    LOADING
}