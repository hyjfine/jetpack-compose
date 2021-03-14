package com.example.mycompose

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

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
            painterResource(id = R.drawable.ic_launcher_foreground), contentDescription = ""
//            colorFilter = ColorFilter.tint(MaterialTheme.colors.primary)
        )
        Text("A day in Shark Fin Cove s")
        Text("Davenport, California a")
        Text("December 2018")
        Count()
    }
}

@Composable
fun Count() {
//    var count by remember { mutableStateOf(0) }
//    var expanded by remember { mutableStateOf(false) }
    val count = remember { mutableStateOf(0) }
//    var value by remember { mutableStateOf(1) }
    Button(onClick = { count.value ++ }) {
        Text(text = "Count ${count.value}")
    }
}

@Preview
@Composable
fun DefaultPreview3() {
    MaterialTheme {
    }
}