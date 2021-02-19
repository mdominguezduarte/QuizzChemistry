package com.example.quizchemistry

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle



import android.graphics.Color
import android.graphics.Typeface

import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_question_chemistry.*




class QuestionChemistry : AppCompatActivity(), View.OnClickListener {


    private var mCurrentPosition: Int = 1 // Default and the first question position
    private var mQuestionsList: ArrayList<Question>? = null

    private var mSelectedOptionPosition: Int = 0
    private var mCorrectAnswers: Int = 0
    private var mUserName: String? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        //This call the parent constructor
        super.onCreate(savedInstanceState)
        // This is used to align the xml view to this class
        setContentView(R.layout.activity_question_chemistry)
        mUserName = intent.getStringExtra(Constants.USER_NAME)


        mQuestionsList = Constants.getQuestions()
        // END

        setQuestion()


        optOne.setOnClickListener(this)
        optTwo.setOnClickListener(this)
        optThree.setOnClickListener(this)
        optFour.setOnClickListener(this)
        // END
        btnSubmit.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

        when (v?.id) {

            R.id.optOne -> {

                selectedOptionView(optOne, 1)
            }

            R.id.optTwo -> {

                selectedOptionView(optTwo, 2)
            }

            R.id.optThree -> {

                selectedOptionView(optThree, 3)
            }

            R.id.optFour -> {

                selectedOptionView(optFour, 4)
            }
            R.id.btnSubmit -> {

                if (mSelectedOptionPosition == 0) {

                    mCurrentPosition++

                    when {

                        mCurrentPosition <= mQuestionsList!!.size -> {

                            setQuestion()
                            btnSubmit.text = "Validar"
                        }
                        else -> {

                            val intent =
                                Intent(this@QuestionChemistry, EndActivity::class.java)
                            intent.putExtra(Constants.USER_NAME, mUserName)
                            intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionsList!!.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                } else {
                    val question = mQuestionsList?.get(mCurrentPosition - 1)

                    // This is to check if the answer is wrong
                    if (question!!.correct != mSelectedOptionPosition) {
                        answerView(mSelectedOptionPosition, R.drawable.wrong_border)
                    } else {
                        mCorrectAnswers++
                    }

                    // This is for correct answer
                    answerView(question.correct, R.drawable.correct_border)

                    if (mCurrentPosition == mQuestionsList!!.size) {
                        btnSubmit.text = "Terminado!"
                    } else {
                        btnSubmit.text = "Continuar"
                    }

                    mSelectedOptionPosition = 0
                }
            }
        }
    }


    private fun setQuestion() {

        val question =
                mQuestionsList!!.get(mCurrentPosition - 1) // Getting the question from the list with the help of current position.

        defaultOptionsView()

        if(mCurrentPosition == mQuestionsList!!.size) {
            btnSubmit.text="Finalizar"
        } else {
            btnSubmit.text ="Validar"
        }

        progressBar.progress = mCurrentPosition
        progress.text = "$mCurrentPosition" + "/" + progressBar.getMax()

        thisQuestion.text = question.question
        idImagen.setImageResource(question.image)
        optOne.text = question.optOne
        optTwo.text = question.optTwo
        optThree.text = question.optThree
        optFour.text = question.optFour
    }
        private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {

            defaultOptionsView()

            mSelectedOptionPosition = selectedOptionNum

            tv.setTextColor(
                Color.parseColor("#363A43")
            )
            tv.setTypeface(tv.typeface, Typeface.BOLD)
            tv.background = ContextCompat.getDrawable(
                this@QuestionChemistry,
                R.drawable.selected_border
            )
        }



    private fun defaultOptionsView() {

        val options = ArrayList<TextView>()
        options.add(0, optOne)
        options.add(1, optTwo)
        options.add(2, optThree)
        options.add(3, optFour)

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                    this@QuestionChemistry,
                    R.drawable.selected_border
            )
        }
    }
    private fun answerView(answer: Int, drawableView: Int) {

        when (answer) {

            1 -> {
                optOne.background = ContextCompat.getDrawable(
                    this@QuestionChemistry,
                    drawableView
                )
            }
            2 -> {
                optTwo.background = ContextCompat.getDrawable(
                    this@QuestionChemistry,
                    drawableView
                )
            }
            3 -> {
                optThree.background = ContextCompat.getDrawable(
                    this@QuestionChemistry,
                    drawableView
                )
            }

            4 -> {
                optFour.background = ContextCompat.getDrawable(
                    this@QuestionChemistry,
                    drawableView
                )
            }
        }
    }
}