package com.example.happypockets

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.colorspace.Rgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happypockets.ui.theme.HappyPocketsTheme
import com.example.happypockets.ui.theme.IncomeBackgroundGreen
import com.example.happypockets.ui.theme.IncomeBannerGreen
import com.example.happypockets.ui.theme.Itim
import com.example.happypockets.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
internal fun CreateIncomePage(){
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
                            Text(text="Income",
                                fontFamily = Itim,
                                fontSize=35.sp,
                                fontWeight = FontWeight.Bold
                            )

                            Spacer(modifier=Modifier.width(Dp(10.0F)))

                            Image(
                                painter= painterResource(R.drawable.chill_guy),
                                contentDescription = "Income Icon",
                                contentScale = ContentScale.FillBounds,
                                modifier=Modifier.size(Dp(80.0F))
                            )
                        }
                    }
                )

                HorizontalDivider(color=Color.Gray, thickness = Dp(2.5F))

        },

        //Each section essentially is also a parameter
        bottomBar = {
            HorizontalDivider(thickness = Dp(3.0F), color=Color.Gray)
            BottomAppBar(
                containerColor = IncomeBannerGreen,
                contentColor=White
            ) {
                Surface (modifier = Modifier.fillMaxSize(),
                    color = Color.Transparent){
                    Row (modifier = Modifier.padding(horizontal = Dp(10.0F), vertical = Dp(5.0F)),
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


                    /*Text(text="Nav Part",
                        color = White,
                        fontFamily = Itim,
                        fontSize = 40.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )*/
                }

            }
        },

        floatingActionButton = {

        },

        containerColor = IncomeBackgroundGreen)
        //Content Starts here
        {
            Text(text="Hello World!")
        }
    }
