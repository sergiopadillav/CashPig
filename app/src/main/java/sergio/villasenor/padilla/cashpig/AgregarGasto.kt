package sergio.villasenor.padilla.cashpig

import android.app.DatePickerDialog
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_agregar_gasto.*
import kotlinx.android.synthetic.main.fragment_inicio.*
import java.util.*
import android.widget.Spinner
import android.widget.ArrayAdapter
import android.R.layout.simple_spinner_item
import android.annotation.SuppressLint
import android.content.ContentValues
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_registrar.*
import sergio.villasenor.padilla.cashpig.utilidades.Utilidades
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_datos.*
import kotlinx.android.synthetic.main.activity_login.view.*
import sergio.villasenor.padilla.cashpig.Registrar.Companion.idEnlinea


class AgregarGasto : AppCompatActivity() {


    var items: Array<String>? = null

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_gasto)

        var sp = findViewById(R.id.spinner_categoria_gasto) as Spinner
        items = resources.getStringArray(R.array.categorias)
        val adapter = ArrayAdapter<String>(baseContext, android.R.layout.simple_spinner_item,items)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
        sp.adapter = adapter





        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        btn_fecha_gasto.setOnClickListener {
            val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener{ view, mYear, mMonth, mDay ->
                txt_fecha_gasto.setText(""+mDay+"/"+(mMonth+1)+"/"+mYear)
            },year, month,day)
            dpd.show()
        }



        btn_continuar_gasto.setOnClickListener {



                val conn = ConexionSQLiteHelper(this, "bd_usuarios", null, 1)
                val db = conn.writableDatabase

            val cur = findViewById(R.id.spinner_categoria_gasto) as Spinner
            val text = cur.selectedItem.toString()

                val values = ContentValues()
                values.put(Utilidades.CAMPO_ID_USUARIO, idEnlinea)
                values.put(Utilidades.CAMPO_CANTIDAD, et_cantidad_gastada.text.toString())
                values.put(Utilidades.CAMPO_CATEGORIA, text)
                values.put(Utilidades.CAMPO_TIPO, false)
                values.put(Utilidades.CAMPO_FECHA, txt_fecha_gasto.text.toString())

                db.insert(Utilidades.TABLA_GASTO, null, values)

                Toast.makeText(applicationContext, "Registro Exitoso", Toast.LENGTH_SHORT).show()
                finish()
        }
    }

    private fun actualizarCapitaldb() {
        var conn = ConexionSQLiteHelper(this, "bd_usuarios", null, 1)
        var db = conn.writableDatabase

        val parametros = arrayOf(idEnlinea)

        val numero = Integer.parseInt(et_cantidad_gastada.toString())


        val values = ContentValues()
        values.put(Utilidades.CAMPO_CAPITAL, et_total.text.toString())
        var capitalResultante = db.update(Utilidades.TABLA_USUARIO, values, Utilidades.CAMPO_ID + "=?", parametros)
        Datos.capitalTotal = capitalResultante.toString()
        db.close()
    }
}

