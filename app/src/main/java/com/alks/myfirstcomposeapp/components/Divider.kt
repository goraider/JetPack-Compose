package com.alks.myfirstcomposeapp.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MyDivider(modifier: Modifier = Modifier) {

    Column(modifier = modifier) {
            Text("Parte de Arriba")
            HorizontalDivider(thickness = 2.dp, color = Color.Blue)
            Text("Parte de Abajo")
        Row(
            modifier = modifier.height(200.dp).fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text("Izquierda")
            VerticalDivider(thickness = 2.dp, color = Color.Green)
            Text("Derecha")
        }
    }

}