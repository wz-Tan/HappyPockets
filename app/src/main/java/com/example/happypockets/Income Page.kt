package com.example.happypockets

import android.icu.text.SimpleDateFormat
import android.util.Log
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.example.happypockets.ui.theme.cardColour
import java.util.Calendar


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateIncomePage(autoPadding:PaddingValues){

            Column (modifier=Modifier
                .padding(horizontal = autoPadding.calculateLeftPadding(LayoutDirection.Ltr)+10.dp,
                    vertical = autoPadding.calculateTopPadding())
                .verticalScroll(
                    enabled = true,
                    state = ScrollState(0))
            ){

                Box(
                    modifier=Modifier.padding(vertical = 5.dp)
                ){
                    Text(text="Overview",
                        textAlign = TextAlign.Left,
                        style = MaterialTheme.typography.bodyLarge,
                    )
                }

                Surface(
                    modifier = Modifier
                        .padding(vertical=10.dp)
                        .height(220.dp)
                        .fillMaxWidth(),
                    color = cardColour,
                    shape = roundedRectangle,
                    shadowElevation = 5.dp
                ){
                    Text(text="Graph Area",
                        textAlign = TextAlign.Center)
                }
                
                //Transactions Text
                Box(
                    modifier=Modifier
                        .padding(vertical=5.dp)
                ){
                    Text(text="Transactions",
                        style=MaterialTheme.typography.bodyLarge)
                }

                //Card Section
                createCard()
                createCard()
                createCard()
                createCard()
                createCard()
                createCard()
            }

        }

fun getTime(){
    val time= Calendar.getInstance().time
    val formatter= SimpleDateFormat("dd/MM/YY, HH:mm aaa")
    Log.i("time", formatter.format(time))
}

