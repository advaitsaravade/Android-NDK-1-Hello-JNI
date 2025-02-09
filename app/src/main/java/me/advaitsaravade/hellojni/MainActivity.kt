package me.advaitsaravade.hellojni

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    companion object {
        // Load native library
        init {
            System.loadLibrary("native-lib")
        }
    }

    external fun stringFromJNI(): String
    external fun returnStringFromJNI(inputStr: String): String
    external fun additionFromJNI(first: Int, second: Int): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Set text from native function
        // Ensure your textView has an ID called `textView1` in activity_main.xml
        findViewById<TextView>(R.id.textView1).apply {
            text = stringFromJNI()
        }
        findViewById<TextView>(R.id.textView2).apply {
            text = returnStringFromJNI("GENERAL KOTLIN!")
        }
        findViewById<TextView>(R.id.textView3).apply {
            val first = 2
            val second = 2
            text = "Simple addition: $first + $second = ${additionFromJNI(2, 2)}"
        }
    }
}