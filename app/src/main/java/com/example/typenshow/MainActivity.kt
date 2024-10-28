package com.example.typenshow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.typenshow.ui.theme.TypenshowTheme
// import androidx.compose.material3.MaterialTheme
// import androidx.compose.material3.ExperimentalMaterial3Api
// Android Studio says these are unused, but let them be here for safety

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TypenshowTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { paddingValues ->
                    TextInputField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(paddingValues)
                            .padding(16.dp)
                    )


                }
            }
        }
    }
}

/*
 TODO 1. Add Settings for changing fonts and their sizes
      2. Add Theming for the Background and Text
      3. Publish it to F-Droid

 DONE 1. Randomize starting text
 */


// @OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextInputField(modifier: Modifier = Modifier) {
    var text by remember { mutableStateOf("") }
    val placeholders = listOf("Type something...",
                                "Numbers, Mason!",
                                "Where's the money, Lebowski?",)

    TextField(
        value = text,
        onValueChange = { text = it },
        modifier = modifier,
        textStyle = TextStyle(
            fontSize = 20.sp,
            fontFamily = FontFamily.Default
        ),
        placeholder = { androidx.compose.material3.Text(placeholders.random()) }
    )
}