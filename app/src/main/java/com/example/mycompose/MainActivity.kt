package com.example.mycompose

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.Model
//import androidx.ui.core.Text
import androidx.ui.core.setContent
import androidx.ui.foundation.AdapterList
import androidx.ui.foundation.Text
import androidx.ui.foundation.VerticalScroller
import androidx.ui.graphics.Color
import androidx.ui.layout.Column
import androidx.ui.layout.LayoutPadding
import androidx.ui.material.*
import androidx.ui.text.TextStyle
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import androidx.ui.unit.sp

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
        Surface(color = Color.Yellow, modifier = LayoutPadding(24.dp)) {
            children()
        }
    }
}


val green = Color(0xFF1EB980)
private val themeColors = lightColorPalette(
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
    VerticalScroller() {
        Column {
            AdapterListView()
//            ListViews()
            Counter(state = counterState)
        }
    }
    Log.d(TAG, "------myScreenContent 111")
}

@Composable
fun AdapterListView() {
    AdapterList(
        data = (1..2000).toList()
    ) {
        Text("$it Even", style = TextStyle(fontSize = 28.sp, color = Color.Gray))
    }
}

@Composable
fun ListViews(itemSize: Int = 2000) {
    for (i in 0..itemSize) {
        Greeting(name = "name $i")
        if (i != itemSize) Divider(color = Color.Gray)
    }
}

@Composable
fun Counter(state: CounterState) {
    Button(
        onClick = { state.count++ },
        backgroundColor = if (state.count > 5) Color.Blue else Color.Green
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

@Model
class CounterState(var count: Int = 0)