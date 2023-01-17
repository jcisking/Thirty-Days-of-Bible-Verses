package com.example.thirtydaysofbibleverses

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.thirtydaysofbibleverses.data.Tip

@Composable
fun TipItem(tip: Tip, modifier: Modifier = Modifier) {
    Card(modifier = modifier.padding(16.dp), elevation = 8.dp) {
        Column(modifier = Modifier.padding(top = 16.dp, bottom = 16.dp, start = 8.dp, end = 8.dp).background(Color.Blue)) {
            TipHeader(tip)
            TipImage(tip = tip)
            BibleVerseAndText(tip)
        }
    }
}

@Composable
fun TipHeader(tip: Tip, modifier: Modifier = Modifier) {
    Text(modifier = modifier, text = stringResource(id = tip.dayRes))
}

@Composable
fun BibleVerseAndText(tip: Tip, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(text = stringResource(id = tip.verseRes))
        Text(text = stringResource(id = tip.verseTextRes))
    }
}

@Composable
fun TipImage(tip: Tip, modifier: Modifier = Modifier) {
    Image(
        modifier = modifier.background(Color.Green),
//                contentScale = ContentScale.FillBounds,
        painter = painterResource(id = tip.imageRes),
        contentDescription = null
    )
}


