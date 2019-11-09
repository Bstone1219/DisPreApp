package com.example.dispreapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_preparation.*

class PreparationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preparation)

        toItemAction.setOnClickListener {
            val intent = Intent(this, ItemActivity::class.java)
            startActivity(intent)
        }

        toMeasuresAction.setOnClickListener {
            val intent = Intent(this, MeasuresActivity::class.java)
            startActivity(intent)
        }
    }
}
