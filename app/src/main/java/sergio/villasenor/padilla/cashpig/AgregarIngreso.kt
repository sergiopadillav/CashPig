package sergio.villasenor.padilla.cashpig

import android.app.DatePickerDialog
import android.content.ContentValues
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Spinner
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_agregar_gasto.*
import kotlinx.android.synthetic.main.activity_agregar_ingreso.*
import kotlinx.android.synthetic.main.fragment_inicio.*
import sergio.villasenor.padilla.cashpig.Registrar.Companion.idEnlinea
import sergio.villasenor.padilla.cashpig.utilidades.Utilidades
import java.util.*

class AgregarIngreso : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_ingreso)


        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        btn_fecha_ingreso.setOnClickListener {
            val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener{ view, mYear, mMonth, mDay ->
                txt_fecha_ingreso.setText(""+mDay+"/"+(mMonth+1)+"/"+mYear)
            },year, month,day)
            dpd.show()
        }



        btn_continuar_ingreso.setOnClickListener {
            val conn = ConexionSQLiteHelper(this, "bd_usuarios", null, 1)
            val db = conn.writableDatabase

            val values = ContentValues()
            values.put(Utilidades.CAMPO_ID_USUARIO, idEnlinea)
            values.put(Utilidades.CAMPO_CANTIDAD, et_ingreso.text.toString())
            values.put(Utilidades.CAMPO_CATEGORIA,"Ingreso")
            values.put(Utilidades.CAMPO_TIPO, true)
            values.put(Utilidades.CAMPO_FECHA, txt_fecha_ingreso.text.toString())

            db.insert(Utilidades.TABLA_GASTO, null, values)
            Toast.makeText(applicationContext, "Registro Exitoso", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}
