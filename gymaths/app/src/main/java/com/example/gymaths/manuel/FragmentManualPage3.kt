package com.example.gymaths.manuel

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.gymaths.R
import com.example.gymaths.exercices.ActivityExercices
import com.example.gymaths.soutien.ActivitySoutien
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.InterstitialAd
import com.google.android.gms.ads.MobileAds

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FragmentManualPage3 : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        // Transforme le layout qui est en xml en objets Kotlins:
        return inflater.inflate(R.layout.manual_fragment_page3, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //Si l'application plante, on récupère ce qu'on peut
        // de l'état du fragment avant le crash:
        super.onViewCreated(view, savedInstanceState)


        /* ============================================================= */
        /* ======== Branchements des boutons du menu principal  ======== */
        /* ============================================================= */

        view.findViewById<Button>(R.id.btnToMainActivity).setOnClickListener {
            this.activity?.finish()
        }
    }
}