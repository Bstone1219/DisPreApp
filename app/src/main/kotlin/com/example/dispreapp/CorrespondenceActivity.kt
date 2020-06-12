package com.example.dispreapp

import android.content.Intent
import android.graphics.Paint
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_correct_action.*
import kotlinx.android.synthetic.main.activity_correspondence.*
import kotlinx.android.synthetic.main.activity_correspondence.backButton

/***************************
 画面名：発生後の対応
****************************/

class CorrespondenceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_correspondence)

        val toTop = findViewById<TextView>(R.id.toTop)

        toTop.paintFlags = Paint.UNDERLINE_TEXT_FLAG
        toTop.movementMethod = LinkMovementMethod.getInstance()
        toTop.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        backButton.setOnClickListener {
            finish()
        }

        toCorrectAction.setOnClickListener {
            val intent = Intent(this, CorrectActionActivity::class.java)
            startActivity(intent)
        }

        toIncorrectAction.setOnClickListener {
            val intent = Intent(this, IncorrectActionActivity::class.java)
            startActivity(intent)
        }
    }
}