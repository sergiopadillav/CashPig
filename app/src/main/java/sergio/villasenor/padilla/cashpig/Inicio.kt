package sergio.villasenor.padilla.cashpig


import android.app.DatePickerDialog
import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import kotlinx.android.synthetic.main.fragment_inicio.*
import kotlinx.android.synthetic.main.fragment_inicio.view.*
import sergio.villasenor.padilla.cashpig.entidades.Usuarios
import java.text.SimpleDateFormat
import java.util.*
import java.util.Calendar.*
import sergio.villasenor.padilla.cashpig.utilidades.Utilidades
import sergio.villasenor.padilla.cashpig.R.drawable.usuario
import java.nio.file.Files.size
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_datos.*
import kotlinx.android.synthetic.main.activity_login.*
import sergio.villasenor.padilla.cashpig.Datos.Companion.capitalTotal
import sergio.villasenor.padilla.cashpig.Registrar.Companion.idEnlinea

import java.text.DateFormat


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

@Suppress("UNREACHABLE_CODE")
/**
 * A simple [Fragment] subclass.
 *
 */
class Inicio : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater!!.inflate(R.layout.fragment_inicio, container, false)



//        val ObjetoIntent:Intent = Intent()
//        val nombre = ObjetoIntent.getStringExtra("capital")
//        capital.text = nombre

/*        val calendario = getInstance()
        val yy = calendario.get(YEAR)
        val mm = calendario.get(MONTH)
        val dd = calendario.get(DAY_OF_MONTH)


        consultarListaPersonas()
        val adaptador =  ArrayAdapter<String>(activity!!.applicationContext, android.R.layout.simple_list_item_1, listaInformacion)
        listViewPersonas.adapter = adaptador

        view.btn_fechames.setOnClickListener { view ->
            Log.d("btnSetup", "Selected")
            val datePicker = DatePickerDialog(activity!!,
                DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                    val fecha = (monthOfYear.toString()+ "/" + (dayOfMonth+1).toString())
                    btn_fechames.text = fecha
                }, yy, mm, dd)
            datePicker.show()
        }*/

        view.btn_agregar_gasto.setOnClickListener {
            val intentG = Intent (activity, AgregarGasto::class.java)
            activity!!.startActivity(intentG)
        }

        view.btn_agregar_ingreso.setOnClickListener {
            val intentI = Intent (activity, AgregarIngreso::class.java)
            activity!!.startActivity(intentI)
        }



            return view

        }

    fun consultarCapital(){
        var conn = ConexionSQLiteHelper(activity, "bd_usuarios", null, 1)
        var db = conn.readableDatabase

        val parametros = arrayOf(idEnlinea)
        val campos = arrayOf(Utilidades.CAMPO_CAPITAL)

        try{
            val cursor = db.query(Utilidades.TABLA_USUARIO, campos, Utilidades.CAMPO_ID + "=?", parametros, null, null, null)
            cursor.moveToFirst()
            capital.setText(cursor.getString(5))
            cursor.close()
        } catch (e: java.lang.Exception) {
            Toast.makeText(activity, "Los datos ingresados son incorrectos", Toast.LENGTH_SHORT).show()
        }


    }



}
