package com.example.happypockets

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happypockets.ui.theme.Itim
import com.example.happypockets.ui.theme.offWhite

@Preview
@Composable
fun CreateTransaction(){
    //Add the gray background first
    Surface(
        modifier= Modifier
            .fillMaxWidth()
            .height(200.dp),
        color = offWhite,
        shape = RoundedCornerShape(10.dp)
    ){
        Text("HELLO WORLDDDD")
        /*Box{
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Spacer(modifier=Modifier.fillMaxWidth()
                    .height(20.dp))
                Text(text="Create Transaction",
                    fontFamily = Itim,
                    fontSize = 30.sp,)
            }
        }*/

    }
}