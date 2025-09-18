package com.alks.myfirstcomposeapp.components
import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alks.myfirstcomposeapp.R

@Composable
fun MyButtons(modifier: Modifier){
    Column(modifier = modifier){
        Button(
            onClick = { Log.i("Test de Button!!", "Botón Pulsando") },
            enabled = true,
            shape = RoundedCornerShape(20),
            border = BorderStroke(3.dp, Color.Gray),
            colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White,
                    containerColor = Color.Black,
                    disabledContainerColor = Color.Yellow,
                    disabledContentColor = Color.Green
            )
        ) {
            Text("Guardar")
        }

        OutlinedButton(onClick = {},
            border = BorderStroke(3.dp, Color.Gray),
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = Color.White,
                containerColor = Color.Blue
        )) {
            Text("Cancelar")
        }

        TextButton(onClick = {},
            colors = ButtonDefaults.textButtonColors(
                contentColor = Color.Red
            )
        ) {
            Text("Eliminar")
        }

        ElevatedButton(onClick = {},
            elevation = ButtonDefaults.elevatedButtonElevation()) {
            Text("Continuar")
        }

        FilledTonalButton(onClick = {}){}
        Button(onClick = {}){}
    }
}
@Preview
@Composable
fun MyFAB(modifier: Modifier = Modifier) {
    FloatingActionButton(
        onClick = {},
        shape = RoundedCornerShape(15),
        contentColor = Color.White,
        containerColor = Color.Black,
        elevation = FloatingActionButtonDefaults.elevation(defaultElevation = 12.dp)
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_add),
            contentDescription = null
        )
    }
}