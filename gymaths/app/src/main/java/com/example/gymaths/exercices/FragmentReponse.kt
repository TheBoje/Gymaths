package com.example.gymaths.exercices

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.gymaths.R

class FragmentReponse : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        // Transforme le layout qui est en xml en objets Kotlins:
        return inflater.inflate(R.layout.exercices_fragment_reponse, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val envoie : Bundle = Bundle()

        /* ================================================================ */
        /* = Récupération et traitement des données du fragment Question  = */
        /* ================================================================ */

        // Récupération des données:
        var equa : String? = this.arguments?.getString("generated")
        var input : String? = this.arguments?.getString("input")
        var isSolved : Boolean? = this.arguments?.getBoolean("isSolved")
        var progressBarValue : Int? = this.arguments?.getInt("progressBarValue")
        var score : Int? = this.arguments?.getInt("score")

        // Mise à jour de la barre de progression:
        var progressBar : ProgressBar = view.findViewById(R.id.progressBar2)
        if (progressBarValue != null) {
            progressBar.progress = progressBarValue
            envoie.putInt("progressBarValue", progressBarValue)
        }

        // Affichage solution générée VS solution utilisateur:
        var equaView : TextView = view.findViewById(R.id.textViewSolution)
        var userView : TextView = view.findViewById(R.id.textViewUtilisateur)
        equaView.text = "x = " + equa
        userView.text = input
        println("Is the equation solved : $isSolved")

        if(isSolved!!)
        {
            userView.setBackgroundResource(R.drawable.back_valid)
            score = score?.inc()
        }

        else
        {
            equaView.append("\n\nTu feras mieux la prochaine fois!")
        }


        /* ================================================================ */
        /* =============== Branchement barre de progression =============== */
        /* ================================================================ */

        if (score != null) {
            envoie.putInt("score", score)
        }

        view.findViewById<Button>(R.id.btnValidate).setOnClickListener {
            if (progressBar.progress == progressBar.max)
                findNavController().navigate(R.id.Fragment11To8, envoie)
            else
                findNavController().navigate(R.id.Fragment11To5, envoie)
        }

    }
}