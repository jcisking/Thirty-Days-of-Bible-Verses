package com.example.thirtydaysofbibleverses

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.thirtydaysofbibleverses.data.Tip

@Composable
fun TipItem(tip: Tip) {
    Column() {
        Image(
            modifier = Modifier
                .size(200.dp)
                .background(Color.Red),
            painter = painterResource(id = tip.imageRes),
            contentScale = ContentScale.FillBounds
            ,
            contentDescription = null
        )
        Column() {
            Text(text = stringResource(id = tip.dayRes))
            Text(text = stringResource(id = tip.verseRes) )
            Text(text = stringResource(id = tip.verseTextRes))
        }

    }
}