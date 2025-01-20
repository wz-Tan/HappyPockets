package com.example.happypockets

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowBack
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
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happypockets.ui.theme.HappyPocketsTheme
import com.example.happypockets.ui.theme.IncomeBannerGreen
import com.example.happypockets.ui.theme.Itim
import com.example.happypockets.ui.theme.White
import com.example.happypockets.ui.theme.collabPurple
import com.example.happypockets.ui.theme.goalsBlue
import com.example.happypockets.ui.theme.insightsOrange
import com.example.happypockets.ui.theme.transactionBeige

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
        val transactionColor= transactionBeige
        val insightsColor= insightsOrange
        val chatColor= Color.Cyan
        val goalsColor= goalsBlue
        val collabColor= collabPurple
    }
}

interface Titles{
    companion object{
        const val overview="Overview"
        const val createTransaction="Create Transaction"
        const val insights="Insights"
        const val chat="Chat"
        const val goals="Financial Goals"
        const val collab="Collaboration"
    }
}

interface PageNames{
    companion object{
        const val TransactionPage="TransactionPage"
        const val OverviewPage="OverviewPage"
        const val InsightsPage="InsightsPage"
        const val ChatPage="ChatPage"
        const val GoalsPage="GoalsPage"
        const val CollabPage="CollabPage"
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
    var showBackButton by remember { mutableStateOf(false) }
    var currPage by remember {mutableStateOf("OverviewPage")}
    var prevPage by remember {mutableStateOf("")}

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
                    Box(modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center){
                        Text(text=title,
                            color = Color.White,
                            fontFamily = Itim,
                            fontSize=35.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    if (showBackButton){
                    Box(contentAlignment = Alignment.CenterStart,
                        modifier=Modifier.fillMaxSize()){
                        Icon(Icons.Default.ArrowBack, "Back Button",
                            modifier = Modifier.clickable {
                                currPage=prevPage
                            }
                                .width(40.dp))
                    }

                }
                }
            )


        },

        //Each section essentially is also a parameter
        bottomBar = {
            if (currPage!=PageNames.TransactionPage){
                BottomAppBar(
                    containerColor = currColor,
                ) {
                    Surface (modifier = Modifier.fillMaxSize(),
                        color = Color.Transparent){
                        Row (modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically){

                            Image(
                                painter = painterResource(R.drawable.icon_money),
                                contentDescription = "Overview Page Icon",
                                contentScale = ContentScale.FillBounds,
                                modifier = Modifier.size(Dp(50.0F))
                                    .clip(CircleShape)
                                    .clickable {
                                        currPage=PageNames.OverviewPage
                                    },
                                colorFilter =
                                //Use or because we might go into another section
                                if (IconTintCondition(currPage,PageNames.OverviewPage)){
                                    ColorFilter.tint(Color.White)
                                }
                                else{
                                    ColorFilter.tint(Color.Black)
                                }
                            )

                            Image(
                                painter = painterResource(R.drawable.icon_lightbulb),
                                contentDescription = "Icon of a footer item",
                                contentScale = ContentScale.FillBounds,
                                modifier = Modifier.size(Dp(50.0F))
                                    .clip(CircleShape)
                                    .clickable {
                                        currPage=PageNames.InsightsPage
                                    },
                                colorFilter =
                                if (IconTintCondition(currPage,PageNames.InsightsPage)){
                                    ColorFilter.tint(Color.White)
                                }
                                else{
                                    ColorFilter.tint(Color.Black)
                                }
                            )

                            Image(
                                painter = painterResource(R.drawable.icon_chat),
                                contentDescription = "Chat Page Icon",
                                contentScale = ContentScale.FillBounds,
                                modifier = Modifier.size(Dp(50.0F))
                                    .clip(CircleShape)
                                    .clickable {
                                        currPage=PageNames.ChatPage
                                    },
                                colorFilter =
                                if (IconTintCondition(currPage,PageNames.ChatPage)){
                                    ColorFilter.tint(Color.White)
                                }
                                else{
                                    ColorFilter.tint(Color.Black)
                                }

                            )

                            Image(
                                painter = painterResource(R.drawable.icon_target),
                                contentDescription = "Goals Page Icon",
                                contentScale = ContentScale.FillBounds,
                                modifier = Modifier.size(Dp(50.0F))
                                    .clip(CircleShape)
                                    .clickable {
                                        currPage=PageNames.GoalsPage
                                    },
                                colorFilter =
                                if (IconTintCondition(currPage,PageNames.GoalsPage)){
                                    ColorFilter.tint(Color.White)
                                }
                                else{
                                    ColorFilter.tint(Color.Black)
                                }
                            )

                            Image(
                                painter = painterResource(R.drawable.icon_community),
                                contentDescription = "Collab Page Icon",
                                contentScale = ContentScale.FillBounds,
                                modifier = Modifier.size(Dp(50.0F))
                                    .clip(CircleShape)
                                    .clickable {
                                        currPage=PageNames.CollabPage
                                    },
                                colorFilter =
                                if (IconTintCondition(currPage,PageNames.CollabPage)){
                                    ColorFilter.tint(Color.White)
                                }
                                else{
                                    ColorFilter.tint(Color.Black)
                                }
                            )
                        }

                    }

                }
            }
        },

        //Add Button for Transactions
        floatingActionButton = {
            if (showActionButton){
                    Image(
                        painter = painterResource(R.drawable.icon_add),
                        "Add Transaction Icon",
                        modifier=Modifier.size(60.dp)
                        .clickable {
                            prevPage=currPage
                            currPage=PageNames.TransactionPage
                        }
                    )
            }
        }
    ){
        autoPadding->
        when (currPage){
            PageNames.OverviewPage -> {
                CreateIncomePage(autoPadding)
                showActionButton=true
                showBackButton=false
                currColor=AppBarColors.overviewColor
                title=Titles.overview
            }

            PageNames.TransactionPage -> {
                CreateTransactionPage(autoPadding)
                showActionButton=false
                showBackButton=true
                currColor=AppBarColors.transactionColor
                title=Titles.createTransaction
            }

            PageNames.InsightsPage -> {
                CreateInsightsPage(autoPadding)
                showActionButton=false
                showBackButton=false
                currColor=AppBarColors.insightsColor
                title=Titles.insights
            }

            PageNames.ChatPage -> {
                CreateChatPage(autoPadding)
                showActionButton=false
                showBackButton=false
                currColor=AppBarColors.chatColor
                title=Titles.chat
            }

            PageNames.GoalsPage -> {
                CreateGoalsPage(autoPadding)
                showActionButton=false
                showBackButton=false
                currColor=AppBarColors.goalsColor
                title=Titles.goals
            }

            PageNames.CollabPage -> {
                CreateCollabPage(autoPadding)
                showActionButton=false
                showBackButton=false
                currColor=AppBarColors.collabColor
                title=Titles.collab
            }


        }
    }
}

//Logic here needs work (How do we handle a back button?)
fun IconTintCondition(currPage:String, desiredPage:String): Boolean {
    if (currPage == desiredPage){
        return true
    }
    else{
        return false
    }
}