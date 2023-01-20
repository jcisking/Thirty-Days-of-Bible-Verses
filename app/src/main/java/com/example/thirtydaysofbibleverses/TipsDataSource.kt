package com.example.thirtydaysofbibleverses

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.example.thirtydaysofbibleverses.data.Tip

@Composable
fun TipItem(tip: Tip, modifier: Modifier = Modifier) {
    Card(modifier = modifier.padding(16.dp), elevation = 8.dp) {
        Column(modifier = Modifier
            .padding(top = 16.dp, bottom = 16.dp, start = 8.dp, end = 8.dp)
            ) {
            TipHeader(tip)
            TipImage(tip = tip, modifier = Modifier.align(Alignment.CenterHorizontally))
            BibleVerseAndText(tip)
        }
    }
}

@Composable
fun TipHeader(tip: Tip, modifier: Modifier = Modifier) {
    Text(
        modifier = modifier
            .padding(bottom = 16.dp),
        text = stringResource(id = tip.dayRes),
        style = MaterialTheme.typography.h2
    )
}

@Composable
fun BibleVerseAndText(tip: Tip, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(id = tip.verseRes),
            style = MaterialTheme.typography.h3
        )
        Text(
            text = stringResource(id = tip.verseTextRes),
            style = MaterialTheme.typography.body1
        )
    }
}

@Composable
fun TipImage(tip: Tip, modifier: Modifier = Modifier) {
    val width = painterResource(id = tip.imageRes).intrinsicSize.width
    val height = painterResource(id = tip.imageRes).intrinsicSize.height
    Image(
        modifier = modifier
            .padding(bottom = 20.dp)
            .size(if (width < 800 && height < 600) 300.dp else Dp(Float.NaN))
            .clip(RoundedCornerShape(8.dp)),
        painter = painterResource(id = tip.imageRes),
        contentScale = if (width < 800 && height < 600) ContentScale.FillBounds else ContentScale.Fit,
        contentDescription = null
    )
}


