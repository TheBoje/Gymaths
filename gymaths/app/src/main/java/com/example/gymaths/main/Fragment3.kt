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
import com.example.gymaths.soutien.Activity_soutien

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class Fragment3 : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.main_fragment3, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.btnRegleCalculs).setOnClickListener {
            findNavController().navigate(R.id.Fragment3To4)
        }

        view.findViewById<Button>(R.id.btnEqIneq).setOnClickListener {
            findNavController().navigate(R.id.Fragment3To6)
        }

        view.findViewById<Button>(R.id.btnIdRemarquables).setOnClickListener {
            val intent = Intent(activity, Activity_soutien::class.java)
            startActivity(intent)
        }
    }
}