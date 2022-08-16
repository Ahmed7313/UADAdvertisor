package com.example.uadadvertisore.UIscreens.uiComponent

import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview
@Composable
fun UADEditTextPreview2(){
    var textValue by remember { mutableStateOf("") }

    //UADEditText(textValue, onTextChange = {textValue = it},isError = false)
}

@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Composable
fun UADEditText(
    text: String,
    onTextChange : (String) -> Unit,
    modifier: Modifier = Modifier,
    isError : Boolean,
    keyboardType: KeyboardOptions = KeyboardOptions.Default
){
    val keyboardController = LocalSoftwareKeyboardController.current
    val maxChar = 5

    OutlinedTextField(
        value = text,
        onValueChange = onTextChange,
        modifier = modifier.width(364.dp),
        isError = isError,
        keyboardOptions = keyboardType,
        shape = RoundedCornerShape(38.dp),
        keyboardActions = KeyboardActions(
            onDone = {keyboardController?.hide()})
    )
}