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
        //setSupportActionBar(findViewById(R.id.toolbar))

        window.setFlags(
            WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM,
            WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM)
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