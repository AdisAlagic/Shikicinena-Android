package com.adisalagic.shikicinema.ui.navigations

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.adisalagic.shikicinema.ui.components.AnimeTile
import com.adisalagic.shikicinema.ui.components.SearchField

@Composable
fun ScreenSearch() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter){
        val context = LocalContext.current.applicationContext
        SearchField(
            modifier = Modifier
                .fillMaxWidth(),
            onTextChanged = {
                Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
            }
        )
    }
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter){
        LinearProgressIndicator(modifier = Modifier.fillMaxWidth())
    }
    Column(
        modifier = Modifier.padding(20.dp)
    ){
        AnimeTile(title = "Touhow meme", image = "https://pm1.narvii.com/6475/9c0d262faae8f19fe538ff651fb9ed3a72e62938_hq.jpg")
    }
}