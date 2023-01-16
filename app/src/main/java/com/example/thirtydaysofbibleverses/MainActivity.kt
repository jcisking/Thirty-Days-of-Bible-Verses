package com.example.thirtydaysofbibleverses

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.thirtydaysofbibleverses.data.TipRepository
import com.example.thirtydaysofbibleverses.ui.theme.ThirtyDaysOfBibleVersesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ThirtyDaysOfBibleVersesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                }
            }
        }
    }
}

@Composable
fun BibleVerseApp() {
    LazyRow() {
        items(TipRepository.tips) {
            TipItem(tip = it)
        }
    }

}




@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ThirtyDaysOfBibleVersesTheme {

    }
}
