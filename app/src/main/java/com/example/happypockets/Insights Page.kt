package com.example.happypockets

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun CreateInsightsPage(autoPadding: PaddingValues) {
    Surface(modifier=
    Modifier.padding(autoPadding)
        .fillMaxSize()){
        Text(text="Hello World")
    }

}