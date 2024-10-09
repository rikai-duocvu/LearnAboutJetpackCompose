package com.example.learnaboutjetpackcompose

import android.R.style
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
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
    Column (modifier = Modifier.padding(top = 30.dp)) {
        DemoTextField()
    }

}

@Composable
fun DemoTextField (){
    var firstName by remember {
        mutableStateOf("")
    }
    TextField(value = firstName, onValueChange = {
        firstName = it
    },
        textStyle = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold),
        label = { Text("First Name") },
        placeholder = {Text("Enter your name")},
        leadingIcon = { Icon(Icons.Default.Person,"") },
        trailingIcon = {
            IconButton(onClick = {
                firstName = ""
            }) {
                Icon(Icons.Default.Close,"")
            }
        },
        colors = TextFieldDefaults.colors(
            cursorColor = Color.Black,
            unfocusedTextColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.White,
            errorIndicatorColor = Color.Transparent
        ),
        shape = RoundedCornerShape(12.dp),
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done,
            keyboardType = KeyboardType.Phone
        )
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    LearnAboutJetpackComposeTheme {
        HomeScreen()
    }
}



