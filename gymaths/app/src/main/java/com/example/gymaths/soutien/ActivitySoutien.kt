package com.example.gymaths.soutien

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import com.example.gymaths.R


class ActivitySoutien : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.soutien_activity)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId)
        {
            R.id.action_profile -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}