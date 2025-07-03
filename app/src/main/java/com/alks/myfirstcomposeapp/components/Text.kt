package com.alks.myfirstcomposeapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Modifier
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp

@Composable
fun MyText(modifier: Modifier) {
    Column(modifier = modifier) {
        Text(text = "Pepe")
        Text(text = "Pepe", color = Color.Blue, fontStyle = FontStyle.Italic)
        Text(text = "Pepe", color = Color.Gray, fontSize = 25.sp)
        Text(text = "Pepe", fontWeight = FontWeight.ExtraBold, fontSize = 45.sp)
        Text(text = "LetterSpacing", letterSpacing = 10.sp)

        Text(text = "TextDecoration",
            textDecoration = TextDecoration.LineThrough,
            color = Color.Magenta,
            modifier = Modifier.clickable{

            })

        Text(text = "TextDecoration",
            textDecoration = TextDecoration.Underline + TextDecoration.LineThrough)

        Text(text = "Align Align Alignfsdfsdfsdfsdfsdfsdf Align Align Align Align Align Align ",
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth().background(Color.Red),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
            )
    }
}