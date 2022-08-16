package com.example.uadadvertisore.navigation

sealed class Screen (val route : String) {

    object IntroScreen : Screen("intro_screen")
    object LoginScreen : Screen("login_screen")
    object OTPScreen : Screen("otp_screen")
    object CompanyProfileScreen : Screen("company_profile_screen")
    object AddBusinessCategoryScreen : Screen("add_business_category_screen")
    object AddYourBrand : Screen("add_your_brand_screen")
    object HomeScreen : Screen("home_screen")
    object CreateCampaignScreen : Screen("create_campaign_screen")
    object WalletScreen : Screen("wallet_screen")

    fun withArgs(vararg args: String) : String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}
