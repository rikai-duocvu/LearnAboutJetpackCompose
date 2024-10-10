package com.example.learnaboutjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learnaboutjetpackcompose.ui.theme.LearnAboutJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
            LearnAboutJetpackComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Gray
                ) {
                    HomeScreen()
                }
            }
        }
    }
}

@Composable
fun HomeScreen(){
    //Box trong jetpack
//    Box(
//        modifier = Modifier.fillMaxSize() // Đảm bảo Box chiếm toàn bộ màn hình
//    ) {
//        BoxItem(Color.Blue, 200.dp, modifier = Modifier.align(Alignment.TopStart))
//        BoxItem(Color.Red,150.dp, modifier = Modifier.align(Alignment.TopEnd))
//        BoxItem(Color.Yellow, modifier =  Modifier.align(Alignment.BottomStart))
//        BoxItem(Color.Magenta, modifier = Modifier.align(Alignment.BottomEnd))
//        BoxItem(Color.Black, modifier = Modifier.align(Alignment.Center))
//
//    }
    // Row trong jetpack
//    Box(){
////        Row (
////            modifier = Modifier
////                .background(Color.Gray)
////                .size(400.dp, 300.dp),
////            verticalAlignment = Alignment.CenterVertically,
////            horizontalArrangement = Arrangement.SpaceBetween
////        ){
////            BoxItem(Color.Blue)
////            BoxItem(Color.Red)
////            BoxItem(Color.Green)
////
////        }
////    }

//    Box(){
//        Row(
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            OutlinedTextField(value = "" , onValueChange = {} , modifier = Modifier.weight( 2f))
//            Icon(Icons.Default.Send, contentDescription = "Send", Modifier.size(36.dp).weight(1f))
//        }
//    }

    //Column trong jetpack
//    Box() {
//        Column(
//            horizontalAlignment = Alignment.CenterHorizontally,
//            modifier = Modifier.size(500.dp, 700.dp).background(Color.Gray),
//            verticalArrangement = Arrangement.SpaceBetween
//        ) {
//            BoxItem(Color.Blue)
//            BoxItem(Color.Red)
//            BoxItem(Color.Green)
//        }
//    }

    Box(
        modifier = Modifier.fillMaxSize()

    ) {
        Column(
            verticalArrangement = Arrangement.SpaceAround,
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Code has been send to 09123aaa231")
                Spacer(Modifier.padding(24.dp))
                OutlinedTextField(value = "" , onValueChange = {})
                Spacer(Modifier.padding(24.dp))
                Text("Resend in 53s")
            }
            Button(onClick = {}, modifier = Modifier.fillMaxWidth()) {
                Text("Verify")
            }
        }

    }
}

@Composable
fun BoxItem(color: Color, size: Dp = 100.dp, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .size(size)
            .background(color = color)
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    LearnAboutJetpackComposeTheme {
        HomeScreen()
    }
}

