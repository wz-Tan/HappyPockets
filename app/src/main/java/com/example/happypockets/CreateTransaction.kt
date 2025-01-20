package com.example.happypockets

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happypockets.ui.theme.Itim
import com.example.happypockets.ui.theme.TransactionAmountStyle
import com.example.happypockets.ui.theme.White
import com.example.happypockets.ui.theme.cardColour
import com.example.happypockets.ui.theme.offWhite

@Composable
fun CreateTransactionPage(autoPadding: PaddingValues) {
    var amount by remember {mutableStateOf("0.00")}
    //In SQL, we would use * to mean infinite number, \* to mean we only want the char *
    //However, in kotlin, in order to access \* we need to use \\*
    //Usually, \d means any digit 0 to 9, to call that we need \\d
    //+ means at least one ()? means optional
    //the {1,2} means either 1 or 2 numbers
    val currencyRegex=Regex("^[0-9]+(\\.[0-9]{1,2})?$")
    Surface(
        modifier= Modifier
            .padding(autoPadding)
            .fillMaxSize(),
        color = Color.White
    ){
        Column(
        ){
            //Amount Section
            Column(modifier=Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp),
                horizontalAlignment = Alignment.CenterHorizontally){

                Text(text="Amount",
                    fontWeight= FontWeight.Light,
                    fontSize = 30.sp,
                    fontFamily = Itim,
                    color = Color.Gray)

                //Styling required, also add a currency in front
                // and convert to a 2 dp float as a variable-done through upload maybe
                TextField(
                    value= amount,
                    //lambda to run condition check
                    onValueChange = { it->
                        if (it.matches(currencyRegex) || it.isEmpty()){
                            amount=it
                        }
                        else{
                            //Get a toast alert here
                        }
                    },
                    textStyle = TransactionAmountStyle)
            }

            /*CreateDataBox(title = "Type",
                {
                    Text("Expenses")
                }
            )

            CreateDataBox(title = "Category",
                {
               Text("School")
            })

            CreateDataBox(title = "Mood",
                {
                    Row(modifier=Modifier.fillMaxSize(),
                        horizontalArrangement = Arrangement.SpaceAround){
                        Image(
                            painter= painterResource(R.drawable.ic_launcher_foreground),
                            contentDescription = "Mood 1",
                            modifier=Modifier.size(50.dp)
                        )
                    }
                })

            CreateDataBox(title = "Additional Notes",
                {
                    Surface(modifier=Modifier
                        .padding(20.dp)
                        .fillMaxSize(),
                        color= cardColour){

                    }
                })*/
        }
    }
}


@Composable
fun CreateDataBox(title:String, content: @Composable () ->Unit){
    Surface(modifier=Modifier.fillMaxWidth()
        .height(80.dp)
        .drawBehind {
            drawLine(
                color= Color.Black,
                start= Offset(x=0f,y=0f),
                end=Offset(x=size.width,y=0f)
            )

            drawLine(
                color= Color.Black,
                start= Offset(x=0f,y=size.height),
                end=Offset(x=size.width,y=size.height)
            )
        },
        color= cardColour.copy(0.5F),
        shape = RectangleShape
    ){
        Column(modifier=Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally){
            Text(title,
                fontWeight = FontWeight.Light,
                color=Color.Gray,
                fontSize = 25.sp)
            Spacer(modifier=Modifier.height(7.dp))
            content()
        }

    }
}