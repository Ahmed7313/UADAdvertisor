package com.example.uadadvertisor.presentation.registration

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.uadadvertisor.R
import com.example.uadadvertisor.presentation.components.ImageWithBackground
import com.example.uadadvertisor.presentation.theme.MainTextColor
import com.example.uadadvertisor.presentation.theme.RedTextColor
import com.example.uadadvertisore.navigation.Screen
import com.example.ui_component.ui.theme.ui.UADButton


@Composable
fun IntroScreen (navController: NavController) {

    ConstraintLayout() {
        val (buttonsRow) = createRefs()

        Column(modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)) {
            ImageWithBackground(
                painter = painterResource(id = R.drawable.intro_main_image),
                backgroundDrawableResId = R.drawable.intro_background,
                contentDescription = "",
                modifier = Modifier
                    .height(423.dp)
                    .width(392.58.dp)
            )

            Text(
                text = "Get Started",
                fontSize = 14.sp,
                color = RedTextColor,
                modifier = Modifier.padding(start = 24.dp, top = 16.dp)
            )

            Text(
                text = "Millions of People use\n" +
                        "to turn their ideas into\n" +
                        "reality",
                fontSize = 26.sp,
                color = MainTextColor,
                modifier = Modifier
                    .padding(start = 24.dp, top = 18.dp)
                    .width(269.dp)
            )

            Text(
                text = "Lorem ipsum is a placeholder text commonly used \n" +
                        "to demonstrate the visual form of a document.",
                fontSize = 14.sp,
                color = MainTextColor,
                modifier = Modifier
                    .padding(start = 24.dp, top = 24.dp)
                    .width(311.dp)
            )
        }

        UADButton(
            text = "Next",
            modifier = Modifier.padding(start = 24.dp, end = 24.dp)
                .constrainAs(buttonsRow){
                    bottom.linkTo(parent.bottom, margin = 24.dp)
                }
        ) {
            navController.navigate(route = Screen.LoginScreen.route)
        }

//                        Button(
//                            onClick = { /*TODO*/ },
//                            modifier = Modifier,
//                            colors = ButtonDefaults.buttonColors(containerColor = buttonLightBackground)
//                        ) {
//                            Text(text = "Skip Now", color = UADTextSecColor)
//                        }

                    }
}

@Preview
@Composable
fun IntroScreenPreview(){
    IntroScreen(navController = rememberNavController())
}