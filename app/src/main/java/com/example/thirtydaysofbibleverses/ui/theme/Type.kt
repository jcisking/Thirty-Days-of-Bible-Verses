package com.example.thirtydaysofbibleverses.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.thirtydaysofbibleverses.R


val NotoSerfDisplay = FontFamily(
    Font(R.font.notoserifdisplay_bold, FontWeight.Bold)
)

val SofiaSans = FontFamily(
    Font(R.font.sofiasans_regular, FontWeight.Normal),
    Font(R.font.sofiasans_bold, FontWeight.Bold),
    Font(R.font.sofiasans_extralight, FontWeight.ExtraLight)
)

// Set of Material typography styles to start with
val Typography = Typography(
    defaultFontFamily = SofiaSans,
    h1 = TextStyle(
        fontFamily = NotoSerfDisplay,
        fontWeight = FontWeight.Bold,
        fontSize = 30.sp
    ),
    h2 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 30.sp
    ),
    h3 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp
    ),
    body1 = TextStyle(
        fontWeight = FontWeight.ExtraLight,
        fontSize = 16.sp
    )

    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)