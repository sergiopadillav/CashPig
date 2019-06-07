package sergio.villasenor.padilla.cashpig

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_principal.*

class Principal : AppCompatActivity() {

    val manager = supportFragmentManager

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                /* message.setText(R.string.title_home) */
                crearFragInicio()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                /* message.setText(R.string.title_dashboard) */
                crearFragCategorias()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                /* message.setText(R.string.title_notifications) */
                crearFragOfertas()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)

        crearFragInicio()

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    fun crearFragInicio(){
        val transaction = manager.beginTransaction()
        val fragment = Inicio()
        transaction.replace(R.id.frame_contenedor, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    fun crearFragCategorias(){
        val transaction = manager.beginTransaction()
        val fragment = Categorias()
        transaction.replace(R.id.frame_contenedor, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    fun crearFragOfertas(){
        val transaction = manager.beginTransaction()
        val fragment = Ofertas()
        transaction.replace(R.id.frame_contenedor, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}
