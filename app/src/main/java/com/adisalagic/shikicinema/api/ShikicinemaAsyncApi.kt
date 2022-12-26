package com.adisalagic.shikicinema.api

import com.adisalagic.shikicinema.api.objects.AnimeTitle
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope

suspend fun searchByName(title: String): AnimeTitle = coroutineScope {
    val result = async(Dispatchers.IO) { ShikicinemaAPI.searchByName(title) }
    result.await()
}