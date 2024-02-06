package com.example.numberfinder

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlin.random.Random


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun  GamingPage(navController: NavController){
       val textstatus= remember { mutableStateOf("") }
       val help= remember { mutableStateOf("") }
       val randomNumber= remember{ mutableStateOf(0) }
       val  chance= remember{ mutableStateOf(5)}
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceEvenly, horizontalAlignment = Alignment.CenterHorizontally) {
          
        LaunchedEffect(key1 = true){
            randomNumber.value=Random.nextInt(101)
            Log.e("random number","${randomNumber.value}")
        }

        Text(text = "Sans: ${chance.value}", color = Color.Red, fontSize = 34.sp)
        Text(text = "Help: ${help.value}}", color = Color.DarkGray, fontSize = 34.sp)
        TextField(value =textstatus.value ,
            onValueChange ={textstatus.value=it},
            label = { Text(text = "numberi daxil et")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Button(onClick = {

            chance.value-=1
            if (chance.value==0){
                navController.navigate("Result/false"){
                    popUpTo("GamingPage",{inclusive=true})
                }
                return@Button
            }
            if (randomNumber.value > textstatus.value.toInt()){
                 help.value="artir"
            }
            if (randomNumber.value<textstatus.value.toInt()){
                help.value="azalt"

            }
            if (randomNumber.value==textstatus.value.toInt()){
                navController.navigate("Result/true"){
                    popUpTo("GamingPage",{inclusive=true})
                }
            }




         }, Modifier.size(200.dp,50.dp)) {
            Text(text = "Texmin et")
        }

    }

}