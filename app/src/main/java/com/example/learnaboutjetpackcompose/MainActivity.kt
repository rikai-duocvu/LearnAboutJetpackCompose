package com.example.learnaboutjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
        BannerCompose(contentScale = ContentScale.Crop)
        Spacer(modifier = Modifier.height(12.dp))
        BannerCompose(contentScale = ContentScale.Fit)
        Spacer(modifier = Modifier.height(12.dp))
        BannerCompose(contentScale = ContentScale.Inside)
    }

}
val customH1 :TextStyle
    get() = TextStyle(
        color = Color.Magenta,

    )

@Composable
fun Greeting() {
    Text(
        text = stringResource(id = R.string.test_text),
        maxLines = 1,
        style = customH1
    )
}

@Composable
fun MultipleStyle(){
    Text( text = buildAnnotatedString {
        withStyle( style = SpanStyle(color = Color.Blue)){
            append("H")
        }
        append("ello")
        withStyle( style = SpanStyle(color = Color.Red)){
            append("D")
        }
        append("uoc!")
    })
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    LearnAboutJetpackComposeTheme {
        HomeScreen()
    }
}

@Composable
fun BannerCompose(contentScale: ContentScale){
    Image(
        painter = painterResource(id = R.drawable.banner),
        contentDescription = null,
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)

    )
}

@Composable
fun vectorImageComponent(){
    Image(imageVector = Icons.Filled.Person, contentDescription = "Person" )
}

@Composable
fun CustomPainterImageCompose(){
    Image( ColorPainter(Color.Red) , contentDescription = null)
}