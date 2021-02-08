package com.example.gymaths.exercices

import android.os.Bundle
import android.service.autofill.OnClickAction
import android.view.*
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.gymaths.R
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

open class Button

class ActivityExercices : AppCompatActivity()
{


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.exercices_activity)
        //setSupportActionBar(findViewById(R.id.toolbar))

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun updateAnswer(view: View)
    {
        var answerField = findViewById<TextView>(R.id.solutionView);
        var textInput = findViewById<TextInputEditText>(R.id.textInputEditText);
        var toSubmit = textInput.text.toString();
        answerField.text = toSubmit
    }

}