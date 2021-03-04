package com.example.gymaths.main

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.annotation.RequiresApi
import androidx.navigation.fragment.findNavController
import com.example.gymaths.R
import com.example.gymaths.exercices.ActivityExercices
import com.example.gymaths.soutien.ActivitySoutien

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class Fragment3 : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        // Transforme le layout qui est en xml en objets Kotlins:
        return inflater.inflate(R.layout.main_fragment3, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //Si l'application plante, on récupère ce qu'on peut
        // de l'état du fragment avant le crash:
        super.onViewCreated(view, savedInstanceState)


        /* ============================================================= */
        /* ======== Branchements des boutons du menu principal  ======== */
        /* ============================================================= */

        view.findViewById<Button>(R.id.btnRegleCalculs).setOnClickListener {
            findNavController().navigate(R.id.Fragment3To4)
        }

        view.findViewById<Button>(R.id.btnEqIneq).setOnClickListener {
            val intent = Intent(activity, ActivityExercices::class.java)
            startActivity(intent)
        }

        view.findViewById<Button>(R.id.btnIdRemarquables).setOnClickListener {
            val intent = Intent(activity, ActivitySoutien::class.java)
            startActivity(intent)
        }


        /* ============================================================= */
        /* ============== Branchement bouton de soutien  =============== */
        /* ============================================================= */

        view.findViewById<ImageButton>(R.id.btnSupport).setOnClickListener{
            val alertSupport = AlertDialog.Builder(this.context).create();
            alertSupport.setTitle("Soutenez l'équipe !");
            alertSupport.setMessage("Vous pouvez nous soutenir en regardant une publicité, ça vous tente ?");

            alertSupport.setButton(AlertDialog.BUTTON_POSITIVE, "Bien sûr",
                                   DialogInterface.OnClickListener {
                                       dialogInterface: DialogInterface, i: Int ->
                                       startActivity(Intent(activity, ActivitySoutien::class.java))
                                   })

            alertSupport.setButton(AlertDialog.BUTTON_NEGATIVE, "Non, merci",
                                   DialogInterface.OnClickListener {
                                       dialogInterface: DialogInterface, i: Int ->
                                       exitTransition
                                   })
            alertSupport.show()
            alertSupport.getButton(AlertDialog.BUTTON_POSITIVE).background.setTint(Color.TRANSPARENT)
            alertSupport.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(resources.getColor(R.color.gymathsBlue))
            alertSupport.getButton(AlertDialog.BUTTON_NEGATIVE).background.setTint(Color.TRANSPARENT)
            alertSupport.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(resources.getColor(R.color.gymathsBlue))
        }
    }
}