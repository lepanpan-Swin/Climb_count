package com.example.climbcount

import android.os.Bundle
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

class MainActivity : AppCompatActivity() {
    private var points = 0
    private var clickCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.climb_activity) // Set your layout file

        val button1 = findViewById<Button>(R.id.button1)
        val button2 = findViewById<Button>(R.id.button2)
        val button3 = findViewById<Button>(R.id.button3)
        val numberDisplay = findViewById<TextView>(R.id.number_display)

        button1.setOnClickListener {
            points = maxOf(0, points - 3)
            numberDisplay.text = points.toString()
        }

        button2.setOnClickListener {
            if (clickCount < 9) {
                clickCount++
                points += when (clickCount) {
                    in 1..3 -> 1
                    in 4..6 -> 2
                    else -> 3
                }
                numberDisplay.text = points.toString()
            } else {
                resetPoints(numberDisplay)
            }
        }

        button3.setOnClickListener {
            resetPoints(numberDisplay)
        }
    }

    private fun resetPoints(numberDisplay: TextView) {
        points =0
        clickCount = 0
        numberDisplay.text = points.toString()
    }
}