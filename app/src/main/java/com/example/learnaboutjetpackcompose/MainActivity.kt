package com.example.learnaboutjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.learnaboutjetpackcompose.ui.theme.LearnAboutJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LearnAboutJetpackComposeTheme {
                HomeScreen()
            }
        }
    }
}

@Composable
fun HomeScreen(){
    Column (modifier = Modifier.padding(24.dp)) {
        SimpleButton()
        Spacer(modifier = Modifier.padding(24.dp))
        DisableSimpleButton()
        Spacer(modifier = Modifier.padding(24.dp))
        RoundedConnerButton()
        Spacer(modifier = Modifier.padding(24.dp))
        BorderSimpleButton()
        Spacer(modifier = Modifier.padding(24.dp))
        ElevationSimpleButton()
        Spacer(modifier = Modifier.padding(24.dp))
        DemoClickModifire()
        Spacer(modifier = Modifier.padding(24.dp))
        DemoDetectClick()
    }

}

@Composable
fun SimpleButton(){
    val count = remember {
        mutableStateOf(0)
    }
    Text("So lan click: ${count.value}")
    Button (onClick = {
        count.value++
    },
        colors = ButtonDefaults.buttonColors(
            Color.Green,
            contentColor = Color.White
        )
    ){
        Column {
            Icon(Icons.Default.ShoppingCart, contentDescription = null)
            Text("Click me")
        }
    }
}

@Composable
fun RoundedConnerButton(){
    Row {
        Button(onClick = {},
            shape = RoundedCornerShape(topStart = 15.dp, bottomStart = 15.dp)
        ) {
            Text("Rounded Left")
        }
        Button(onClick = {},
            shape = RoundedCornerShape(topEnd = 15.dp, bottomEnd = 15.dp)
        ) {
            Text("Rounded Right")
        }
    }

}

@Composable
fun BorderSimpleButton (){
    Button(onClick = {},
        border = BorderStroke(width = 2.dp, color = Color.Magenta),
        colors = ButtonDefaults.buttonColors(
            Color.White
        )
    ) {
        Text("Border Click" , color = Color.Magenta)
    }
}

@Composable
fun DisableSimpleButton(){
    Button(onClick = {},
        colors = ButtonDefaults.buttonColors(
            Color.Gray,
            disabledContentColor = Color.White
        ),
        enabled = false
    ) {
        Text("Disable Button")
    }
}

@Composable
fun ElevationSimpleButton(){
    Button(onClick = {},
        colors = ButtonDefaults.buttonColors(
            Color.White
        ),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 10.dp,
            pressedElevation = 15.dp,
            disabledElevation = 0.dp
        )
    ) {
        Text("Shadow Button", color = Color.Black)
    }
}

@Composable
fun DemoClickModifire(){
    Text("click me" , modifier = Modifier.clickable {

    })
}

@Composable
fun DemoDetectClick(){
    val textContent = remember {
        mutableStateOf("")
    }
    Column {
        Text(textContent.value)
        Text("something", modifier = Modifier.pointerInput(Unit) {
            detectTapGestures (
                onDoubleTap = {textContent.value = "Double Tap"},
                onTap = {textContent.value = "One Tap"},
                onPress = {textContent.value = "on Press"},
                onLongPress = {textContent.value = "on Long Press"}
            )
        })
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    LearnAboutJetpackComposeTheme {
        HomeScreen()
    }
}


