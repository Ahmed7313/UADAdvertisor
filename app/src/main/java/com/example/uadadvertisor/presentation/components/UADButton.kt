package com.example.ui_component.ui.theme.ui

import android.widget.ImageButton
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uadadvertisor.R
import com.example.uadadvertisor.presentation.theme.UADTextFirstColor
import com.example.uadadvertisor.presentation.theme.UADTextSecColor


@Composable
fun UADButton(text: String,
              modifier: Modifier = Modifier,
              onClickAction: () -> Unit,
){
    Row(
        modifier = modifier
            .clickable {  onClickAction() }
            .background(
                color = UADTextSecColor,
                shape = RoundedCornerShape(24.dp)
            )
            .height(40.dp)
        ,
    ) {

        Image(
            painter = painterResource(id = R.drawable.ic_small_arrow),
            contentDescription = null,
            modifier = Modifier
                .height(40.dp).padding(start = 16.dp, end = 8.dp)
        )

        TextButton(
            onClick = { onClickAction()},
            modifier = Modifier
                .background(
                    color = UADTextFirstColor,
                    shape = RoundedCornerShape(24.dp)
                )
                .then(
                    Modifier
                        .height(40.dp)
                )

        ) {
            Text(text = text , color = Color.White)
        }
    }
}

@Preview
@Composable
fun UADButtonPreview (){
    Row(modifier = Modifier.width(240.dp).height(250.dp)) {
    }
    UADButton(text = "Next", modifier = Modifier) {
        
    }
}