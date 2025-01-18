package com.example.happypockets

import android.icu.text.SimpleDateFormat
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happypockets.ui.theme.HappyPocketsTheme
import com.example.happypockets.ui.theme.IncomeBannerGreen
import com.example.happypockets.ui.theme.Itim
import com.example.happypockets.ui.theme.White
import kotlinx.datetime.LocalDateTime
import java.util.Calendar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HappyPocketsTheme {
                pageLayout()
            }
        }
    }
}

interface AppBarColors{
    companion object{
        val overviewColor= IncomeBannerGreen
        val transactionColor= Color.Gray
    }
}

interface Titles{
    companion object{
        val overview="Overview"
        val createTransaction="Create Transacton"
    }
}

val roundedRectangle= RoundedCornerShape(20.dp)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun pageLayout(){
    var currColor by remember { mutableStateOf(IncomeBannerGreen) }
    var title by remember{ mutableStateOf(Titles.overview) }
    var createTransaction by remember { mutableStateOf(false) }
    var showActionButton by remember { mutableStateOf(true) }

    Scaffold(
        topBar = {
            TopAppBar(

                colors = TopAppBarColors(
                    containerColor = currColor,
                    titleContentColor = White,
                    scrolledContainerColor = MaterialTheme.colorScheme.secondary,
                    navigationIconContentColor = MaterialTheme.colorScheme.secondary,
                    actionIconContentColor = MaterialTheme.colorScheme.secondary,
                ),

                title = {

                    Row(modifier = Modifier.fillMaxSize(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center){
                        Text(text=title,
                            color = Color.White,
                            fontFamily = Itim,
                            fontSize=35.sp,
                            fontWeight = FontWeight.Bold
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
                            currColor= AppBarColors.transactionColor
                            title=Titles.createTransaction
                        }
                        showActionButton=false
                    }) {
                    //Default Icons In this Dir
                    Icon(Icons.Default.AddCircle,"Add Icon")
                }
            }
        }
    ){
        autoPadding->
        if (createTransaction){
            CreateTransaction(autoPadding)
        }
        else{
            CreateIncomePage(autoPadding)
        }
        }
}