package com.example.mycompose

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.preferredHeight
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview


class MainActivityMain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Column {

                    Greeting2("Android")
                    Button(onClick = {
                        startActivity(Intent(this@MainActivityMain, ComposeActivity::class.java))
                    }) {
                        Text(text = "go compose")
                    }

                    Spacer(modifier = Modifier.preferredHeight(12.dp))
//                    Row(modifier = LayoutHeight(12.dp)) {
//                    }

                    Button(onClick = {
                        startActivity(Intent(this@MainActivityMain, MainActivity::class.java))
                    }) {
                        Text(text = "go compose adapter")
                    }

                    Spacer(modifier = Modifier.preferredHeight(12.dp))


                    Button(onClick = {
                        startActivity(Intent(this@MainActivityMain, MainActivity2::class.java))
                    }) {
                        Text(text = "go recycler")
                    }

                    Greeting2(name = "android o")


                }
            }
        }
    }
}

@Composable
fun Greeting2(name: String) {
    Text(text = "Hello $name!", style = MaterialTheme.typography.subtitle2.copy(color = Color.Red))
}

@Preview
@Composable
fun DefaultPreview2() {
    MaterialTheme {
        Greeting2("Android")
    }
}