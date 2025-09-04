package com.alks.myfirstcomposeapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MyTextFieldParent(modifier: Modifier) {
    var user by remember { mutableStateOf("Ale") }
    var value by remember { mutableStateOf("") }

    Column(modifier = modifier) {
        MyTextField(user = user) { user = it }
        MySecondTextField(value = value) { value = it }
        MyAdvanceTextField(value = value) { value = it }
        Spacer(Modifier.height(20.dp))
        MyOutlinedTextField(value = value) { value = it }
    }
}

@Composable
fun MyTextField(user: String, onUserChange: (String) -> Unit) {
    TextField(user, onValueChange = { onUserChange(it) }, readOnly = user.isEmpty())
}

@Composable
fun MySecondTextField(value: String, onValueChange: (String) -> Unit) {
    TextField(value, onValueChange = { onValueChange(it) }, placeholder = {
        Box(Modifier
            .size(40.dp)
            .background(Color.Red))
    }, label = { Text("Introduce tu Nombre:") })
}

@Composable
fun MyAdvanceTextField(value: String, onValueChange: (String) -> Unit) {
    TextField(value, onValueChange = {
//        if(it.contains("a")){
        onValueChange(it.replace("a", ""))
//        }else{
//            onValueChange(it)
//        }
    })
}
@Composable
fun MyOutlinedTextField(value: String, onValueChange: (String) -> Unit){
    OutlinedTextField(value = value, onValueChange = {onValueChange(it)})
    //BasicTextField(value = value, onValueChange = {onValueChange(it)})
}