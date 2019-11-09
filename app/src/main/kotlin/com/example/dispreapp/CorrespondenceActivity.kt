package com.example.dispreapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_correspondence.*

/***************************
 画面名：発生後の対応
****************************/

class CorrespondenceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_correspondence)

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