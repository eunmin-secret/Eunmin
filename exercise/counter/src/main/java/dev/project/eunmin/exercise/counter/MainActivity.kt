package dev.project.eunmin.exercise.counter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvCount = findViewById<TextView>(R.id.tv_count)
        val btnReset = findViewById<Button>(R.id.btn_reset)
        val btnPlus = findViewById<Button>(R.id.btn_plus)

        var number = 0

        tvCount.text = number.toString()

        btnReset.setOnClickListener {
            number = 0
            tvCount.text = number.toString()
        }

        btnPlus.setOnClickListener {
            number++
            tvCount.text = number.toString()
        }
    }
}