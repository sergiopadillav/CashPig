package sergio.villasenor.padilla.cashpig

import android.content.Intent
import android.database.Cursor
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.AutoCompleteTextView
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import sergio.villasenor.padilla.cashpig.utilidades.Utilidades
import sergio.villasenor.padilla.cashpig.utilidades.Utilidades.CAMPO_CORREO
import sergio.villasenor.padilla.cashpig.R.id.userEmail
import java.lang.reflect.Executable


@Suppress("UNUSED_EXPRESSION")
class Login : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btn_entrar.setOnClickListener {
            consultar()
        }

        btn_registrar.setOnClickListener {
            val intent = Intent(this,Registrar::class.java)
            startActivity(intent)
        }
    }


    fun consultar(){
        var conn = ConexionSQLiteHelper(this, "bd_usuarios", null, 1)
        var db = conn.readableDatabase

        val parametros = arrayOf(userEmail.text.toString())
        val campos = arrayOf(Utilidades.CAMPO_CORREO, Utilidades.CAMPO_CONTRASENIA)

        try{
            val cursor = db.query(Utilidades.TABLA_USUARIO, campos, Utilidades.CAMPO_CORREO + "=?", parametros, null, null, null)
            cursor.moveToFirst()

//            var capital: String = cursor.getString(4)
            cursor.close()
            val intent = Intent(this, Principal::class.java)
//            intent.putExtra("capital",capital)
            startActivity(intent)
        } catch (e: java.lang.Exception) {
            Toast.makeText(applicationContext, "Los datos ingresados son incorrectos", Toast.LENGTH_SHORT).show()
        }

    }


}
