package com.example.magica_colombia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [EdicionFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class EdicionFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Infla el diseño del fragmento
        val view = inflater.inflate(R.layout.fragment_edicion, container, false)

        // Accede a los elementos de la vista
        val editTextNombre: EditText = view.findViewById(R.id.editTextNombre)
        val editTextEdad: EditText = view.findViewById(R.id.editTextEdad)
        val editTextTelefono: EditText = view.findViewById(R.id.editTextTelefono)
        val editTextCorreo: EditText = view.findViewById(R.id.editTextCorreo)
        val btnGuardar: Button = view.findViewById(R.id.btnGuardar)

        // Lógica para obtener datos del perfil actual y mostrarlos en los EditText
        // Puedes obtener datos desde SharedPreferences, una base de datos, etc.

        // Lógica para guardar cambios cuando se hace clic en el botón
        btnGuardar.setOnClickListener {
            val nuevoNombre = editTextNombre.text.toString()
            val nuevaEdad = editTextEdad.text.toString()
            val nuevoTelefono = editTextTelefono.text.toString()
            val nuevoCorreo = editTextCorreo.text.toString()

            // Lógica para guardar los cambios en la base de datos o donde sea necesario
            // ...

            // Puedes mostrar un mensaje de éxito
            // Toast.makeText(context, "Cambios guardados", Toast.LENGTH_SHORT).show()
        }

        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }



    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment PerfilFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            EdicionFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

}