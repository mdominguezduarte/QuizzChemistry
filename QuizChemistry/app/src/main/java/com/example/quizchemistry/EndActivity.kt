package com.example.quizchemistry

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_end.*

class EndActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        val userName = intent.getStringExtra(Constants.USER_NAME)
        tv_name.text = userName

        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)
        val correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)

        tv_score.text = "Tu puntuación es $correctAnswers de $totalQuestions."

        btn_finish.setOnClickListener {
            startActivity(Intent(this@EndActivity, MainActivity::class.java))
        }
        // END

    }
}