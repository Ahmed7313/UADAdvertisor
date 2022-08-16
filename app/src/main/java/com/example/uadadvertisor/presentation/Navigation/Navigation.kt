package com.example.uadadvertisor.presentation.Navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.uadadvertisor.presentation.registration.AddYourBrandsScreen.AddYourBrands
import com.example.uadadvertisor.presentation.registration.CompaneyProfileScreen.CompanyProfileScreen
import com.example.uadadvertisor.presentation.registration.IntroScreen
import com.example.uadadvertisor.presentation.registration.loginScreen.LogInScreen
import com.example.uadadvertisor.presentation.registration.otpScreen.OTBScreen
import com.example.uadadvertisore.navigation.Screen

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SetUpNavGraph (navController : NavHostController){

    NavHost(navController  = navController, startDestination = Screen.IntroScreen.route ){

        composable(route = Screen.IntroScreen.route){
            IntroScreen(navController)
        }
        composable(route = Screen.LoginScreen.route){
            LogInScreen(navController)
        }
        composable(route = Screen.OTPScreen.route +"/{phone}", arguments = listOf(
            navArgument("phone"){
                type = NavType.StringType
                nullable = false
            }
        )
        ){ entry ->
            OTBScreen(navController, phone = entry.arguments?.getString("phone")!!)
        }
        composable(route = Screen.CompanyProfileScreen.route +"/{phone}", arguments = listOf(
            navArgument("phone"){
                type = NavType.StringType
                nullable = false
            }
        )
        ){ entry ->
            CompanyProfileScreen(navController, phone = entry.arguments?.getString("phone")!!)
        }
        composable(Screen.AddBusinessCategoryScreen.route){
            //AddBusinessCategoryScreen()
        }
        composable(Screen.AddYourBrand.route){
            AddYourBrands(navController)
        }
    }
}