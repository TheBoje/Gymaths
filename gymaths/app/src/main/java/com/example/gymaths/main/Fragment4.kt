package com.example.gymaths.main

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.gymaths.R
import com.example.gymaths.exercices.ActivityExercices

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class Fragment4 : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.main_fragment4, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.btnNext).setOnClickListener {
            findNavController().navigate(R.id.Fragment4To3)
        }

        view.findViewById<Button>(R.id.btnSqrt).setOnClickListener {
            val intent = Intent(activity, ActivityExercices::class.java)
            startActivity(intent)
        }
    }
}