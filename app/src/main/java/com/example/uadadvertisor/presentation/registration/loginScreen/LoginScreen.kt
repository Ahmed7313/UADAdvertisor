package com.example.uadadvertisor.presentation.registration.loginScreen

import android.annotation.SuppressLint
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.uadadvertisor.R
import com.example.uadadvertisor.presentation.theme.RedTextColor
import com.example.uadadvertisor.presentation.theme.textColor
import com.example.uadadvertisor.presentation.theme.textColor2

import com.example.uadadvertisore.UIscreens.uiComponent.UADEditText
import com.example.uadadvertisore.navigation.Screen
import com.example.uadadvtest.UiScreens.UiComponents.UADProgressBare

import com.example.ui_component.ui.theme.ui.UADButton


@SuppressLint("LogNotTimber")
@Composable
fun LogInScreen(
    navController: NavController,
    viewModel: LoginViewModel = hiltViewModel()
){

    val context = LocalContext.current

        Column(
            modifier = Modifier
                .background(color = Color.White)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {

            Icon(
                painter = painterResource(id = R.drawable.ic_small_arrow),
                contentDescription = null,
                modifier = Modifier.padding(top = 24.dp, start = 24.dp)
            )

            Text(
                text = "sign up",
                fontSize = 14.sp,
                modifier = Modifier.padding(top = 83.dp,start = 24.dp, end = 24.dp),
                color = textColor
            )

            Text(
                text = "Welcome to Social Network !",
                fontSize = 30.sp,
                modifier = Modifier
                    .padding(top = 8.dp, start = 24.dp, end = 24.dp)
                    .width(224.dp)
            )

            Text(
                text = "Lorem ipsum is a placeholder text commonly used to \n" +
                        "demonstrate the visual form of a document.",
                fontSize = 14.sp,
                modifier = Modifier
                    .padding(top = 16.dp, start = 24.dp, end = 24.dp)
                    .width(327.dp)
                    .height(38.dp),
                color = textColor2
            )


            Text(
                text = "Email / Phone",
                fontSize = 14.sp,
                modifier = Modifier.padding(top = 16.dp,start = 24.dp, end = 24.dp),
                color = RedTextColor
            )

//        UADEditText(modifier = Modifier.padding(start = 16.dp, end = 16.dp),
//            label = "business@example.com" )
            var phoneOrEmail by remember { mutableStateOf("") }

            UADEditText(
                phoneOrEmail,
                onTextChange = {phoneOrEmail = it},
                isError = false,
                modifier = Modifier
                    .padding(start = 24.dp, end = 24.dp, top = 8.dp)
                    .fillMaxWidth(),
                keyboardType = KeyboardOptions(
                    keyboardType = KeyboardType.Phone,
                    imeAction = ImeAction.Done)

            )
            Log.e("textValue", phoneOrEmail)

            var checkedState by remember { mutableStateOf(false) }

            TermsAndConditionsField(checkedState, onCheckedState = { checkedState = it})


            UADButton(
                text = "Continue",
                modifier = Modifier.padding(top = 28.dp, start = 24.dp, end = 24.dp)
            ) {
                Log.v("testtest", "thats a test")

                if (checkedState){
                    if (!phoneOrEmail.isEmpty()){
                        val state = viewModel.checkPhone(phoneOrEmail)
                        Log.v("testtest", viewModel.state.value.isSuccess.toString())

                        if (state){
                            navController.navigate(Screen.OTPScreen.route)
                    }

                      //  Toast.makeText(context, "Phone number is not registered", Toast.LENGTH_LONG).show()

                    }
                }else{
                    Toast.makeText(context,
                                   "Please Accept Terms and Conditions First",
                                   Toast.LENGTH_LONG).show()
                }
            }

        }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TermsAndConditionsField(checkedState : Boolean, onCheckedState : (Boolean) -> Unit) {
    Row (
        modifier = Modifier.padding(start = 24.dp, end = 24.dp),
        verticalAlignment = Alignment.CenterVertically,
        ){
        Checkbox(
            checked = checkedState,
            onCheckedChange =onCheckedState ,
        )
        Text(text = "Checkbox Example")
        Text(
            text = "Terms & Policy",
            modifier = Modifier
                .padding(start = 8.dp)
                .clickable {

                },
            color = RedTextColor,
            )

    }
}

@Preview
@Composable
fun LogInScreenPreview(){
    LogInScreen(rememberNavController())
}
