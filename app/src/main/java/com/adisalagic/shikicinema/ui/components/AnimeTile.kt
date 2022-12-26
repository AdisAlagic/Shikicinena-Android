package com.adisalagic.shikicinema.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.magnifier
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
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.drawable.toBitmap
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.compose.SubcomposeAsyncImage
import coil.util.DebugLogger
import com.adisalagic.shikicinema.R
import com.adisalagic.shikicinema.ui.theme.getTheme
import com.google.accompanist.drawablepainter.rememberDrawablePainter
import okhttp3.OkHttpClient
import java.time.Duration

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnimeTile(title: String, image: String) {

    Card(
        modifier = Modifier
            .width(170.dp)
            .height(250.dp)
            .clip(RoundedCornerShape(10.dp)),
        onClick = {},

        ) {
        Box {
            val shimmer = getShimmerLoader()
            SubcomposeAsyncImage(
                model = image,
                contentScale = ContentScale.FillWidth,
                contentDescription = title,
                loading = {
                    Image(
                        painter = rememberDrawablePainter(drawable = shimmer),
                        contentDescription = null
                    )
                },
                error = {
                    Box(Modifier.fillMaxSize().background(getTheme().primary))
                    Image(
                        modifier = Modifier.width(50.dp).height(50.dp),
                        painter = painterResource(id = R.drawable.ic_baseline_report_problem_24),
                        contentDescription = null
                    )
                },
                imageLoader = ImageLoader.Builder(LocalContext.current)
                    .logger(DebugLogger())
                    .okHttpClient(okHttpClient = OkHttpClient.Builder()
                        .callTimeout(Duration.ZERO)
                        .build())
                    .build(),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
            )
            Box(
                contentAlignment = Alignment.BottomCenter,
                modifier = Modifier.fillMaxSize()
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()

                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            brush = Brush.verticalGradient(
                                listOf(
                                    Color.Transparent,
                                    Color.Black,
                                    Color.Black,
                                )
                            )
                        ),
                    text = title,
                    fontSize = 17.sp,
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
    Row(horizontalArrangement = Arrangement.SpaceBetween) {
        AnimeTile(
            title = "Как и ожидалось, моя школьная жизнь не удалась",
            image = "https://nyaa.shikimori.one/system/animes/original/39195.jpg"
        )
        AnimeTile(
            title = "Как и ожидалось, моя школьная жизнь не удалась",
            image = "https://nyaa.shikimori.one/system/animes/original/39195.jpg"
        )
    }
}