package com.example.quiz

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.*
import androidx.core.content.ContextCompat
import androidx.core.view.marginTop
import org.w3c.dom.Text

class QuestionsActivity : BaseActivity() {

    val questions = Constants.getQuestions()
    var currentIndex = 0
    var correctAnswers = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        hideSystemUI()
        populateUI()

        val btnSubmit = findViewById<Button>(R.id.btnSubmit)
        if (questions.size ==  1) {
            btnSubmit.text = "Submit"
        }
        else {
            btnSubmit.text = "Next"
        }

        btnSubmit.setOnClickListener {
            if (isAnswerCorrect()) {
                ++correctAnswers
            }

            if (currentIndex == questions.size - 1) {
                val username = intent.getStringExtra("username")

                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("username", username)
                intent.putExtra("score", correctAnswers)
                intent.putExtra("total", questions.size)
                startActivity(intent)
                finish()
            }
            else {
                ++currentIndex
                populateUI()

                if (currentIndex == questions.size - 1) {
                    btnSubmit.text = "Submit"
                }
                else {
                    btnSubmit.text = "Next"
                }
            }
        }
    }

    private fun isAnswerCorrect() : Boolean {
        val question = questions[currentIndex]
        if (question.answers.size != seletedOptions.size) {
            return false
        }

        for (answer in question.answers) {
            if (!seletedOptions.contains(answer)) {
                return false
            }
        }

        return true
    }

    private var optionViews = mutableListOf<TextView>()
    private var seletedOptions = mutableSetOf<Int>()

    private fun populateUI() {
        val tvQuestion = findViewById<TextView>(R.id.tvQuestion)
        tvQuestion.text = questions[currentIndex].question

        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        progressBar.progress = currentIndex + 1

        val tvProcess = findViewById<TextView>(R.id.tvProgress)
        tvProcess.text = "${currentIndex + 1}/${questions.size}"

        val layout = findViewById<LinearLayout>(R.id.llOptions)
        layout.removeAllViews()

        optionViews.clear()
        seletedOptions.clear()

        var i = 0
        for (option in questions[currentIndex].options) {
            val tvOption = TextView(this)

            var params = RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
            )

            params.topMargin = 20
            params.bottomMargin = 20

            tvOption.layoutParams = params
            tvOption.gravity = Gravity.CENTER
            tvOption.textSize = 18F
            tvOption.text = option
            tvOption.typeface = Typeface.DEFAULT
            tvOption.setPadding(35, 35, 35, 35)
            tvOption.setTextColor(Color.parseColor("#7A8089"))
            tvOption.background = ContextCompat.getDrawable(this, R.drawable.option_background)

            val index = i
            tvOption.setOnClickListener {
                if (seletedOptions.contains(index)) {
                    seletedOptions.remove(index)

                    optionViews[index].setTextColor(Color.parseColor("#7A8089"))
                    optionViews[index].background = ContextCompat.getDrawable(this, R.drawable.option_background)
                }
                else {
                    seletedOptions.add(index)

                    optionViews[index].setTextColor(Color.parseColor("#FFFFFF"))
                    optionViews[index].background = ContextCompat.getDrawable(this, R.drawable.selected_option_background)
                }
            }

            layout.addView(tvOption)
            optionViews.add(tvOption)
            ++i
        }
    }
}