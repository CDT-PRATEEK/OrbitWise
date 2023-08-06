package com.example.planetgallery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.planetgallery.ui.theme.PlanetGalleryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlanetGalleryTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    PlanetGallery()
                }
            }
        }
    }
}

@Composable
fun PlanetGallery(){
    var result by remember { mutableStateOf(1) }
    var fact by remember { mutableStateOf(1) }

    fact = when(result){
        1->R.string.sunfact
        2->R.string.mercuryfact
        3->R.string.venusfact
        4->R.string.earthfact
        5->R.string.marsfact
        6->R.string.jupiterfact
        7->R.string.saturnfact
        8->R.string.uranusfact
        else->R.string.neptunefact
    }

    var name by remember { mutableStateOf(1) }

    name = when(result){
        1-> R.string.sun
        2-> R.string.mercury
        3-> R.string.venus
        4-> R.string.earth
        5-> R.string.mars
        6-> R.string.jupiter
        7-> R.string.saturn
        8-> R.string.uranus
        else-> R.string.neptune
    }

    var img by remember { mutableStateOf(1) }

    img =  when(result) {
        1 -> R.drawable.sun
        2 -> R.drawable.mercury
        3 -> R.drawable.venus
        4 -> R.drawable.earth
        5 -> R.drawable.mars
        6 -> R.drawable.jupiter
        7 -> R.drawable.saturn11
        8 -> R.drawable.uranus
        else -> R.drawable.neptune
    }

    Surface(modifier = Modifier
        .fillMaxSize()
        , color = Color.Black) {

        Box(modifier = Modifier
            .fillMaxSize()
            .fillMaxWidth()
            .graphicsLayer(shadowElevation = 20f)
            ) {

            Column(modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center) {


                Text(
                    text = "WELCOME", modifier = Modifier
                        .padding(20.dp)
                        .align(Alignment.CenterHorizontally), style = TextStyle(
                        fontSize = 30.sp, color = Color.White, fontStyle = FontStyle.Italic,
                        fontFamily = FontFamily.Serif
                    )
                )

                Spacer(modifier = Modifier.height(30.dp))

                PlanetName(name = name)

                PlanetImage(img = img)

                Spacer(modifier = Modifier.height(20.dp))

                PlanetDescription(fact = fact)

                Row(){

                    Previous( onClick = { result -= 1 })

                    Spacer(modifier = Modifier.width(60.dp))


                    Next(onClick = { result = (result%9) +1 })


                }

                }


            }
        }
    }



@Composable
fun PlanetImage(modifier: Modifier = Modifier , img : Int){

        Box(
            modifier = Modifier
                .graphicsLayer(shadowElevation = 200f)
        ) {



            Image(
                painter = painterResource(id = img),
                contentDescription = "sun",
                modifier = Modifier.size(300.dp),
                contentScale = ContentScale.Fit
            )

        }

    }

@Composable
fun PlanetName(modifier: Modifier = Modifier , name: Int) {


        Text(
            stringResource(id = name), color = Color.Yellow, fontSize = 25.sp

        )

    }

@Composable
fun Next(modifier: Modifier = Modifier ,
                    onClick:() -> Unit){



        Button(onClick = onClick,
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 20.dp,
            pressedElevation = 15.dp,
        ) ) {

            Text(
                text = "Next" , color = Color.Black , fontSize = 20.sp
            )
            
        }
    }


@Composable
fun Previous(modifier: Modifier = Modifier ,
         onClick:() -> Unit){


        Button(onClick = onClick,
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 20.dp,
                pressedElevation = 15.dp
            ) ) {

            Text(
                text = "Previous", color = Color.Black , fontSize = 20.sp
            )

        }
    }






@Composable
fun PlanetDescription(modifier: Modifier = Modifier , fact : Int){

    Text(stringResource(id = fact),
        modifier = Modifier.padding(15.dp), textAlign = TextAlign.Justify
        , fontSize = 20.sp , color = Color.White , fontStyle = FontStyle.Italic
        , fontFamily = FontFamily.SansSerif
    )
}




@Preview(showBackground = true)
@Composable
fun PlanetGalleryPreview() {
    PlanetGalleryTheme {

        PlanetGallery()

    }
}