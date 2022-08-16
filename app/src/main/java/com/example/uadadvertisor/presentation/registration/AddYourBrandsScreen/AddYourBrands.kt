package com.example.uadadvertisor.presentation.registration.AddYourBrandsScreen

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import com.example.uadadvertisore.UIscreens.uiComponent.UADEditText
import com.example.uadadvertisor.R
import com.example.uadadvertisor.presentation.theme.*
import com.example.ui_component.ui.theme.ui.UADButton
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import timber.log.Timber


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AddYourBrands(navController: NavController,
){

    val sheetState = rememberBottomSheetState(
        initialValue = BottomSheetValue.Collapsed
    )
    val scaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = sheetState
    )
    val scope = rememberCoroutineScope()


   // val brandList = addBrandViewModel.brandList
    
    BottomSheetScaffold(
        scaffoldState = scaffoldState,
        sheetPeekHeight = 0.dp,
        sheetShape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp),
        sheetContent = {
            ButtonSheetContent(scope, sheetState)
    }
    ) {

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
                text = "Add your\n" +
                        "Brands",
                fontSize = 30.sp,
                modifier = Modifier
                    .padding(top = 44.dp, start = 24.dp, end = 24.dp)
                    .width(224.dp)
                    .height(90.dp)
            )

            Text(
                text = "Choose the brands that’s fits your business business.",
                fontSize = 14.sp,
                modifier = Modifier
                    .padding(top = 18.dp, start = 24.dp, end = 24.dp)
                    .width(327.dp)
                    .height(38.dp),
                color = textColor2
            )
            Spacer(modifier = Modifier.padding(top = 37.dp)
            )

            val stroke = Stroke(width = 2f,
                pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)
            )
            Box(
                Modifier
                    .fillMaxWidth()
                    .height(45.dp)
                    .padding(start = 24.dp, end = 24.dp, top = 16.dp)
                    .clickable {
                        scope.launch {
                            if (sheetState.isCollapsed) {
                                sheetState.expand()
                            } else {
                                sheetState.collapse()
                            }
                        }
                    }
                ,contentAlignment = Alignment.Center
            ){
                Canvas(modifier = Modifier.fillMaxSize()) {
                    drawRoundRect(color = borderStrockColor ,style = stroke,
                        cornerRadius = CornerRadius(8f, 8f))
                }
                Text(
                    textAlign = TextAlign.Center,text = "Add New"
                    , color = textColorBlue)
            }


//            LazyColumn (content =
//            {
//                items(brandList.value){ brand ->
//                    Timber.tag("brandItemCheck").v(brandList.toString())
//                    BrandCategoryItem(image = brand.image, brandName = brand.brandName){
//                            state ->
//                        Timber.tag("brandItemCheck").v(brandList.toString())
//                    }
//
//                }
//            }
//            )

        }

    }

    UADButton(text ="Go to home Screen") {
       // navController.navigate(route = Screen.HomeScreen.route)
    }

}

@Composable
fun BrandCategoryItem(
    image: String,
    brandName: String,
    modifier: Modifier = Modifier,
    clickable: (Boolean) -> Unit
){


    Box(modifier = modifier
        .fillMaxWidth()
        .background(shape = RoundedCornerShape(4.dp), color = categoryItemBGColor)
        .height(52.dp)
        .padding(start = 24.dp, end = 24.dp)) {

        Row(modifier = Modifier.align(Alignment.CenterEnd),
            verticalAlignment = Alignment.CenterVertically
            ) {

            Text(text = brandName, fontSize = 14.sp)
            Spacer(modifier = Modifier.padding(start = 16.dp, end = 16.dp))
            Image(
                painter = rememberImagePainter(data = image),
                contentDescription =null,
                modifier = Modifier
                    .width(22.dp)
                    .height(22.dp))

        }

        Image(
            painter = painterResource(id = R.drawable.ic_discard),
            contentDescription =null,
            modifier = Modifier
                .align(Alignment.CenterStart)
                .clickable {
                    clickable(true)
                }

        )

    }
}


