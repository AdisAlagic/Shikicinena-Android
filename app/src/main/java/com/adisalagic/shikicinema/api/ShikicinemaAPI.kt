package com.adisalagic.shikicinema.api

import android.util.Log
import com.adisalagic.shikicinema.api.objects.AnimeTitle
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.json.Json
import okhttp3.Call
import okhttp3.HttpUrl.Companion.toHttpUrl
import okhttp3.OkHttpClient
import okhttp3.Request
import java.time.Duration

object ShikicinemaAPI {

    private val BASE_URL = "https://smarthard.net/api/shikivideos/"
    private val builder = BASE_URL.toHttpUrl()
    @OptIn(ExperimentalSerializationApi::class)
    private val json = Json {
        coerceInputValues = true
        explicitNulls = false
    }

    private fun get(url: String): Call {
        val ok = OkHttpClient()
            .newBuilder()
            .callTimeout(Duration.ZERO)
            .build()
        val request = Request.Builder()
            .url(url)
            .get()
            .build()
        return ok.newCall(request)
    }

    fun searchByName(searchQuery: String): AnimeTitle {
        val url = builder
            .newBuilder()
            .addPathSegment("search")
            .addQueryParameter("title", searchQuery.trimIndent())
            .build().toString()
        val result = get(url).execute()
        val str = result.body!!.string()
        Log.d("Json", str)
        val list = json.decodeFromString(
            ListSerializer(AnimeTitle.AnimeTitleItem.serializer()),
            str
        )
        return AnimeTitle().apply {
            addAll(list)
        }
    }

}