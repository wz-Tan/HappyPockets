package com.example.happypockets

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happypockets.ui.theme.Itim
import com.example.happypockets.ui.theme.offWhite

@Composable
fun CreateTransactionPage(autoPadding: PaddingValues) {
    //Maybe take over the head of the overview
    Surface(
        modifier= Modifier
            .padding(horizontal = autoPadding.calculateLeftPadding(LayoutDirection.Ltr)+10.dp,
            vertical = autoPadding.calculateTopPadding()),
        color = offWhite,
        shape = RoundedCornerShape(10.dp)
    ){
        Column(
        ){
            Spacer(modifier=Modifier.fillMaxWidth()
                .height(20.dp))

            Row(modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
                verticalAlignment = Alignment.CenterVertically
                ){

                Text(text="Transaction Details")
                /*Icon(
                    Icons.Default.ArrowBack,
                    "Back Icon",
                    modifier=Modifier.clickable { Log.i("CreateTransaction","Back Button is Clicked") }
                        .width(30.dp)
                        .height(30.dp)
                )*/
            }

            //Create Data Box here, the contents will be fed into the item
            CreateDataBox(
                {
                    Row(verticalAlignment = Alignment.CenterVertically){

                        Text(text="Type")
                    }
                }
            )
        }
    }
}


@Composable
fun CreateDataBox(content: @Composable () ->Unit){
    Surface(modifier=Modifier.fillMaxWidth()
        .height(80.dp)
        .padding(horizontal = 10.dp),
        color= Color.Yellow.copy(0.7F),
        shape = roundedRectangle
    ){
        content()

    }
}