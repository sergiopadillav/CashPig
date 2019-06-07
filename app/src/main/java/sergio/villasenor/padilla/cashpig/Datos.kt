package sergio.villasenor.padilla.cashpig

import android.content.ContentValues
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import kotlinx.android.synthetic.main.activity_datos.*
import sergio.villasenor.padilla.cashpig.Registrar.Companion.idEnlinea
import sergio.villasenor.padilla.cashpig.utilidades.Utilidades
import android.provider.SyncStateContract.Helpers.update
import sergio.villasenor.padilla.cashpig.R.id.capital
import sergio.villasenor.padilla.cashpig.R.id.et_total


class Datos : AppCompatActivity() {

    companion object{
        var capitalTotal: String = ""
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_datos)

        var capitalTotal = et_total.text.toString()




        btn_continuar.setOnClickListener {
            actualizarUsuario()
            val intent = Intent(this, Principal::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun actualizarUsuario() {
        var conn = ConexionSQLiteHelper(this, "bd_usuarios", null, 1)
        var db = conn.writableDatabase

        val parametros = arrayOf(idEnlinea)

        val values = ContentValues()
        values.put(Utilidades.CAMPO_CAPITAL, et_total.text.toString())
        var capitalResultante = db.update(Utilidades.TABLA_USUARIO, values, Utilidades.CAMPO_ID + "=?", parametros)
        capitalTotal = capitalResultante.toString()
        db.close()

    }
}