@OptIn(ExperimentalMaterialApi::class)
@SuppressLint("MutableCollectionMutableState")
@Composable
fun ButtonSheetContent(
    scope : CoroutineScope,
    sheetState : BottomSheetState,
//    businessCategoryModel : BusiniessCategoryViewModel = BusiniessCategoryViewModel(),
//    addBrandViewModel: AddBrandViewModel = AddBrandViewModel()

){

   // val brandItems = addBrandViewModel.brandItems

   // val listOfCategories by remember { mutableStateOf(businessCategoryModel.categoryItems) }
    var imageUri by remember { mutableStateOf<Uri?>(null) }
    val context = LocalContext.current
    val bitmap = remember { mutableStateOf<Bitmap?>(null) }
    val launcher =
        rememberLauncherForActivityResult(contract =
        ActivityResultContracts.GetContent()) { uri: Uri? ->
            imageUri = uri
        }
 //   val listOfBrandItems = remember { ArrayList<BrandItem>() }

    val selectedCategoryID by remember { mutableStateOf(mutableListOf<Int>()) }
    var brandName by remember { mutableStateOf("") }


    Column (modifier = Modifier
        .background(
            color = Color.White,
            shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)
        )
        .fillMaxWidth()
    ){
        Text(text = "Brand Name", fontSize = 14.sp, color = RedTextColor,
        modifier = Modifier.padding(start = 24.dp, end = 24.dp, top = 24.dp))


        UADEditText(
            text = brandName,
            onTextChange = {brandName = it},
            isError = false,
            modifier = Modifier.padding(start = 24.dp, end = 24.dp, top = 8.dp)
        )

        val stroke = Stroke(width = 2f,
            pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)
        )
        imageUri?.let {
            if (Build.VERSION.SDK_INT < 28) {
                bitmap.value = MediaStore.Images
                    .Media.getBitmap(context.contentResolver, it)
            } else {
                val source = ImageDecoder.createSource(context.contentResolver, it)
                bitmap.value = ImageDecoder.decodeBitmap(source)
            }

        }

        Box(
            Modifier
                .fillMaxWidth()
                .height(45.dp)
                .padding(start = 24.dp, end = 24.dp, top = 16.dp)
                .clickable {
                    launcher.launch("image/*")
                }
            ,contentAlignment = Alignment.Center
        ){
            Canvas(modifier = Modifier.fillMaxSize()) {
                drawRoundRect(color = borderStrockColor ,style = stroke,
                    cornerRadius = CornerRadius(8f, 8f))
            }
            Text(
                textAlign = TextAlign.Center,text = "Add Brand Logo"
            , color = textColorBlue)
        }

        Text(text = "Brand Category", fontSize = 14.sp, color = RedTextColor,
            modifier = Modifier.padding(start = 24.dp,
                end = 24.dp,
                top = 44.dp,
                bottom = 24.dp)
        )

