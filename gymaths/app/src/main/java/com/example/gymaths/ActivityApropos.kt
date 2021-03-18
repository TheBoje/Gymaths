package com.example.gymaths

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ActivityApropos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.apropos_fragment)
        setSupportActionBar(findViewById(R.id.toolbar))
    }
}