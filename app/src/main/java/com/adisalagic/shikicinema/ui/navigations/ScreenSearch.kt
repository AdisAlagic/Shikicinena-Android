package com.adisalagic.shikicinema.ui.navigations

import androidx.compose.foundation.layout.*
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.adisalagic.shikicinema.modelsview.SearchModelView
import com.adisalagic.shikicinema.ui.components.AnimeTile
import com.adisalagic.shikicinema.ui.components.SearchField

@Composable
fun ScreenSearch() {
    val model = viewModel<SearchModelView>()
    val titles by model.uiState.collectAsState()

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
        val context = LocalContext.current.applicationContext
        SearchField(
            modifier = Modifier
                .fillMaxWidth(),
            onTextChanged = {
                model.searchTitle(it)
            }
        )
    }
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {
        if (titles.state == SearchModelView.State.SEARCHING) {
            LinearProgressIndicator(modifier = Modifier.fillMaxWidth())
        }
    }
    Column(
        modifier = Modifier.padding(20.dp)
    ) {
        AnimeTile(title = titles.title.toString(),
            image = "https://i.pinimg.com/236x/c1/fd/04/c1fd0493aaa48c77dcb8bd4a6ca1efff.jpg")
    }
}