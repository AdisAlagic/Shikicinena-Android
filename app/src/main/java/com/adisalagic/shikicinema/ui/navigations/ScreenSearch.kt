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
        Row (horizontalArrangement = Arrangement.SpaceBetween) {
            AnimeTile(title = "Touhow meme",
                image = "https://i.pinimg.com/236x/c1/fd/04/c1fd0493aaa48c77dcb8bd4a6ca1efff.jpg")
            AnimeTile(title = "Touhow meme",
                image = "https://i.pinimg.com/236x/c1/fd/04/c1fd0493aaa48c77dcb8bd4a6ca1efff.jpg")
        }
    }
}