package com.example.mycompose

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview

class ComposeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                GroupView()
            }
        }
    }
}

@Preview
@Composable
fun GroupView() {
    Column(modifier = Modifier.padding(16.dp)) {

        Image(
            asset = vectorResource(R.drawable.ic_launcher_foreground),
            colorFilter = ColorFilter.tint(MaterialTheme.colors.primary)
        )

        Text("A day in Shark Fin Cove s")
        Text("Davenport, California a")
        Text("December 2018")
    }
}

@Preview
@Composable
fun DefaultPreview3() {
    MaterialTheme {
    }
}