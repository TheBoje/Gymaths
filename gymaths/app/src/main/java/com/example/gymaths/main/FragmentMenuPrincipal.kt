package com.example.gymaths.main

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
class FragmentMenuPrincipal : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        // Transforme le layout qui est en xml en objets Kotlins:
        return inflater.inflate(R.layout.main_fragment_menu_principal, container, false)
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

            //On crée la publicité :
            MobileAds.initialize(this.activity, "ca-app-pub-3940256099942544~3347511713")
            val mInterstitialAd = InterstitialAd(this.requireActivity())
            mInterstitialAd.adUnitId = "ca-app-pub-3940256099942544/1033173712"
            mInterstitialAd.loadAd(AdRequest.Builder().build())

            //On crée le popup et son contenu:
            val alertSupport = AlertDialog.Builder(this.context).create()
            alertSupport.setTitle("Soutenez l'équipe !")
            alertSupport.setMessage("Vous pouvez nous soutenir en regardant une publicité, ça vous tente ?")

            //On associe les boutons du popup à leurs gestionnaires d'événements respectifs:
            alertSupport.setButton(AlertDialog.BUTTON_POSITIVE, "Bien sûr",
                                   DialogInterface.OnClickListener {
                                       _: DialogInterface, _: Int ->

                                       //On affiche la publicité
                                       if (mInterstitialAd.isLoaded) {
                                           mInterstitialAd.show()
                                       } else {
                                          System.err.println("Échec du chargement de l'objet publicité")
                                       }
                                   })

            alertSupport.setButton(AlertDialog.BUTTON_NEGATIVE, "Non, merci",
                                   DialogInterface.OnClickListener {
                                       _: DialogInterface, _: Int ->
                                       exitTransition
                                   })

            //On affiche le popup (ce qui crée ses boutons):
            alertSupport.show()

            //On modifie quelques aspects graphiques de boutons du popup:
            alertSupport.getButton(AlertDialog.BUTTON_POSITIVE).background.setTint(Color.TRANSPARENT)
            alertSupport.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(resources.getColor(R.color.gymathsBlue))
            alertSupport.getButton(AlertDialog.BUTTON_NEGATIVE).background.setTint(Color.TRANSPARENT)
            alertSupport.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(resources.getColor(R.color.gymathsBlue))
        }
    }
}