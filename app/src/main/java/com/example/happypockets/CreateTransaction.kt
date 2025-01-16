package com.example.happypockets

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.happypockets.ui.theme.offWhite

@Composable
fun CreateTransaction(autoPadding: PaddingValues) {
    //Add the gray background first
    Surface(
        modifier= Modifier.padding(autoPadding)
            .fillMaxSize(),
        color = offWhite,
        shape = RoundedCornerShape(10.dp)
    ){
        Text("HELLO WORLDDDD\n AAAAAAAAAAAAAAAAAAAAAAAAAAAA")
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