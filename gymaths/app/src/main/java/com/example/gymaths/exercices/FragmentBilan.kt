package com.example.gymaths.exercices

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.gymaths.R

class FragmentBilan : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        // Transforme le layout qui est en xml en objets Kotlins:
        return inflater.inflate(R.layout.exercices_fragment_bilan, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Récupération des données:
        var equa : String? = this.arguments?.getString("generated")
        var input : String? = this.arguments?.getString("input")
        var isSolved : Boolean? = this.arguments?.getBoolean("isSolved")
        var progressBarValue : Int? = this.arguments?.getInt("progressBarValue")
        var score : Int? = this.arguments?.getInt("score")

        var bilanView : TextView = view.findViewById(R.id.txtViewBilan)
        bilanView.setText("Votre score est de: "+score+"/"+progressBarValue)

        // On quitte l'activité exercices quand on clique sur valider dans ce le
        // fragment bilan:
        view.findViewById<Button>(R.id.btnValidate).setOnClickListener{
            this.activity?.finish()
        }
    }
}