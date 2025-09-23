package com.alks.myfirstcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.alks.myfirstcomposeapp.components.MyButtons
import com.alks.myfirstcomposeapp.components.MyCard
import com.alks.myfirstcomposeapp.components.MyCheckBox
import com.alks.myfirstcomposeapp.components.MyDropDownItem
import com.alks.myfirstcomposeapp.components.MyDropDownMenu
import com.alks.myfirstcomposeapp.components.MyElevatedCard
import com.alks.myfirstcomposeapp.components.MyExposedDropDownMenu
import com.alks.myfirstcomposeapp.components.MyFAB
import com.alks.myfirstcomposeapp.components.MyModalDrawer
import com.alks.myfirstcomposeapp.components.MyNavigationBar
import com.alks.myfirstcomposeapp.components.MyNetworkImage
import com.alks.myfirstcomposeapp.components.MyOutlinedCard
import com.alks.myfirstcomposeapp.components.MyRadioButton
import com.alks.myfirstcomposeapp.components.MyRadioButtonList
import com.alks.myfirstcomposeapp.components.MyRangeSlider
import com.alks.myfirstcomposeapp.components.MySlider
import com.alks.myfirstcomposeapp.components.MySliderAdvance
import com.alks.myfirstcomposeapp.components.MySwitch
import com.alks.myfirstcomposeapp.components.MyText
import com.alks.myfirstcomposeapp.components.MyTextField
import com.alks.myfirstcomposeapp.components.MyTextFieldParent
import com.alks.myfirstcomposeapp.components.MyTopAppBar
import com.alks.myfirstcomposeapp.components.MyTriStateCheckBox
import com.alks.myfirstcomposeapp.components.ParentCheckBoxes
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
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyFirstComposeAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()){ innerPadding ->
                    //MyCard(Modifier.padding(innerPadding))
                    //MyElevatedCard(Modifier.padding(innerPadding))
                    MyOutlinedCard(Modifier.padding(innerPadding))
                }
            }
        }
//            MyFirstComposeAppTheme {
//                val drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
//                val snackbarHostState: SnackbarHostState = remember{ SnackbarHostState() }
//                val scope:CoroutineScope = rememberCoroutineScope()
//
//                MyModalDrawer(drawerState) {
//                    Scaffold(
//                        modifier = Modifier.fillMaxSize(),
//                        topBar = { MyTopAppBar { scope.launch { drawerState.open() } } },
//                        snackbarHost ={ SnackbarHost(hostState = snackbarHostState) },
//                        floatingActionButton = { MyFAB() },
//                        floatingActionButtonPosition = FabPosition.Center,
//                        bottomBar = { MyNavigationBar() }
//                    ) { innerPadding ->
//                        Box(
//                            modifier = Modifier
//                                .fillMaxSize()
//                                .padding(innerPadding)
//                                .background(Color.Gray),
//                            contentAlignment = Alignment.Center
//                        ){
//                            Text("Esta es mi Screen", modifier = Modifier.clickable{
//                                scope.launch {
//                                    val result: SnackbarResult = snackbarHostState.showSnackbar(
//                                        "ejemplo de un snackbar", "Deshacer"
//                                    )
//                                    if(result === SnackbarResult.ActionPerformed){
//                                        //Pulso desahacer
//                                    }else{
//                                        //no hizo nada
//                                    }
//                                }
//                            })
//                        }
                        //MyButtons(Modifier.padding(innerPadding))
                        //MyNetworkImage()
                        //ProgressAdvance(Modifier.padding(innerPadding))
                        //ProgressAnimation(Modifier.padding(innerPadding))
                        //MySwitch(Modifier.padding(innerPadding))
                        //MyCheckBox(Modifier.padding(innerPadding))
                        //ParentCheckBoxes(Modifier.padding(innerPadding))
                        //MyTriStateCheckBox(Modifier.padding(innerPadding))
                        //MyRadioButton(Modifier.padding(innerPadding))
                        //MyRadioButtonList(Modifier.padding(innerPadding))
                        //MySlider(Modifier.padding(innerPadding))
                        //MySliderAdvance(Modifier.padding(innerPadding))
                        //MyRangeSlider(Modifier.padding(innerPadding))
                        //MyDropDownItem(Modifier.padding(innerPadding))
                        //MyDropDownMenu(Modifier.padding(innerPadding))
                        //MyExposedDropDownMenu(Modifier.padding(innerPadding))
                    }
                //}

            //}
        //}
    }



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyFirstComposeAppTheme {
        Greeting("Android")
    }
}