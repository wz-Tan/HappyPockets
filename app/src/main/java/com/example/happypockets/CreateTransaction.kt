package com.example.happypockets

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun CreateTransaction(){
    Box{
        //Add the gray background first
        Surface(
            modifier= Modifier.fillMaxSize(),
            color= Color.Gray.copy(alpha=0.5f)
        ){

        }
    }
}