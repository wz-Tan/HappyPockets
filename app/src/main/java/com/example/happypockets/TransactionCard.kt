package com.example.happypockets

import androidx.compose.foundation.Image
import androidx.compose.material3.Surface
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happypockets.ui.theme.Itim
import com.example.happypockets.ui.theme.cardColour
import kotlinx.serialization.Serializable

@Composable
fun createCard(){
    Surface(
        modifier=Modifier
            .fillMaxWidth()
            .padding(vertical=5.dp)
            .height(80.dp),
        color= cardColour,
        shape= RoundedCornerShape(20.dp),
        shadowElevation = 10.dp
    ) {
        Row{
            Image(
                painter = painterResource(R.drawable.ic_launcher_foreground),
                contentDescription = "Image For Face"
            )

            Column(Modifier.padding(vertical = 5.dp)){
                Text(text="Word Goes Here")

                Text(text="Description Goes Here",
                    fontFamily = Itim,
                    fontSize = 20.sp)
            }

        }
    }
}

@Serializable
data class transactionData(
    var title:String,
    var amount:Float,
)
