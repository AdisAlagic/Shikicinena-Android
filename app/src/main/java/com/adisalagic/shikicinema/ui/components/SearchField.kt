package com.adisalagic.shikicinema.ui.components

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import com.adisalagic.shikicinema.R
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchField(modifier: Modifier = Modifier, onTextChanged: (text: String) -> Unit = {}) {
    var text by remember {
        mutableStateOf("")
    }
    TextField(
        value = text,
        onValueChange = { text = it },
        modifier = modifier,
        placeholder = { Text(text = "Введите название...")},
        singleLine = true,
        keyboardActions = KeyboardActions(
            onDone = {
                onTextChanged(text)
            }
        )
    )
}

@Preview
@Composable
fun PrevSearchField() {
    SearchField()
}