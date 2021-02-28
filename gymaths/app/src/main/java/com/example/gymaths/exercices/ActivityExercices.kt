package com.example.gymaths.exercices

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.gymaths.R

open class Button

class ActivityExercices : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.exercices_activity)

        setSupportActionBar(findViewById(R.id.toolbar))


        window.setFlags(
            WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM,
            WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_profile -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    /* fun updateAnswer(view: View)
    {
        var answerField = findViewById<TextView>(R.id.solutionView);
        var textInput = findViewById<EditText>(R.id.editText);
        var toSubmit = textInput.text.toString();
        answerField.text = toSubmit
        if (answerField.text.toString() == getString(R.string.exemple_reponse))
            answerField.text = getString(R.string.Bonjour)
        else
            answerField.text = getString(R.string.exemple_reponse)
    } */
}