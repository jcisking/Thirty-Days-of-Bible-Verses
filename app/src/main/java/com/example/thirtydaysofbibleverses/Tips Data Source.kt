package com.example.thirtydaysofbibleverses

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.thirtydaysofbibleverses.data.Tip

@Composable
fun TipItem(tip: Tip) {
    Row() {
        Image(painter = painterResource(id = tip.imageRes), contentDescription = null)
        Column() {
            Text(text = stringResource(id = tip.dayRes))
            Text(text = stringResource(id = tip.verseRes) )
            Text(text = stringResource(id = tip.verseTextRes))
        }

    }
}