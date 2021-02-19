package com.example.quizchemistry

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //appbar is hidden
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        //
        btn_init.setOnClickListener{
            if(edit_name.text.toString().isEmpty()){
                Toast.makeText(this, "Por favor, añade un nombre de usuario.", Toast.LENGTH_SHORT).show()

            }else {
                val intent = Intent(this, QuestionChemistry::class.java)
                startActivity(intent)
                finish()
            }
        }
}
}