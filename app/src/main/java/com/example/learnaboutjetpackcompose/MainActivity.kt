package com.example.learnaboutjetpackcompose

import android.R
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

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
        DemoRadioWithTitle()
        Spacer(Modifier.padding(24.dp))
        DemoRadioWithIcon()
        Spacer(Modifier.padding(24.dp))
        DemoCheckBoxButton()
    }

}

@Composable
fun DemoCheckBoxButton (){
    var isCheckBox by remember {
        mutableStateOf(false)
    }
    Row (
        modifier = Modifier.selectable(
            selected = isCheckBox,
            onClick = {isCheckBox = !isCheckBox},
            role = Role.RadioButton
        )
    ) {
        Checkbox(isCheckBox , onCheckedChange = {
            isCheckBox = it
        },
            colors = CheckboxDefaults.colors(
                checkedColor = Color.Green,
                uncheckedColor = Color.Red
            )
        )
        Text("Duoc vu" , modifier = Modifier.padding(top = 10.dp))
    }
}

@Composable
fun DemoRadioButton () {
    RadioButton( selected = true , onClick = {}, colors = RadioButtonDefaults.colors(
        selectedColor = Color.Red,
        unselectedColor = Color.Green,
        disabledSelectedColor = Color.Gray
    ))
    RadioButton( selected = false , onClick = {}, colors = RadioButtonDefaults.colors(
        selectedColor = Color.Red,
        unselectedColor = Color.Green,
        disabledSelectedColor = Color.Gray
    ))
    RadioButton( selected = true, enabled = false, onClick = {}, colors = RadioButtonDefaults.colors(
        selectedColor = Color.Red,
        unselectedColor = Color.Green,
        disabledSelectedColor = Color.Gray
    ))
}

@Composable
fun DemoRadioWithTitle () {
    var isSelected by remember {
        mutableStateOf(false)
    }
    Row (
        modifier = Modifier.selectable(
            selected = isSelected,
            onClick = {isSelected = !isSelected},
            role = Role.RadioButton
        )
    ) {
        RadioButton( selected = isSelected , onClick = {}, colors = RadioButtonDefaults.colors(
            selectedColor = Color.Red,
            unselectedColor = Color.Green,
            disabledSelectedColor = Color.Gray
        ))
        Text("Duoc vu", modifier = Modifier.padding(top = 10.dp))
    }
}

@Composable
fun DemoRadioWithIcon () {
    var isSelected by remember {
        mutableStateOf(false)
    }
    Row (
        modifier = Modifier.selectable(
            selected = isSelected,
            onClick = {isSelected = !isSelected},
            role = Role.RadioButton
        )
    ) {
        val iconRadio = if(isSelected) Icons.Default.CheckCircle else Icons.Default.Check
        Icon(iconRadio,null)
        Text("Duoc vu", modifier = Modifier.padding(top = 10.dp))
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    LearnAboutJetpackComposeTheme {
        HomeScreen()
    }
}
