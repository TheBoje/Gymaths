package com.example.gymaths.exercices

import android.inputmethodservice.Keyboard
import android.inputmethodservice.KeyboardView
import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputConnection
import android.widget.Button
import android.widget.EditText
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.gymaths.MyKeyboard
import com.example.gymaths.R
import com.google.android.material.textfield.TextInputEditText


class Fragment5 : Fragment()
{
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        return inflater.inflate(R.layout.exercices_fragment5, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val editText : EditText  = view.findViewById(R.id.editText)
        val keyboard : MyKeyboard  = view.findViewById(R.id.keyboard)
        editText.setRawInputType(InputType.TYPE_CLASS_TEXT)
        editText.setTextIsSelectable(true)

        val ic : InputConnection  = editText.onCreateInputConnection(EditorInfo())
        keyboard.setInputConnection(ic)

        /*view.findViewById<Button>(R.id.btnValidate).setOnClickListener {
            findNavController().navigate(R.id.Fragment5To8)
        }*/

        //Fait apparaître un bouton quand on clique dans le champ texte
        /*view.findViewById<TextInputEditText>(R.id.textInputEditText).setOnClickListener {
            view.findViewById<Button>(R.id.btnTest).visibility = View.VISIBLE
        }

        //Fait disparaître un bouton quand on clique quelque-part sur l'écran
        view.findViewById<ConstraintLayout>(R.id.exercicesFragment5Layout).setOnClickListener {
            view.findViewById<Button>(R.id.btnTest).visibility = View.GONE
        }*/
    }
}