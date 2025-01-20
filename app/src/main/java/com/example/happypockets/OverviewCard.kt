package com.example.happypockets

import androidx.compose.foundation.Image
import androidx.compose.material3.Surface
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happypockets.ui.theme.Itim
import com.example.happypockets.ui.theme.cardColour
import kotlinx.serialization.Serializable

@Composable
fun CreateOverviewCard(){
    Surface(
        modifier=Modifier
            .fillMaxWidth()
            .padding(vertical=3.dp)
            .height(80.dp),
        color= cardColour,
        shape= RoundedCornerShape(20.dp),
        shadowElevation = 5.dp
    ) {
        Row (verticalAlignment = Alignment.CenterVertically){
            Image(
                painter = painterResource(R.drawable.ic_launcher_foreground),
                contentDescription = "Image For Face",
                modifier=Modifier.width(80.dp)
            )

            Column (modifier = Modifier.width(190.dp)){
                Text(text="School",
                    fontSize = 25.sp)

                Text(text="15/05/25, 7.00PM",
                    fontFamily = Itim,
                    fontSize = 15.sp)
            }


            Box{
                Text(text= "time",
                    fontSize = 20.sp)
            }


        }
    }
}

@Serializable
data class transactionData(
    val title:String, //This can be 16 characters max
    val time:String, //This is for the time
    val category:String,
    val amount:Float,
)

val supabase= Supabase