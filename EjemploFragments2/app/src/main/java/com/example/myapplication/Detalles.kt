package com.example.myapplication

import android.content.res.Configuration
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class Detalles : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalles)


        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            finish()
            return
        }
        if (savedInstanceState == null) {
            val fragmento_detalles = ContenidoPeliculas()
            fragmento_detalles.arguments = intent.extras
            supportFragmentManager.beginTransaction().add(R.id.conteiner, fragmento_detalles).commit()
        }
/*
*         val index = intent.getIntExtra("INDEX", 0)

        val photo = findViewById<ImageView>(R.id.ivPhoto)

        photo.setImageResource(listaPeliculas.peliculas?.get(index)?.imagen!!)*/

    }
}
