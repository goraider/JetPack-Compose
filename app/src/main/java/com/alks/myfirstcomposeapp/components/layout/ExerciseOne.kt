package com.alks.myfirstcomposeapp.components.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ExerciseOne(modifier: Modifier) {
    Column {
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .background(Color.Cyan), contentAlignment = Alignment.Center
        ) {
            Text("Ejemplo1")
        }
        Spacer(Modifier.height(20.dp))
        Row(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(2475.dp)
                    .background(Color.Red), contentAlignment = Alignment.Center
            ) {
                Text("Ejemplo 2")
            }
            Spacer(Modifier.width(20.dp))
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(2475.dp)
                    .background(Color.Green), contentAlignment = Alignment.Center
            ) {
                Text("Ejemplo 3")
            }

        }
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .background(Color.Magenta),
            contentAlignment = Alignment.Center
        ) {
            Text("Ejemplo 4")
        }
    }
}