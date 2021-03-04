package com.example.gymaths.exercices

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.gymaths.R

class Fragment11 : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        // Transforme le layout qui est en xml en objets Kotlins:
        return inflater.inflate(R.layout.exercices_fragment11, container, false)
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
        println(isSolved)


        /* ================================================================ */
        /* =============== Branchement barre de progression =============== */
        /* ================================================================ */

        view.findViewById<Button>(R.id.btnValidate).setOnClickListener {
            if (progressBar.progress == progressBar.max)
                findNavController().navigate(R.id.Fragment11To8, envoie)
            else
                findNavController().navigate(R.id.Fragment11To5, envoie)
        }

    }
}