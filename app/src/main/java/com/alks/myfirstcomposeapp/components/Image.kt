package com.alks.myfirstcomposeapp.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.alks.myfirstcomposeapp.R
import kotlin.math.log

@Preview
@Composable
//.height(200.dp).width(30.dp),
//.clip(RoundedCornerShape(30.dp)),
//.clip(RoundedCornerShape(topEnd = 30.dp, bottomStart = 70.dp)),
//.border(width = 5.dp, color = Color.Red, shape = CircleShape),
fun MyImage(){
    Image(painter = painterResource(id = R.drawable.cover),
        contentDescription = "Avatar Image Profile",
        modifier = Modifier
            .size(200.dp)
            .clip(RoundedCornerShape(50))
            .border(width = 5.dp, shape = CircleShape,
                brush = Brush.linearGradient(colors = listOf(Color.Red, Color.Blue, Color.Yellow))),
        contentScale = ContentScale.FillBounds

    )
}

@Preview
@Composable
fun MyIcon(){
    Icon(
        painter = painterResource(R.drawable.ic_personita),
        contentDescription = null,
        modifier = Modifier.size(300.dp),
        tint = Color.Blue
    )
}

@Composable
fun MyNetworkImage(){
    AsyncImage(
        model = "https://img.freepik.com/foto-gratis/arreglo-creativo-dia-mundial-libro_23-2148883751.jpg?t=st=1756995872~exp=1756999472~hmac=5847b6ca35a213ef99fa297aee920720e0666297497433cf41b4c1d9c603c6b3&w=1480",
        contentDescription = "Image From Network",
        modifier = Modifier.size(250.dp),
        onError = { Log.i("Imagen", "Ha Ocurrido un Error ${it.result.throwable.message}") }
    )
}