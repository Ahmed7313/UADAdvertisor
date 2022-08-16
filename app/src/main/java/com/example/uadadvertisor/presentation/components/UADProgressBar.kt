package com.example.uadadvtest.UiScreens.UiComponents

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.uadadvertisor.presentation.theme.UADTextFirstColor

@Composable
fun UADProgressBare(isDisplayed : Boolean, modifier: Modifier = Modifier) {

    if (isDisplayed){
        CircularProgressIndicator(
            modifier = modifier.size(58.dp),
            color = UADTextFirstColor,
            strokeWidth = 10.dp)
    }
}