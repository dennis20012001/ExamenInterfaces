package com.example.examendennishinojal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.examendennishinojal.ui.theme.ExamenDennisHinojalTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ExamenDennisHinojalTheme {
                Greeting()
            }
        }
    }
}

@Composable
fun Greeting() {
    GreetingPreview()
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    ExamenDennisHinojalTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Cyan)
        ) {
            Row(
                modifier = Modifier
                    .background(Color.LightGray)
            ) {
                Column(
                    modifier = Modifier
                        .padding(40.dp)
                )
                {
                    Text("hello android")
                }
                Column(
                    modifier = Modifier
                        .padding(40.dp)
                ) {
                    Text("hello android")
                }
                Column(
                    modifier = Modifier
                        .padding(40.dp)
                ) {
                    Text("hello android")
                }

            }
        }
    }
}