package com.example.climbcount

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.climbcount.ui.theme.ClimbCountTheme
import android.widget.Button
import android.widget.TextView
/*class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var text by remember { mutableStateOf("Hello World") }
            Column {
                Text(text)Button(onClick = { text = "Clicked!" }) {
                    Text("Click me")
                }
            }
        }
    }
}*/
class MainActivity : AppCompatActivity() {
    private var points = 0 //Set Variable for points
    private var clickCount = 0 //Set Variable for click count which is cap at 9

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.climb_activity) // Set the layout file

        val button1 = findViewById<Button>(R.id.button1) //Connect to the button in the layout
        val button2 = findViewById<Button>(R.id.button2)
        val button3 = findViewById<Button>(R.id.button3)
        val numberDisplay = findViewById<TextView>(R.id.number_display)//Connect to the textview in the layout

        button1.setOnClickListener { //Logic for fall button
            points = maxOf(0, points - 3) //Onclick -3 points
            numberDisplay.text = points.toString()
        }

        button2.setOnClickListener { //Logic for climb button
            if (clickCount < 9) { //Set max click to 9
                clickCount++
                points += when (clickCount) { //Score for each click with first 3 being 1, 4-6 being 2, 7-9 being 3
                    in 1..3 -> 1
                    in 4..6 -> 2
                    else -> 3
                }
                numberDisplay.text = points.toString() //Display points on screen
            } else {
                resetPoints(numberDisplay)//On max click reset points to 0
            }
        }

        button3.setOnClickListener { //Logic for reset button which reset the whole code to 0 points and click count
            resetPoints(numberDisplay)
        }
    }

    private fun resetPoints(numberDisplay: TextView) { //reset function to reset points and click count
        points =0
        clickCount = 0
        numberDisplay.text = points.toString()
    }
}