//        LazyVerticalGrid(
//            columns = GridCells.Fixed(count = 2),
//            modifier = Modifier.padding(start = 24.dp, end = 24.dp),
//            contentPadding = PaddingValues(top = 18.dp, bottom = 18.dp),
//            verticalArrangement = Arrangement.spacedBy(18.dp),
//            horizontalArrangement = Arrangement.SpaceBetween,
//            content = {
//                itemsIndexed(listOfCategories.value!!) { index , item ->
//                    var selected by remember { mutableStateOf(false) }
//                    var selectedImageState by remember {
//                        mutableStateOf( 0f)
//                    }
//                    if (selected)
//                    {
//                        selectedImageState = 1f
//                    }else{
//                        selectedImageState = 0f
//                    }
//
//                    BusinessCategoryItem(
//                        image = item.image ,
//                        label =item.name ,
//                        selected = selected ,
//                        selectedImageState = selectedImageState
//                    ) {
//                        selected =! selected
//                        selectedCategoryID.add(item.id)
//                    }
//                }
//            }
//        )



        Row(modifier = Modifier.padding(top = 68.dp, start = 24.dp, end = 24.dp, bottom = 36.dp)) {
            UADButton(text = "ADD" ) {

//                if (imageUri != null){
//
//                    val file = addBrandViewModel.createTmpFileFromUri(context, imageUri!!, brandName)
//
////                val file = File(imageUri!!.path!!)
//                    Log.v("filePath", file.toString() +
//                            " " + imageUri.toString() + " " + bitmap.value)
//                    val categoryIdList : Array<Int> = selectedCategoryID.toTypedArray()
//
//                    Log.v("AddBrandCheckLog", file.toString() + "  " +
//                            brandName + "  " + categoryIdList.toString())
//
//
//                    if (!brandName.isEmpty() && file != null && !selectedCategoryID.isEmpty()) {
//                        addBrandViewModel.addBrand(brandName, file!!, selectedCategoryID.toTypedArray(), object:
//                            ResponseCallback {
//                            override fun onCallback(
//                                value: Boolean, logMessage: String, checkCode : Int) {
//                                if (value){
//                                    Toast.makeText(context,
//                                        "Brand was Added successfully",
//                                        Toast.LENGTH_LONG).show()
//                                    val brandItem = BrandItem(imageUri.toString(), brandName, false)
//
//                                    addBrandViewModel.brandList.value = brandItems + brandItem
//                                    scope.launch {
//                                        if (sheetState.isExpanded) {
//                                            sheetState.collapse()
//                                        } else {
//                                            sheetState.expand()
//                                        }
//                                    }
//
//
//                                    Log.v("status", logMessage)
//                                }
//                                else{
//                                    Toast.makeText(context,
//                                        logMessage,
//                                        Toast.LENGTH_LONG).show()
//                                    Log.v("status", value.toString())
//                                }
//                            }
//                        }
//                        )
//                    }else {
//                        Toast.makeText(context, "Please Fill the Data First", Toast.LENGTH_LONG).show()
//                    }
//                } else{
//                    Toast.makeText(context, "Please Fill the Data First", Toast.LENGTH_LONG).show()
//                }

            }
        }
    }
}

@Composable
fun BusinessCategoryItem(
    image: String,
    label: String,
    selected: Boolean,
    selectedImageState: Float,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
){

    Box() {

        androidx.compose.material3.Surface(
            shadowElevation = 8.dp, border =
            if (selected) BorderStroke(2.dp, borderStrockColor)
            else BorderStroke(0.dp, categoryItemBGColor),
            shape = RoundedCornerShape(8.dp)
        ) {


            Row(
                modifier = modifier
                    .background(
                        color = if (selected) Color.White else categoryItemBGColor,
                        shape = RoundedCornerShape(8.dp),
                    )
                    .width(165.dp)
                    .height(37.dp)

                    .clickable {
                        onClick()
                        // if (selected) selectedImageState = 1f
                    },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = rememberImagePainter(data = image),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(start = 12.dp)
                        .width(28.dp)
                        .height(28.dp)
                )

                Text(text = label, fontSize = 14.sp, modifier = Modifier.padding(start = 16.dp))

            }

            Image(
                painter = painterResource(id = R.drawable.marked),
                contentDescription = null,
                modifier = Modifier
                    .padding(end = 12.dp)
                    .alpha(selectedImageState)
                    .width(18.dp)
                    .height(18.dp)
                    .align(Alignment.CenterEnd)
            )
        }
    }
}


@OptIn(ExperimentalMaterialApi::class)
@Preview
@Composable
fun prevButtonSheetContent(){
    ButtonSheetContent(rememberCoroutineScope(),  rememberBottomSheetState(
        initialValue = BottomSheetValue.Collapsed
    ))
}

@Preview
@Composable
fun AddYourBrandsPreview(){
    AddYourBrands(rememberNavController())
}

@Preview
@Composable
fun BrandCategoryItemPreview(){
    BrandCategoryItem(image = "R.drawable.ic_lolo", brandName = "Fashone Storia"){}
}