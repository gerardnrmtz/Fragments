package com.example.myapplication


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class ContenidoPeliculas : Fragment() {

    var vista: View? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        vista = inflater.inflate(R.layout.fragment_contenido_peliculas, container, false)
        // Inflate the layout for this fragment
        cambiarFoto()
        return vista!!
    }

    fun nuevaInstancia(index: Int): ContenidoPeliculas {
        val f = ContenidoPeliculas()
        val args = Bundle()

        args.putInt("INDEX", index)
        f.arguments = args
        return f
    }

    fun obtenerIndex(): Int {

        val index = arguments?.getInt("INDEX", 0)!!
        return index
    }

    fun cambiarFoto() {
        val foto = vista!!.findViewById<ImageView>(R.id.ivPhoto)
        foto.setImageResource(listaPeliculas.peliculas?.get(obtenerIndex())?.imagen!!)
    }


}
