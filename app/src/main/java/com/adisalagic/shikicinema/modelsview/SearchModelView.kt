package com.adisalagic.shikicinema.modelsview

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adisalagic.shikicinema.api.objects.AnimeTitle
import com.adisalagic.shikicinema.api.searchByName
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class SearchData(val title: AnimeTitle, val state: SearchModelView.State)

class SearchModelView : ViewModel() {
    private val _uiState = MutableStateFlow(SearchData(AnimeTitle(), State.IDLE))
    val uiState = _uiState.asStateFlow()

    fun searchTitle(title: String) {
        var titles: AnimeTitle
        viewModelScope.launch {
            _uiState.update { it.copy(state = State.SEARCHING) }
            titles = searchByName(title)
            _uiState.update { it.copy(title = titles, state = State.IDLE) }
        }
    }

    enum class State{
        SEARCHING,
        IDLE
    }
}