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
import com.example.gymaths.claviers.SimpleMathsKeyboard
import com.example.gymaths.claviers.AlphabeticKeyboard
import com.example.gymaths.R
import com.example.gymaths.equations.EquationGenerator
import com.example.gymaths.equations.Exp
import com.example.gymaths.equations.Number
import com.example.gymaths.equations.Parser
import com.example.gymaths.equations.Variable


class FragmentQuestion : Fragment()
{
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        // Transforme le layout qui est en xml en objets Kotlins:
        return inflater.inflate(R.layout.exercices_fragment_question, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /* ============================================================= */
        /* ============ Branchements claviers / fragment =============== */
        /* ============================================================= */

        // Clavier mathématique:
        val editText : EditText  = view.findViewById(R.id.editText)
        val keyboard : SimpleMathsKeyboard = view.findViewById(R.id.keyboard)

        // Clavier alphabétique:
        val keyboard_abc : AlphabeticKeyboard = view.findViewById(R.id.keyboard_abc)

        // Clavier mathématique:
        editText.setRawInputType(InputType.TYPE_CLASS_TEXT)
        editText.setTextIsSelectable(true)

        val ic : InputConnection  = editText.onCreateInputConnection(EditorInfo())
        keyboard.setInputConnection(ic, keyboard_abc)

        // Clavier alphabétique:
        val ic_abc : InputConnection  = editText.onCreateInputConnection(EditorInfo())
        keyboard_abc.setInputConnection(ic_abc, keyboard)


        /* ============================================================= */
        /* ========= Branchement problème généré / fragment ============ */
        /* ============================================================= */

        // Changement du champ problemView avec une fonction:
        val equation = EquationGenerator.LINEAR()
        val problem : String = "Résoudre l'équation : " + equation
        val problemField : TextView = view.findViewById(R.id.problemView)
        problemField.text = problem


        /* ============================================================= */
        /* ============= Branchement barre de progression ============== */
        /* ============================================================= */

        // On récupère la progress bar du fragment solution:
        var progressBarValue : Int? = this.arguments?.getInt("progressBarValue") //on reçoit le bundle de frag11
        val progressBar : ProgressBar = view.findViewById(R.id.progressBar)
        if (progressBarValue != null) {
            progressBar.progress = progressBarValue
        }
        progressBar.incrementProgressBy(1)

        // Passage écran solution + progress bar depuis le SimpleMathsKeyboard:
        // FIXME: Duplication de code avec AlphabeticKeyboard
        view.findViewById<Button>(R.id.button_validate).setOnClickListener {
            val envoie : Bundle = Bundle()
            val input : String = editText.text.toString()
            val progressBar : ProgressBar = view.findViewById(R.id.progressBar)
            val progressBarValue : Int = progressBar.progress
            var inputExp : Exp = Number(0f)
            var score : Int? = this.arguments?.getInt("score")

            try {
                inputExp = Parser.parse(input)
            } catch (e: NumberFormatException) {
                // TODO: Si le nombre saisit n'est pas correct, il ne faut pas passer au fragment suivant et redemander une autre entrée
                e.printStackTrace()
            }


            envoie.putString("generated", equation.fullSimplify().expRight.evaluate().toString())
            envoie.putString("input", inputExp.toString())
            envoie.putBoolean("isSolved", inputExp.evaluate() == equation.fullSimplify().expRight.evaluate())
            envoie.putInt("progressBarValue", progressBarValue)
            if (score != null) {
                envoie.putInt("score", score)
            }
            else {
                score = 0
                envoie.putInt("score", score)
            }

            findNavController().navigate(R.id.Fragment5To11, envoie)
        }

        // Passage écran solution + progress bar depuis le AlphabeticKeyboard:
        view.findViewById<Button>(R.id.button_validate_kbdABC).setOnClickListener {
            val envoie : Bundle = Bundle()
            val input : String = editText.text.toString()
            val progressBar : ProgressBar = view.findViewById(R.id.progressBar)
            val progressBarValue : Int = progressBar.progress
            var inputExp : Exp = Number(0f)

            try {
                inputExp = Parser.parse(input)
            } catch (e: NumberFormatException) {
                // TODO: Si le nombre saisi n'est pas correct, il ne faut pas passer au fragment suivant et redemander une autre entrée
                e.printStackTrace()
            }

            envoie.putString("generated", equation.fullSimplify().expRight.evaluate().toString())
            envoie.putString("input", inputExp.toString())
            envoie.putBoolean("isSolved", Exp.areEqual(inputExp, equation.fullSimplify().expRight))
            envoie.putInt("progressBarValue", progressBarValue)

            findNavController().navigate(R.id.Fragment5To11, envoie)
        }
    }
}