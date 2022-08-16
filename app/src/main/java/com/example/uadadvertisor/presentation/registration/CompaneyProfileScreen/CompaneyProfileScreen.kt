package com.example.uadadvertisor.presentation.registration.CompaneyProfileScreen

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.uadadvertisor.R
import com.example.uadadvertisor.presentation.theme.*

import com.example.uadadvertisore.UIscreens.uiComponent.UADEditText
import com.example.ui_component.ui.theme.ui.UADButton


@Composable
fun CompanyProfileScreen(navigator: NavController, phone : String){

    val context = LocalContext.current
    var commercialNumberChecked by remember { mutableStateOf(false) }
    var commercialNumber by remember { mutableStateOf("") }

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
            text = "Create Company " +
                    "Profile",
            fontSize = 30.sp,
            modifier = Modifier
                .padding(top = 44.dp, start = 24.dp, end = 24.dp)
                .width(224.dp)

        )

        Text(
            text = "Living in today’s metropolitan world of cellular phones, mobile computers.",
            fontSize = 14.sp,
            modifier = Modifier
                .padding(top = 18.dp, start = 24.dp, end = 24.dp)
                .width(327.dp),
            color = textColor2
        )

        Text(
            text = "Company Name",
            fontSize = 14.sp,
            modifier = Modifier.padding(top = 16.dp,start = 24.dp, end = 24.dp),
            color = RedTextColor
        )

//        UADEditText(modifier = Modifier.padding(start = 16.dp, end = 16.dp),
//            label = "Golden Rush")

        var companyName by remember { mutableStateOf("") }

        UADEditText(
            text = companyName,
            onTextChange = {companyName = it},
            isError = false,
        modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 8.dp))

        Text(
            text = "Company Description",
            fontSize = 14.sp,
            modifier = Modifier.padding(top = 34.dp,start = 24.dp, end = 24.dp),
            color = RedTextColor
        )

        var companyDiscreption by remember { mutableStateOf("") }

        UADEditText(
            text = companyDiscreption,
            onTextChange = {companyDiscreption = it},
            isError = false,
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, top = 8.dp)
                .height(138.dp)
        )

        Text(
            text = "Commercial Registration Number",
            fontSize = 14.sp,
            modifier = Modifier.padding(top = 34.dp,start = 24.dp, end = 24.dp),
            color = RedTextColor
        )

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 24.dp, end = 24.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {

            Button(
                onClick = {
                },
                modifier = Modifier.height(42.dp),
                colors =
                ButtonDefaults.buttonColors(containerColor = if (commercialNumberChecked) verifiedBG else buttonLightBackground )
            ) {
                Text(text = if (commercialNumberChecked) "Verified" else "Verify",
                    color = if (commercialNumberChecked) verifiedColor else  UADTextSecColor)
            }
            Log.e("commercialNumber", commercialNumber)

            UADEditText(
                text = commercialNumber,
                onTextChange = {commercialNumber = it},
                isError = false,
                modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 8.dp),
                keyboardType = KeyboardOptions(
                    keyboardType = KeyboardType.Phone,
                    imeAction = ImeAction.Done)
            )
        }
        Text(
            text = "Phone Number",
            fontSize = 14.sp,
            modifier = Modifier.padding(top = 16.dp,start = 24.dp, end = 24.dp),
            color = RedTextColor
        )

        var phoneNumber by remember { mutableStateOf("") }

        UADEditText(
            text = phoneNumber,
            onTextChange = {phoneNumber = it},
            isError = false,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 8.dp)
        )


            UADButton(
                text = "Continue",
                modifier = Modifier.padding(top = 28.dp, start = 24.dp, end = 24.dp, bottom = 38.dp)
            ) {

                if (commercialNumberChecked) {

                }
            }

     }

}


@Preview
@Composable
fun CompanyProfileScreenPreview(){
    CompanyProfileScreen(rememberNavController(), "01014044773")
}