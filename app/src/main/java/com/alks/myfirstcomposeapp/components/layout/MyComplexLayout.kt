package com.alks.myfirstcomposeapp.components.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun MyComplexLayout(modifier: Modifier){
    Column {
        Box(modifier = Modifier.weight(1f).fillMaxWidth().background(Color.Red)){}
        Box(modifier = Modifier.weight(1f).fillMaxWidth().background(Color.Blue)){
            Row {
                Box(modifier = Modifier.weight(1f).height(125.dp).background(Color.Gray)){}
                Box(modifier = Modifier.weight(1f).height(2475.dp).background(Color.Green)){
                    Text("que tal")
                }
            }
        }
        Box(modifier = Modifier.weight(1f).fillMaxWidth().background(Color.Yellow)){}
    }
}