package com.example.thirtydaysofbibleverses.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Tip(
    @StringRes val dayRes: Int,
    @StringRes val verseRes: Int,
    @StringRes val verseTextRes: Int,
    @DrawableRes val imageRes: Int
)
