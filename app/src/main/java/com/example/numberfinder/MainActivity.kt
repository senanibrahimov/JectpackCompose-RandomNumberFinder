package com.example.numberfinder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavArgument
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.numberfinder.ui.theme.NumberFinderTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NumberFinderTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PageNavigation()
                }
            }
        }
    }
}

@Composable
 fun MainsActivity(navController: NavController){

     Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceEvenly, horizontalAlignment = Alignment.CenterHorizontally) {
         
         Text(text = "Tahmin oyunu", color = Color.DarkGray, fontSize = 34.sp)
         Image(painter = painterResource(id = R.drawable.zar_resim), contentDescription ="" )
         Button(onClick = { navController.navigate("GamingPage") },Modifier.size(200.dp,50.dp)) {
             Text(text = "Oyuna Basla")
         }
         
     }
 }
@Composable
fun PageNavigation() {

    val navs= rememberNavController()
       NavHost(navController = navs, startDestination = "MainActivity" ){

           composable("MainActivity"){
               MainsActivity(navs)
           }
           composable("GamingPage"){

               GamingPage(navController = navs)
           }
           composable("Result/{result}", arguments = listOf(navArgument("result"){type= NavType.BoolType})){

               val deyer=it.arguments?.getBoolean("result")!!
               Result(deyer)
           }
    }


}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NumberFinderTheme {
        PageNavigation()
    }
}