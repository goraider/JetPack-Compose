package com.alks.myfirstcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.alks.myfirstcomposeapp.components.MyButtons
import com.alks.myfirstcomposeapp.components.MyNetworkImage
import com.alks.myfirstcomposeapp.components.MyText
import com.alks.myfirstcomposeapp.components.MyTextField
import com.alks.myfirstcomposeapp.components.MyTextFieldParent
import com.alks.myfirstcomposeapp.components.Progress
import com.alks.myfirstcomposeapp.components.ProgressAdvance
import com.alks.myfirstcomposeapp.components.ProgressAnimation
import com.alks.myfirstcomposeapp.components.layout.ExerciseOne
import com.alks.myfirstcomposeapp.components.layout.MyBox
import com.alks.myfirstcomposeapp.components.layout.MyColumn
import com.alks.myfirstcomposeapp.components.layout.MyComplexLayout
import com.alks.myfirstcomposeapp.components.layout.MyBasicConstraintLayout
import com.alks.myfirstcomposeapp.components.layout.MyConstraintChallengeLayout
import com.alks.myfirstcomposeapp.login.Greeting
import com.alks.myfirstcomposeapp.ui.theme.MyFirstComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyFirstComposeAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    //MyButtons(Modifier.padding(innerPadding))
                    //MyNetworkImage()
                    //ProgressAdvance(Modifier.padding(innerPadding))
                    ProgressAnimation(Modifier.padding(innerPadding))
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyFirstComposeAppTheme {
        Greeting("Android")
    }
}