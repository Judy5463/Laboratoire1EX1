package com.example.laboratoire1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var rdoCercle: RadioButton
    private lateinit var rdoCylindre: RadioButton
    private lateinit var btnAir: Button
    private lateinit var btnVolume: Button
    private lateinit var txtresultat: TextView
    private lateinit var edRadius: EditText
    private lateinit var edHauteur: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        this.rdoCylindre = findViewById<RadioButton>(R.id.rdoCylindre)
        this.rdoCercle = findViewById<RadioButton>(R.id.rdoCercle)
        this.btnAir  = findViewById<Button>(R.id.btnAir)
        this.btnVolume  = findViewById<Button>(R.id.btnVolume)
        this.txtresultat = findViewById<TextView>(R.id.txtResultat)
        this.edRadius  = findViewById<EditText>(R.id.edRadius)
        this.edHauteur = findViewById<EditText>(R.id.edHauteur)

        this.rdoCylindre.isChecked = true

        this.rdoCercle.setOnClickListener(View.OnClickListener
        {
            this.btnVolume.isEnabled = false
            this.btnAir.isEnabled = true
            this.edHauteur.isEnabled = false
        })

        this.rdoCylindre.setOnClickListener(View.OnClickListener
        {
            this.btnVolume.isEnabled = true
            this.edHauteur.isEnabled = true
        })

        this.btnAir.setOnClickListener(View.OnClickListener
        {
            if(rdoCercle.isChecked == true) {
                var cercle = Circle()
                try {
                    if (edRadius.text.toString() != "") {
                        var radius = edRadius.text.toString().toDouble()
                        cercle = Circle(radius)
                    }
                } catch (e: Exception) {
                    txtresultat.text = "Une erreur c'est produite!"
                    return@OnClickListener
                }
                var air = cercle.getAera()
                var couleur = cercle.getColor()
                txtresultat.text = "L'aire du cercle " + couleur.toString() + " est " + air.toString()
            }
            else if (rdoCylindre.isChecked == true)
            {
                var cylindres = ValidationSaisieCylindre()
                var air = cylindres.getvolume()
                var couleur = cylindres.getColor()
                txtresultat.text = "L'air du cylindre " + couleur + " est " + air
                ValidationSaisieCylindre()
            }
        })

        this.btnVolume.setOnClickListener(View.OnClickListener
        {
            var cylindres = ValidationSaisieCylindre()
            var volume =  cylindres.getvolume()
            var couleur = cylindres.getColor()
            txtresultat.text = "Le volume du cylindre " + couleur + " est " + volume
            ValidationSaisieCylindre()
        })
    }

    fun ValidationSaisieCylindre(): Cylinder {
        var cylindres = Cylinder()
        try {
            if(edRadius.text.toString() == "" && edHauteur.text.toString() != ""){
                var hauteur = edHauteur.text.toString().toDouble()
                cylindres = Cylinder(1.0,hauteur)

            }
            else if(edRadius.text.toString() != "" && edHauteur.text.toString() == ""){
                var radius = edRadius.text.toString().toDouble()
                cylindres = Cylinder(radius,1.0)
            }
            else if(edRadius.text.toString() != "" && edHauteur.text.toString() != ""){
                var radius = edRadius.text.toString().toDouble()
                var hauteur = edHauteur.text.toString().toDouble()
                cylindres = Cylinder(radius,hauteur)
            }
        }
        catch (e: Exception){
            txtresultat.text = "Une erreur c'est produite!"
        }
        return cylindres
    }



}