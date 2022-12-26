package com.adisalagic.shikicinema.api.objects


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

class AnimeTitle : ArrayList<AnimeTitle.AnimeTitleItem>(){
    @Serializable
    data class AnimeTitleItem(
        @SerialName("anime_english")
        val animeEnglish: String?,
        @SerialName("anime_id")
        val animeId: Int?,
        @SerialName("anime_russian")
        val animeRussian: String?,
        @SerialName("author")
        val author: String?,
        @SerialName("episode")
        val episode: Int?,
        @SerialName("id")
        val id: Int?,
        @SerialName("kind")
        val kind: String?,
        @SerialName("language")
        val language: String?,
        @SerialName("quality")
        val quality: String?,
        @SerialName("uploader")
        val uploader: Int?,
        @SerialName("url")
        val url: String?,
        @SerialName("watches_count")
        val watchesCount: Int?
    )
}