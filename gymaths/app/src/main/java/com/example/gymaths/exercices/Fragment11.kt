package com.example.gymaths.exercices

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.gymaths.R

class Fragment11 : Fragment() {
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.exercices_fragment11, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var equa : String? = this.arguments?.getString("generated")
        var input : String? = this.arguments?.getString("input")
        var isSolved : Boolean? = this.arguments?.getBoolean("isSolved")

        var equaView : TextView = view.findViewById(R.id.textViewSolution)
        var userView : TextView = view.findViewById(R.id.textViewUtilisateur)

        equaView.text = "x = " + equa
        userView.text = input
        println(isSolved)


        view.findViewById<Button>(R.id.btnValidate).setOnClickListener {
            findNavController().navigate(R.id.Fragment11To5)
        }

    }
}