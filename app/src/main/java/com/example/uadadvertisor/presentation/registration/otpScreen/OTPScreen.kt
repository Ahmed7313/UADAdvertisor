package com.example.uadadvertisor.presentation.registration.otpScreen

import android.os.Build
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.uadadvertisore.UIscreens.uiComponent.UADEditText
import com.example.uadadvertisor.R
import com.example.uadadvertisor.presentation.theme.RedTextColor
import com.example.uadadvertisor.presentation.theme.textColor
import com.example.uadadvertisor.presentation.theme.textColor2


import com.example.ui_component.ui.theme.ui.UADButton

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun OTBScreen(navigator : NavController, phone : String){
    val context = LocalContext.current

    var otp by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .background(color = Color.White)
            .fillMaxSize()
    ) {

        Icon(
            painter = painterResource(id = R.drawable.ic_small_arrow),
            contentDescription = null,
            modifier = Modifier.padding(top = 24.dp, start = 24.dp)
        )

        Text(
            text = "sign up",
            fontSize = 14.sp,
            modifier = Modifier.padding(top = 83.dp, start = 24.dp, end = 24.dp),
            color = textColor
        )

        Text(
            text = "Verify your Account",
            fontSize = 30.sp,
            modifier = Modifier
                .padding(top = 8.dp, start = 24.dp, end = 24.dp)
                .width(224.dp)
                .height(70.dp)
        )

        Text(
            text = "Please enter the 4 digit code sent  to \n" +
                    "to your messages",
            fontSize = 14.sp,
            modifier = Modifier
                .padding(top = 16.dp, start = 24.dp, end = 24.dp)
                .width(229.dp),
            color = textColor2
        )

        Text(
            text = "OTP",
            fontSize = 14.sp,
            modifier = Modifier
                .padding(top = 16.dp, start = 24.dp, end = 24.dp)
                .fillMaxWidth(1F),
            color = RedTextColor
        )
        
        Row(
            modifier = Modifier
                .padding(start = 24.dp, end = 24.dp, top = 8.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        )
        {
            var textValue1 by remember { mutableStateOf("") }
            var textValue2 by remember { mutableStateOf("") }
            var textValue3 by remember { mutableStateOf("") }
            var textValue4 by remember { mutableStateOf("") }

            val maxChar = 1

            UADEditText(
                text =textValue1 ,
                onTextChange = {if (it.length <= maxChar) textValue1 = it },
                isError = false,
                modifier = Modifier.width(60.dp),
                keyboardType = KeyboardOptions(
                    keyboardType = KeyboardType.Phone,
                    imeAction = ImeAction.Done)
            )
            UADEditText(
                text =textValue2 ,
                onTextChange = {if (it.length <= maxChar) textValue2 = it },
                isError = false,
                modifier = Modifier.width(60.dp),
                keyboardType = KeyboardOptions(
                    keyboardType = KeyboardType.Phone,
                    imeAction = ImeAction.Done)
            )
            UADEditText(
                text =textValue3 ,
                onTextChange = {if (it.length <= maxChar) textValue3 = it },
                isError = false,
                modifier = Modifier.width(60.dp),
                keyboardType = KeyboardOptions(
                    keyboardType = KeyboardType.Phone,
                    imeAction = ImeAction.Done)
            )
            UADEditText(
                text =textValue4 ,
                onTextChange = {if (it.length <= maxChar) textValue4 = it },
                isError = false,
                modifier = Modifier.width(60.dp),
                keyboardType = KeyboardOptions(
                    keyboardType = KeyboardType.Phone,
                    imeAction = ImeAction.Done)
            )

            otp = "${textValue1}${textValue2}${textValue3}${textValue4}"
            Log.e("optText", otp)

        }

        Text(
            text = "Resend Code",
            fontSize = 18.sp,
            modifier = Modifier
                .padding(top = 16.dp, start = 24.dp, end = 24.dp)
                .clickable { },
            color = textColor
        )

            UADButton(
                text = "Continue",
                modifier = Modifier.padding(top = 38.dp, start = 24.dp, end = 24.dp))
            {
                if (!otp.isEmpty()) {

                }
                else{
                    Toast.makeText(context,
                                   "Please Insert OTP first",
                                   Toast.LENGTH_LONG).show()
                }


            }

    }
}

@Composable
fun OTPViewItem(){
//    UADEditText(label = "", modifier = Modifier
//        .width(60.dp)
//        .height(40.dp)
//    )
    var textValue by remember { mutableStateOf("") }

    UADEditText(text =textValue , onTextChange = {textValue = it}, isError = false,
    modifier = Modifier.width(60.dp).height(40.dp))
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun OTBScreenPreview(){
    OTBScreen(rememberNavController(), "01152131093")
}