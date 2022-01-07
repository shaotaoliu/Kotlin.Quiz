package com.example.quiz

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.widget.AppCompatEditText

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()
        hideSystemUI()

        val btnStart = findViewById<Button>(R.id.btnStart)
        val txtName = findViewById<AppCompatEditText>(R.id.txtName)

        txtName.setText("Hello")

        btnStart.setOnClickListener {
            if (txtName.text.toString().isEmpty()) {
                Toast.makeText(this, "Please enter your name.", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, QuestionsActivity::class.java)
                intent.putExtra("username", txtName.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }
}