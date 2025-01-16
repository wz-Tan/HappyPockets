package com.example.happypockets

import android.icu.text.SimpleDateFormat
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happypockets.ui.theme.IncomeBackgroundGreen
import com.example.happypockets.ui.theme.IncomeBannerGreen
import com.example.happypockets.ui.theme.Itim
import com.example.happypockets.ui.theme.White
import com.example.happypockets.ui.theme.cardColour
import java.util.Calendar


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateIncomePage(){
    var createTransaction by remember { mutableStateOf(false) }
    val roundedRectangle=RoundedCornerShape(20.dp)
    var innerPadding:PaddingValues
    var showActionButton by remember { mutableStateOf(true) }
    //Scaffold is used to clear up the Ui layout, allowing for top and bottom bar as well as an action button
    //The contents are inside of the curly brackets instead
    Scaffold(
        //Tag for topBar
        topBar = { //This is just a tag, topAppBar is a prebuilt format for the header
                TopAppBar(
                    //Set a bunch of colours to be used within the top bar
                    colors = TopAppBarColors(
                        containerColor = IncomeBannerGreen,
                        titleContentColor = White,
                        scrolledContainerColor = MaterialTheme.colorScheme.secondary,
                        navigationIconContentColor = MaterialTheme.colorScheme.secondary,
                        actionIconContentColor = MaterialTheme.colorScheme.secondary,
                    ),
                    title = {
                        //Arrangement sets how the items stack on each other
                        //Alignment is which section of the div they are in
                        //The vertical and horizontal changes based on row vs column

                        Row(modifier = Modifier.fillMaxSize(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center){
                            Text(text="Overview",
                                color = Color.White,
                                fontFamily = Itim,
                                fontSize=35.sp,
                                fontWeight = FontWeight.Bold
                            )

                            Spacer(modifier=Modifier.width(10.dp))

                            Image(
                                painter= painterResource(R.drawable.chill_guy),
                                contentDescription = "Income Icon",
                                contentScale = ContentScale.FillBounds,
                                modifier=Modifier.size(Dp(80.0F))
                            )
                        }
                    }
                )


        },

        //Each section essentially is also a parameter
        bottomBar = {
            BottomAppBar(
                containerColor = IncomeBannerGreen,
            ) {
                Surface (modifier = Modifier.fillMaxSize(),
                    color = Color.Transparent){
                    Row (modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically){

                        Image( //Assume this is a button for an icon
                            painter = painterResource(R.drawable.ic_launcher_background),
                            contentDescription = "Icon of a footer item",
                            contentScale = ContentScale.FillBounds,
                            modifier = Modifier.size(Dp(60.0F))
                                .clip(CircleShape)
                        )

                        Image( //Assume this is a button for an icon
                            painter = painterResource(R.drawable.ic_launcher_background),
                            contentDescription = "Icon of a footer item",
                            contentScale = ContentScale.FillBounds,
                            modifier = Modifier.size(Dp(60.0F))
                                .clip(CircleShape)
                        )

                        Image( //Assume this is a button for an icon
                            painter = painterResource(R.drawable.ic_launcher_background),
                            contentDescription = "Icon of a footer item",
                            contentScale = ContentScale.FillBounds,
                            modifier = Modifier.size(Dp(60.0F))
                                .clip(CircleShape)
                        )

                        Image( //Assume this is a button for an icon
                            painter = painterResource(R.drawable.ic_launcher_background),
                            contentDescription = "Icon of a footer item",
                            contentScale = ContentScale.FillBounds,
                            modifier = Modifier.size(Dp(60.0F))
                                .clip(CircleShape)
                        )

                        Image( //Assume this is a button for an icon
                            painter = painterResource(R.drawable.ic_launcher_background),
                            contentDescription = "Icon of a footer item",
                            contentScale = ContentScale.FillBounds,
                            modifier = Modifier.size(Dp(60.0F))
                                .clip(CircleShape)
                        )
                    }

                }

            }
        },
        floatingActionButton = {
            //Make it a lambda function when clicked, use a mutable state to toggle
            if (showActionButton){
                FloatingActionButton(
                    onClick = {
                        if (createTransaction==false) {
                            createTransaction=true
                        }
                        showActionButton=false
                    }) {
                    //Default Icons In this Dir
                    Icon(Icons.Default.AddCircle,"Add Icon")
                }
            }
        },
        containerColor = IncomeBackgroundGreen)
        //Content Starts here
        { autoPadding->

        innerPadding=autoPadding
            //Add the transaction screen once it is clicked

            Column (modifier=Modifier
                .padding(horizontal = autoPadding.calculateLeftPadding(LayoutDirection.Ltr)+10.dp,
                    vertical = autoPadding.calculateTopPadding())
                .verticalScroll(
                    enabled = true,
                    state = ScrollState(0))
            ){
                //Use box to align the texts
                Box(
                    modifier=Modifier.padding(vertical = 5.dp)
                ){
                    Text(text="Overview",
                        textAlign = TextAlign.Left,
                        style = MaterialTheme.typography.bodyLarge,
                    )
                }

                //Graph Area (How to add shadow without creating a box?)
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
                getTime()
                //Card Section
                createCard()
                createCard()
                createCard()
                createCard()
                createCard()
                createCard()
            }
            //Creates an object that fills the entire page
            if (createTransaction){
                CreateTransaction(innerPadding)
            }

        }


    }

fun getTime(){
    val time= Calendar.getInstance().time
    val formatter= SimpleDateFormat("dd/MM/YY, HH:mm aaa")
    Log.i("time", formatter.format(time))
}

