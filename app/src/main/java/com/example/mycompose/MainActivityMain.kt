package com.example.mycompose

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.ui.core.Modifier
//import androidx.ui.core.Text
import androidx.ui.core.setContent
import androidx.ui.foundation.Text
import androidx.ui.foundation.contentColor
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.Button
import androidx.ui.material.MaterialTheme
import androidx.ui.text.TextStyle
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp

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