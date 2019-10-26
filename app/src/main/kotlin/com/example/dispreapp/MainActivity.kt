package com.example.dispreapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toPreparation.setOnClickListener {
            val intent = Intent(this, PreparationActivity::class.java)
            startActivity(intent)
        }

        toCorresponding.setOnClickListener {
            val intent = Intent(this, CorrespondenceActivity::class.java)
            startActivity(intent)
        }
    }
}
