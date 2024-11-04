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
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ChainStyle
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
fun HomeScreen() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp)
    ) {
        val (backIcon, Ingredients) = createRefs() // Tạo tham chiếu cho biểu tượng

        Image(
            painter = painterResource(id = R.drawable.ic_back),
            contentDescription = "Back",
            modifier = Modifier
                .constrainAs(backIcon) {
                    top.linkTo(parent.top) // Nằm sát trên cùng
                    start.linkTo(parent.start) // Nằm bên trái
                    end.linkTo(parent.end) // Nằm giữa
                }
        )
        ConstraintLayout(modifier = Modifier.constrainAs(Ingredients) {
            top.linkTo(backIcon.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }) {
            Ingredients()
        }
    }
}

@Composable
fun Ingredient(
    @DrawableRes icon: Int,
    value: Int,
    unit: String = "",
    name: String,
    modifier: Modifier = Modifier
) {
    val backgroundColor = Color(0xFFFEF9E4)
    val borderColor = Color(0xFFFBE897).copy(0.7f)


    ConstraintLayout(
        modifier = modifier
            .border(BorderStroke(width = 1.dp, color = borderColor), shape = CircleShape)
            .background(color = backgroundColor, shape = CircleShape)
            .size(width = 104.dp, height = 104.dp)

    ) {
        val horizontalGuideLines = createGuidelineFromTop(0.6f)
        val horizontalGuideLinesBottom = createGuidelineFromTop(0.5f)
        val imgIcon = createRef()
        Image(
            painter = painterResource(id = icon),
            contentDescription = null,
            modifier = Modifier.constrainAs(imgIcon) {
                top.linkTo(parent.top, margin = 3.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(horizontalGuideLines)
                height = Dimension.fillToConstraints
            })
        val (tvValue, tvUnit, tvName) = createRefs()

        val verticalGuideLineslf = createGuidelineFromStart(0.4f)
        val verticalGuideLines = createGuidelineFromStart(0.5f)

        val valueTextColor = Color(0xFFFB7D8A)
        Text(text = value.toString(), style = TextStyle(
            color = valueTextColor,
            fontWeight = FontWeight.SemiBold,
            fontSize = 32.sp,
            lineHeight = 14.sp
        ),
            modifier = Modifier.constrainAs(tvValue) {
                top.linkTo(horizontalGuideLinesBottom)
                start.linkTo(parent.start, 22.dp)
                end.linkTo(verticalGuideLineslf)
                //                bottom.linkTo(parent.bottom)
            }
        )

        unit?.let {
            Text(text = unit, style = TextStyle(
                color = valueTextColor,
                fontWeight = FontWeight.SemiBold,
                fontSize = 12.sp,
                lineHeight = 14.sp
            ),
                modifier = Modifier.constrainAs(tvUnit) {
                    top.linkTo(tvValue.bottom)
                    start.linkTo(parent.start, 30.dp)
                    end.linkTo(verticalGuideLines)
                    bottom.linkTo(parent.bottom, 12.dp)
                })
        }
        val bottomBarrier = createBottomBarrier(tvValue, tvUnit)
        val endGuideLine = createGuidelineFromEnd(0.1f)
        Text(
            text = name, style = TextStyle(
                color = Color(0xFF1E2742),
                lineHeight = 14.sp,
                fontSize = 12.sp,
            ),
            modifier = Modifier.constrainAs(tvName) {
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

@Composable
fun Ingredients(modifier: Modifier = Modifier) {
    ConstraintLayout() {

        val configuration = LocalConfiguration.current
        val screenWidth = configuration.screenWidthDp.dp
        val itemWidth = screenWidth * 0.3f

        val (tvIngredients, imgArrow) = createRefs();
        Text(text = "Ingredients", style = TextStyle(
            fontWeight = FontWeight.SemiBold,
            fontSize = 24.sp,
            lineHeight = 14.sp,
            color = Color(0xffFB7D8A)
        ),
            modifier = Modifier.constrainAs(tvIngredients) {
                top.linkTo(parent.top)
                start.linkTo(parent.start, margin = 10.dp)
            }
        )
        Icon(imageVector = Icons.Outlined.KeyboardArrowRight,
            contentDescription = null,
            tint = Color(0xffFB7D8A),
            modifier = Modifier
                .size(24.dp)
                .constrainAs(imgArrow) {
                    start.linkTo(tvIngredients.end, margin = 6.dp)
                    bottom.linkTo(tvIngredients.bottom)
                })

        val (lineOne, lineTwo) = createRefs()

        ConstraintLayout(modifier = Modifier
            .fillMaxWidth()
            .constrainAs(lineOne) {
                start.linkTo(parent.start, margin = 0.dp)
                top.linkTo(tvIngredients.bottom, margin = 14.dp)
            }) {
            val (e1, e2, e3) = createRefs()
            val lineOneChain = createHorizontalChain(e1, e2, e3, chainStyle = ChainStyle.Spread)
            Ingredient(
                icon = R.drawable.ic_different2,
                value = 8,
                unit = "",
                name = "Mint Leaves",
                modifier = Modifier
                    .size(itemWidth)
                    .constrainAs(e1) { lineOneChain }
            )
            Ingredient(
                icon = R.drawable.ic_lemon,
                value = 2,
                unit = "",
                name = "Lemon Wedges",
                modifier = Modifier
                    .size(itemWidth)
                    .constrainAs(e2) { lineOneChain }
            )
            Ingredient(
                icon = R.drawable.ic_tea,
                value = 30,
                unit = "ml",
                name = "Lemon Juice",
                modifier = Modifier
                    .size(itemWidth)
                    .constrainAs(e3) { lineOneChain }
            )
        }

        ConstraintLayout(modifier = Modifier
            .fillMaxWidth()
            .constrainAs(lineTwo) {
                start.linkTo(parent.start, margin = 0.dp)
                top.linkTo(lineOne.bottom, margin = 14.dp)
            }) {
            val (e1, e2, e3) = createRefs()
            val lineOneChain = createHorizontalChain(e1, e2, e3, chainStyle = ChainStyle.Spread)
            Ingredient(
                icon = R.drawable.ic_ice,
                value = 6,
                unit = "",
                name = "Ice Cubes",
                modifier = Modifier
                    .size(itemWidth)
                    .constrainAs(e1) { lineOneChain }
            )
            Ingredient(
                icon = R.drawable.ic_spoon,
                value = 2,
                unit = "tbsp",
                name = "Sugar",
                modifier = Modifier
                    .size(itemWidth)
                    .constrainAs(e2) { lineOneChain }
            )
            Ingredient(
                icon = R.drawable.ic_icess,
                value = 30,
                unit = "ml",
                name = "Club Soda",
                modifier = Modifier
                    .size(itemWidth)
                    .constrainAs(e3) { lineOneChain }
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun IngredientPreview() {
    Row() {
        Ingredient(
            icon = R.drawable.ic_different2,
            name = "Lemon Juice",
            unit = "ml",
            value = 10,
            modifier = Modifier.size(100.dp)
        )
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    LearnAboutJetpackComposeTheme {
        HomeScreen()
    }
}

