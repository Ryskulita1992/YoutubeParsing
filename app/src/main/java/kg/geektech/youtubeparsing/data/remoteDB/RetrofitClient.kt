package kg.geektech.youtubeparsing.data.remoteDB

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

const val BASE_URL = "https://www.googleapis.com/"

class RetrofitClient {

    private val httpLoginInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }


    private val okHttpClient: OkHttpClient = OkHttpClient().newBuilder()
        .connectTimeout(40, TimeUnit.SECONDS)
        .readTimeout(40, TimeUnit.SECONDS)
        .writeTimeout(40, TimeUnit.SECONDS)
        .addInterceptor(httpLoginInterceptor)
        .build()


    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .build()

    fun provideYoutubeApi(): YoutubeAPI {
        return retrofit.create(YoutubeAPI::class.java)
    }
}