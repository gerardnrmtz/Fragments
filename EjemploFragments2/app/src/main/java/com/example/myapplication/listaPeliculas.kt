package com.example.myapplication


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.FrameLayout
import android.widget.ListView
import android.widget.Toast


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class listaPeliculas : Fragment() {

    companion object {
        var peliculas: ArrayList<Pelicula>? = null
    }

    var nombrePeliculas: ArrayList<String>? = null
    var lista: ListView? = null
    var hay_doble_panel = false
    var posicion_actual = 0


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        configurarListView()
        val frame_detalles = activity!!.findViewById<FrameLayout>(R.id.detalles)

        hay_doble_panel = frame_detalles != null && frame_detalles.visibility == View.VISIBLE


        if (savedInstanceState != null) {

            posicion_actual = savedInstanceState.getInt("INDEX", 0)

        }
        if (hay_doble_panel) {

            lista?.choiceMode = ListView.CHOICE_MODE_SINGLE
            mostrardetalles(posicion_actual)
        }

    }

    fun configurarListView() {
        peliculas = ArrayList()
        peliculas?.add(Pelicula("Harry pother", R.drawable.titanic, "Magia"))
        peliculas?.add(Pelicula("Titanic", R.drawable.titanic, "Magia"))
        peliculas?.add(Pelicula("Pelicula", R.drawable.titanic, "Magia"))
        peliculas?.add(Pelicula("Pelicula 2", R.drawable.titanic, "Magia"))

        nombrePeliculas = obtenerNombrePeliculas(peliculas!!)
        val adaptador = ArrayAdapter(activity!!, android.R.layout.simple_list_item_activated_1, nombrePeliculas)

        lista = activity!!.findViewById(R.id.lista)
        lista?.adapter = adaptador


        lista?.setOnItemClickListener { parent, view, position, id ->
            mostrardetalles(position)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val vista = inflater.inflate(R.layout.fragment_lista_peliculas, container, false)
        // Inflate the layout for this fragment


        return vista
    }

    fun obtenerNombrePeliculas(peliculas: ArrayList<Pelicula>): ArrayList<String> {

        val nombres = ArrayList<String>()

        for (pelicula in peliculas) {
            nombres.add(pelicula.nombre)
        }
        return nombres

    }

    fun mostrardetalles(index: Int) {

        posicion_actual = index
        if (hay_doble_panel) {

            var fragmento_detalles =
                activity!!.supportFragmentManager.findFragmentById(R.id.detalles) as? ContenidoPeliculas
            if (fragmento_detalles == null || fragmento_detalles.obtenerIndex() != index) {

                fragmento_detalles = ContenidoPeliculas().nuevaInstancia(index)

                val fragmen_transaction = activity!!.supportFragmentManager.beginTransaction()

                fragmen_transaction.replace(R.id.detalles, fragmento_detalles)

                fragmen_transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)

                fragmen_transaction.commit()

            }


        } else {

            val intent = Intent(activity, Detalles::class.java)
            intent.putExtra("INDEX", index)
            startActivity(intent)
        }
    }


}
