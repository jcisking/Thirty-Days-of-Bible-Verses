package com.example.thirtydaysofbibleverses

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.ColorFilter

@Composable
fun TipItem(tip: Tip, modifier: Modifier = Modifier) {
//    var expanded by remember { mutableStateOf(false)}
//    val color by animateColorAsState(animationSpec = spring(stiffness = Spring.StiffnessLow), targetValue = if (expanded) MaterialTheme.colors.secondary else MaterialTheme.colors.surface)

    Card(
        modifier = modifier
            .padding(16.dp)
            .clip(
                RoundedCornerShape(10.dp)
            ),
        elevation = 8.dp) {
        Column(
            modifier = Modifier
//                .background(color)
                .padding(top = 16.dp, bottom = 16.dp, start = 8.dp, end = 8.dp)
                .animateContentSize(
                    animationSpec = tween(
                        durationMillis = 300,
                        delayMillis = 50,
                        easing = FastOutLinearInEasing
                    )
                )
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
    val imageVisibility by remember { mutableStateOf(true) }
    val width = painterResource(id = tip.imageRes).intrinsicSize.width
    val height = painterResource(id = tip.imageRes).intrinsicSize.height
    Box(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)) {
        Image(
            modifier = modifier
                .clickable { }
                .padding(bottom = 23.dp)
                .size(if (width < 800 && height < 600) 300.dp else Dp(Float.NaN))
                .clip(RoundedCornerShape(5.dp)),
            painter = painterResource(id = tip.imageRes),
            contentScale = if (width < 800 && height < 600) ContentScale.FillBounds else ContentScale.Fit,
            contentDescription = null
        )
    }
}

@Composable
fun BibleVerseTopAppBar(modifier: Modifier = Modifier) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Image(
            modifier = Modifier.size(64.dp).padding(8.dp),
            painter = painterResource(id = R.drawable.holy_bible_svgrepo_com),
            contentDescription = null,
            colorFilter = ColorFilter.tint(MaterialTheme.colors.primary)
        )
        Text(

            text = stringResource(id = R.string.app_name),
            style = MaterialTheme.typography.h1
        )
    }

}

//@Composable
//fun TipItemButton(
//    expanded: Boolean,
//    onClick: () -> Unit,
//    modifier: Modifier = Modifier
//) {
//    IconButton(
//        onClick = onClick, modifier = modifier
//            .fillMaxWidth()
//            .background(MaterialTheme.colors.secondary)
//
//    ) {
//        Icon(
//            modifier = Modifier,
//            imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
//            contentDescription = null)
//    }
//}


