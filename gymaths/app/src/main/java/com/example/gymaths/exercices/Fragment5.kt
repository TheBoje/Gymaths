package com.example.gymaths.exercices

import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputConnection
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import com.example.gymaths.MyKeyboard
import com.example.gymaths.MyKeyboard_abc
import com.example.gymaths.R
import com.example.gymaths.equations.EquationGenerator
import com.example.gymaths.equations.Exp
import com.example.gymaths.equations.Parser
import com.example.gymaths.equations.Variable


class Fragment5 : Fragment()
{
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {

        return inflater.inflate(R.layout.exercices_fragment5, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Clavier mathématique:
        val editText : EditText  = view.findViewById(R.id.editText)
        val keyboard : MyKeyboard  = view.findViewById(R.id.keyboard)

        //Clavier alphabétique:
        val keyboard_abc : MyKeyboard_abc = view.findViewById(R.id.keyboard_abc)


        //Clavier mathématique:
        editText.setRawInputType(InputType.TYPE_CLASS_TEXT)
        editText.setTextIsSelectable(true)

        val ic : InputConnection  = editText.onCreateInputConnection(EditorInfo())
        keyboard.setInputConnection(ic, keyboard_abc)

        //Clavier alphabétique:
        val ic_abc : InputConnection  = editText.onCreateInputConnection(EditorInfo())
        keyboard_abc.setInputConnection(ic_abc, keyboard)

        //On gére la progress bar
        var progressBarValue : Int? = this.arguments?.getInt("progressBarValue") //on reçoit le bundle de frag11
        val progressBar : ProgressBar = view.findViewById(R.id.progressBar)
        if (progressBarValue != null) {
            progressBar.progress = progressBarValue
        }
        progressBar.incrementProgressBy(1)




        //Changement du champ problemView avec une fonction
        val equation = EquationGenerator.LINEAR()
        val problem : String = "Résoudre l'équation : " + equation
        val problemField : TextView = view.findViewById(R.id.problemView)
        problemField.text = problem

        view.findViewById<Button>(R.id.button_validate).setOnClickListener {
            val envoie : Bundle = Bundle()
            val input : String = editText.text.toString()
            val progressBar : ProgressBar = view.findViewById(R.id.progressBar)
            val progressBarValue : Int = progressBar.progress

            val inputExp : Exp = Variable("x")//Parser.infixToExp(input)

            envoie.putString("generated", equation.fullSimplify().expRight.evaluate().toString())
            envoie.putString("input", input)
            envoie.putBoolean("isSolved", false) // Exp.areEqual(inputExp, equation))
            envoie.putInt("progressBarValue", progressBarValue)


            findNavController().navigate(R.id.Fragment5To11, envoie)
        }

        /*
        view.findViewById<Button>(R.id.button_plus).setOnClickListener {
            val progressBar : ProgressBar = view.findViewById(R.id.progressBar)

            progressBar.incrementProgressBy(1)

        }

         */

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