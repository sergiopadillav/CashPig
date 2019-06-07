package sergio.villasenor.padilla.cashpig

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.activity_maps_ejemplo.*

class MapsEjemplo : AppCompatActivity() {

    @SuppressLint("MissingPermission")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps_ejemplo)

        btn_regresar.setOnClickListener {
            finish()
        }

        lateinit var mapFragment: SupportMapFragment
        lateinit var googleMap: GoogleMap


        mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync {

            googleMap = it
            googleMap.isMyLocationEnabled = true

            val location1 = LatLng(27.4909607,-109.9822399)
            val location2 = LatLng(27.4863755,-109.9626818)
            val location3 = LatLng(27.4821389,-109.9699456)
            val location4 = LatLng(27.4860139,-109.9854304)

            googleMap.addMarker(MarkerOptions().position(location1).title("Pechuga a $59"))
            googleMap.addMarker(MarkerOptions().position(location2).title("toda la verdura en oferta"))
            googleMap.addMarker(MarkerOptions().position(location3).title("Atunes 3x2"))
            googleMap.addMarker(MarkerOptions().position(location4).title("Prodcutor domesticas con -30%"))
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location1,10f))
        }
    }
}
