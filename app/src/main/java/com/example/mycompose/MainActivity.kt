package com.example.mycompose

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.ui.tooling.preview.Preview


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyAppTheme { MyScreenContent() }
        }
    }

}

const val TAG = "MainActivity"

@Composable
fun MyApp(children: @Composable() () -> Unit) {
    MaterialTheme {
        Surface(color = Color.Yellow, modifier = Modifier.padding(24.dp)) {
            children()
        }
    }
}


val green = Color(0xFF1EB980)
private val themeColors = lightColors(
    primary = green,
    surface = Color.DarkGray,
    onSurface = green
)

@Composable
fun MyAppTheme(children: @Composable() () -> Unit) {
    MaterialTheme(colors = themeColors) {
        children()
    }
}

@Composable
fun MyScreenContent(counterState: CounterState = CounterState()) {
    Log.d(TAG, "------myScreenContent 000")
    AdapterListView()
    Log.d(TAG, "------myScreenContent 111")
}

@Composable
fun AdapterListView() {
    println("----000")
    val data = (1..2000).toList()
    println("----111")
    Column {
        Text(text = "Head", style = MaterialTheme.typography.h5)
        Divider()
        LazyColumnFor(items = data) {
            Text("$it Even", style = TextStyle(fontSize = 28.sp, color = Color.Gray))
        }
    }
}

@Composable
fun ListViews(itemSize: Int = 2000) {
    ScrollableColumn {
        Column {
            for (i in 0..itemSize) {
                Greeting(name = "name $i")
                if (i != itemSize) Divider(color = Color.Gray)
            }
            Counter(state = CounterState())
        }
    }
}

@Composable
fun Counter(state: CounterState) {
    Button(
        onClick = { state.count++ },
//        colors = if (state.count > 5) Color.Blue else Color.Green
    ) {
        Text("I've been clicked ${state.count} times")
    }
}

@Composable
fun Greeting(name: String) {
    Text(
        text = "Hello $name!",
        style = TextStyle(fontSize = 28.sp, color = Color.Gray)
    )
}

@Preview("Default")
@Composable
fun DefaultPreview() {
    MyApp { Greeting(name = "Composable") }
}

//@Model
class CounterState(var count: Int = 0)