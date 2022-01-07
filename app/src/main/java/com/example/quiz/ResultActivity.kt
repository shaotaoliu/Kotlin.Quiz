package com.example.quiz

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar?.hide()
        hideSystemUI()

        val username = intent.getStringExtra("username")
        val score = intent.getIntExtra("score", 0)
        val total = intent.getIntExtra("total", 0)

        val tvName = findViewById<TextView>(R.id.tvName)
        val tvScore = findViewById<TextView>(R.id.tvScore)
        val btnFinish = findViewById<Button>(R.id.btnFinish)

        tvName.text = username
        tvScore.text = "Your score is $score of $total"

        btnFinish.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}