package com.example.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import java.text.ParseException

class MainActivity : AppCompatActivity() {

    var peliculas: ArrayList<Pelicula>? = null
    var nombrePeliculas: ArrayList<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_fragmento)



    }


}
