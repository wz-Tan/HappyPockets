package com.example.happypockets

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.example.happypockets.ui.theme.HappyPocketsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HappyPocketsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {_, ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(all = Dp(80.5F)),

                    )
                }

            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
    Bye()
}

@Composable
fun Bye(){
    Text(
        text = "Bye Bro OR Hi Sis"
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HappyPocketsTheme {
        Greeting("Android")
        Bye()
        Bye()
    }
}