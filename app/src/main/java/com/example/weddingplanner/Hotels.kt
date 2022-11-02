package com.example.weddingplanner

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_hotels.*

class Hotels : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hotels)

        window.statusBarColor = ContextCompat.getColor(this, R.color.accent)

        btnBackHotels.setOnClickListener {
            val intent = Intent (this, MainActivity::class.java)
            this.startActivity(intent)
        }
    }
}