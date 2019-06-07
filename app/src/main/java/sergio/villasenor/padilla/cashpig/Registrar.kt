package sergio.villasenor.padilla.cashpig


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import sergio.villasenor.padilla.cashpig.utilidades.Utilidades
import android.content.ContentValues
import android.content.Intent
import kotlinx.android.synthetic.main.activity_registrar.*


class Registrar : AppCompatActivity() {

    lateinit var con:ConexionSQLiteHelper

    companion object{
        var idEnlinea: String = ""
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar)

         con = ConexionSQLiteHelper(applicationContext, "bd_usuarios", null, 1)

        btn_registrarse.setOnClickListener {

            if (et_contrasenia.text.toString() == et_confirmContra.text.toString()){

                if(et_nombre.text.toString().isEmpty() || et_email.text.toString())
                registrarUsuarios()
                val intent = Intent(this, Datos::class.java)
                startActivity(intent)
                finish()

            } else {
                Toast.makeText(applicationContext, "Las contraseñas no coinciden" , Toast.LENGTH_SHORT).show()
            }


        }

    }

    private  fun  registrarUsuarios(){
        var conn = ConexionSQLiteHelper(this, "bd_usuarios", null, 1)
        var db = conn.writableDatabase

        val values = ContentValues()
        values.put(Utilidades.CAMPO_NOMBRE, et_nombre.text.toString())
        values.put(Utilidades.CAMPO_CORREO, et_email.text.toString())
        values.put(Utilidades.CAMPO_CONTRASENIA, et_contrasenia.text.toString())
        values.put(Utilidades.CAMPO_CAPITAL,0.0)

        var idResultante = db.insert(Utilidades.TABLA_USUARIO, Utilidades.CAMPO_ID, values)
        idEnlinea = idResultante.toString()

        Toast.makeText(applicationContext, "Registro Exitoso con ID " + idResultante , Toast.LENGTH_SHORT).show()
    }
}
