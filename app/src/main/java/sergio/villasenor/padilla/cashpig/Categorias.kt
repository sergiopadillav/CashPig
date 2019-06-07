package sergio.villasenor.padilla.cashpig


import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.mikephil.charting.charts.Chart
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.components.LegendEntry
import com.github.mikephil.charting.data.DataSet
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import java.util.ArrayList


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class Categorias : Fragment() {


    private var pieChart: PieChart? = null
    private val categorias = arrayOf("Alimentacion", "Ocio", "Telefonia", "Gym", "Salud","Educacion","Hogar","Transporte","Ropa","Otros Gastos")
    private val ventas = intArrayOf(20, 25, 30, 40,15,30,15,10,30,18)
    private val colores = intArrayOf(Color.rgb(255,112,67), Color.rgb(255,202,40), Color.rgb(156,204,101), Color.rgb(66,165,245), Color.rgb(171,71,188),Color.rgb(239,83,80),Color.rgb(120,144,156),Color.rgb(102,187,106),Color.rgb(255,238,88),Color.rgb(189,189,189))

    private val pieEntries: ArrayList<PieEntry>
        get() {
            val entries = ArrayList<PieEntry>()
            for (i in ventas.indices)
                entries.add(PieEntry(ventas[i].toFloat()))
            return entries
        }

    private val pieData: PieData
        get() {
            val pieDataSet = getData(PieDataSet(pieEntries, "")) as PieDataSet
            pieDataSet.sliceSpace = 2f
            return PieData(pieDataSet)
        }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_categorias, container, false)
       /* val imageView = view.findViewById(R.id.my_image) as ImageView */
        pieChart = view.findViewById(R.id.graficaPastel) as PieChart?
        createCharts()
        return view

    }

    private fun getSameChart(
        chart: Chart<*>,
        descrpcion: String,
        textColor: Int,
        background: Int,
        animateY: Int
    ): Chart<*> {
        chart.description.text = descrpcion
        chart.description.textSize = 15f
        chart.setBackgroundColor(background)
        chart.animateY(animateY)

        return chart
    }

/*    private fun legend(chart: Chart<*>) {
        val legend = chart.legend
        legend.form = Legend.LegendForm.CIRCLE
        legend.horizontalAlignment = Legend.LegendHorizontalAlignment.CENTER

        val entries = ArrayList<LegendEntry>()
        for (i in categorias.indices) {
            val entry = LegendEntry()
            entry.formColor = colores[i]
            entry.label = categorias[i]
            entries.add(entry)
        }
        legend.setCustom(entries)
    }*/

    fun createCharts() {
        pieChart = getSameChart(pieChart!!, "", Color.GRAY, Color.rgb(255,255,255), 1000) as PieChart
        pieChart!!.holeRadius = 10f
        pieChart!!.transparentCircleRadius = 12f
        pieChart!!.isDrawHoleEnabled = true
        pieChart!!.data = pieData
        pieChart!!.invalidate()
    }

    private fun getData(dataSet: DataSet<*>): DataSet<*> {
        dataSet.setColors(*colores)
        dataSet.valueTextSize = 10f
        dataSet.valueTextColor = Color.WHITE
        return dataSet
    }


}
