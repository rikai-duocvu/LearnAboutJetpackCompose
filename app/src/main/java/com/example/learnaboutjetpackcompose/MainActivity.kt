package com.example.learnaboutjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
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

    }

}

@Composable
fun Ingredient(
    @DrawableRes icon: Int,
    value:Int,
    unit:String?,
    name:String,
    modifier: Modifier = Modifier
    ){
    val backgroundColor = Color(0xFFFEF9E4)
    val borderColor = Color(0xFFFBE897).copy(0.7f)


    ConstraintLayout(
        modifier = modifier
            .size(width = 104.dp, height = 104.dp)
            .background(color = backgroundColor, shape = CircleShape)
            .border(BorderStroke(width = 1.dp, color = borderColor))
    ) {
        val horizontalGuideLines = createGuidelineFromTop(0.6f)
        val horizontalGuideLinesBottom = createGuidelineFromTop(0.5f)
        val imgIcon = createRef()
        Image(painter = painterResource(id = icon), contentDescription = null , modifier = Modifier.constrainAs(imgIcon){
            top.linkTo(parent.top, margin = 3.dp)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            bottom.linkTo(horizontalGuideLines)
            height= Dimension.fillToConstraints
        })
        val (tvValue,tvUnit,tvName) = createRefs()

        val verticalGuideLineslf = createGuidelineFromStart(0.4f)
        val verticalGuideLines = createGuidelineFromStart(0.5f)

        val valueTextColor = Color(0xFFFB7D8A)
        Text(text = value.toString() ,style= TextStyle(
            color = valueTextColor,
            fontWeight = FontWeight.SemiBold,
            fontSize = 32.sp,
            lineHeight = 14.sp
        ),
            modifier = Modifier.constrainAs(tvValue){
                top.linkTo(horizontalGuideLinesBottom)
                start.linkTo(parent.start,22.dp)
                end.linkTo(verticalGuideLineslf)
//                bottom.linkTo(parent.bottom)
            }
        )

        unit?.let{
            Text(text = unit, style = TextStyle(
                color = valueTextColor,
                fontWeight = FontWeight.SemiBold,
                fontSize = 12.sp,
                lineHeight = 14.sp
            ),
                modifier =Modifier.constrainAs(tvUnit){
                    top.linkTo(tvValue.bottom)
                    start.linkTo(parent.start,30.dp)
                    end.linkTo(verticalGuideLines)
                    bottom.linkTo(parent.bottom,12.dp)
                })
        }
        val bottomBarrier = createBottomBarrier(tvValue,tvUnit)
        val endGuideLine = createGuidelineFromEnd(0.1f)
        Text(text = name, style = TextStyle(
            color = Color(0xFF1E2742),
            lineHeight = 14.sp,
            fontSize = 12.sp,
        ),
            modifier = Modifier.constrainAs(tvName){
                top.linkTo(tvValue.top)
                start.linkTo(verticalGuideLines)
                bottom.linkTo(bottomBarrier)
                end.linkTo(endGuideLine)
                width = Dimension.fillToConstraints
            },
            maxLines = 2,
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true)
@Composable
fun IngredientPreview(){
    Row (){
        Ingredient(
            icon=R.drawable.ic_different2,
            name= "Lemon Juice",
            unit= "ml",
            value = 30,
            modifier = Modifier.size(100.dp))
    }
}



//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    LearnAboutJetpackComposeTheme {
        HomeScreen()
    }
}

