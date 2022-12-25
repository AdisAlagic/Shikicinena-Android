package com.adisalagic.shikicinema.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnimeTile(title: String, image: String) {

    Card(
        modifier = Modifier
            .width(230.dp)
            .height(300.dp)
            .clip(RoundedCornerShape(10.dp)),
        onClick = {},

    ){
        Box() {
            AsyncImage(
                model = image,
                contentScale = ContentScale.FillWidth,
                contentDescription = title,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
            )
            Box(
                contentAlignment = Alignment.BottomCenter,
                modifier = Modifier.fillMaxSize()
            ) {
                Box(modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.verticalGradient(
                            listOf(
                                Color.Transparent,
                                Color.Transparent,
                                Color.Black
                            )
                        )
                    )
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = title,
                    fontSize = 20.sp,
                    color = Color(0xFFe3e3e3),
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.width(10.dp))
            }
        }
    }
}

@Preview
@Composable
fun PreviewAnimeTile() {
    AnimeTile(title = "Как и ожидалось, моя школьная жизнь не удалась", image = "https://nyaa.shikimori.one/system/animes/original/39195.jpg")
}