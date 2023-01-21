package com.example.thirtydaysofbibleverses

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
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
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.*

@Composable
fun TipItem(tip: Tip, modifier: Modifier = Modifier) {
    var expanded by remember { mutableStateOf(false) }
    val color by animateColorAsState(if (expanded) MaterialTheme.colors.secondary else MaterialTheme.colors.surface)

    Card(
        modifier = modifier
            .padding(16.dp)
            .clip(RoundedCornerShape(10.dp)
            ),
        elevation = 8.dp) {
        Column(
            modifier = Modifier
                .background(color)
                .padding(top = 16.dp, bottom = 16.dp, start = 8.dp, end = 8.dp)
                .animateContentSize(animationSpec = tween(
                    durationMillis = 500,
                    delayMillis = 50,
                    easing = FastOutLinearInEasing
                ))
            ) {
            TipHeader(tip)
            TipImage(tip = tip, modifier = Modifier.align(Alignment.CenterHorizontally))
            if (expanded) {
                BibleVerseAndText(tip)
            }
            TipItemButton(expanded = expanded , onClick = { expanded = !expanded })
        }
    }
}

@Composable
fun TipHeader(tip: Tip, modifier: Modifier = Modifier) {
    Text(
        modifier = modifier
            .padding(bottom = 25.dp),
        text = stringResource(id = tip.dayRes),
        style = MaterialTheme.typography.h2
    )
}

@Composable
fun BibleVerseAndText(tip: Tip, modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(start = 8.dp, end = 8.dp)) {
        Text(
            text = stringResource(id = tip.verseRes),
            style = MaterialTheme.typography.h3,
            modifier = Modifier.padding(bottom = 5.dp)
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
            .padding(bottom = 23.dp)
            .size(if (width < 800 && height < 600) 300.dp else Dp(Float.NaN))
            .clip(RoundedCornerShape(5.dp)),
        painter = painterResource(id = tip.imageRes),
        contentScale = if (width < 800 && height < 600) ContentScale.FillBounds else ContentScale.Fit,
        contentDescription = null
    )
}

@Composable 
fun TipItemButton(
    expanded: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(
        onClick = onClick, modifier = modifier
            .fillMaxWidth()
//            .background(MaterialTheme.colors.secondary)

    ) {
        Icon(
            modifier = Modifier,
            imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
            contentDescription = null)
    }
}


