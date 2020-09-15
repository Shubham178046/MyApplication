package com.example.myapplication.Slider.Fragment

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.github.mikephil.charting.charts.CombinedChart.DrawOrder
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.formatter.ValueFormatter
import kotlinx.android.synthetic.main.fragment_comnbine.*
import kotlin.random.Random


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ComnbineFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ComnbineFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private val count = 12
    protected var mMonths = arrayOf(
        "Jan", "Feb", "Mar", "Apr", "May", "June"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_comnbine, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        combine_chart.getDescription().setText("This is testing Description");
        combine_chart.setDrawGridBackground(false);
        combine_chart.setDrawBarShadow(false);
        combine_chart.setBackgroundColor(Color.WHITE);
        combine_chart.setHighlightFullBarEnabled(false);
        combine_chart.setDrawOrder(
            arrayOf(
                DrawOrder.BAR, DrawOrder.LINE
            )
        )
        val l: Legend = combine_chart.getLegend()
        l.isWordWrapEnabled = true
        l.verticalAlignment = Legend.LegendVerticalAlignment.BOTTOM
        l.horizontalAlignment = Legend.LegendHorizontalAlignment.CENTER
        l.orientation = Legend.LegendOrientation.HORIZONTAL
        l.setDrawInside(false);

        val rightAxis: YAxis = combine_chart.getAxisRight()
        rightAxis.setDrawGridLines(false)
        rightAxis.axisMinimum = 0f // this replaces setStartAtZero(true)


        val leftAxis: YAxis = combine_chart.getAxisLeft()
        leftAxis.setDrawGridLines(false)
        leftAxis.axisMinimum = 0f // this replaces setStartAtZero(true)

        val xAxis: XAxis = combine_chart.getXAxis()
        xAxis.position = XAxis.XAxisPosition.BOTH_SIDED
        xAxis.axisMinimum = 0f
        xAxis.granularity = 1f
        xAxis.valueFormatter = object : ValueFormatter() {
            override fun getFormattedValue(value: Float): String {
                return mMonths.get(value.toInt() % mMonths.size)
            }
        }
        val data = CombinedData()

        data.setData(generateLineData())
        data.setData(generateBarData())


        xAxis.setAxisMaximum(data.getXMax() + 0.25f);
        combine_chart.setData(data);
        combine_chart.setScaleEnabled(false)
        combine_chart.setTouchEnabled(false)
        combine_chart.setPinchZoom(false)
        combine_chart.invalidate();
    }

    private fun generateLineData(): LineData? {
        val d = LineData()
        val entries: ArrayList<Entry> = ArrayList()
        for (index in 0 until count)
            entries.add(
                Entry(index + 0.5f, Random.nextInt(10,55).toFloat())
        )
        val set = LineDataSet(entries, "Line DataSet")
        set.color = Color.rgb(240, 238, 70)
        set.lineWidth = 2.5f
        set.setCircleColor(Color.rgb(240, 238, 70))
        set.circleRadius = 5f
        set.fillColor = Color.rgb(240, 238, 70)
        set.mode = LineDataSet.Mode.CUBIC_BEZIER
        set.setDrawValues(true)
        set.valueTextSize = 10f
        set.valueTextColor = Color.rgb(240, 238, 70)
        set.axisDependency = YAxis.AxisDependency.LEFT
        d.addDataSet(set)

        return d
    }

    private fun generateBarData(): BarData? {
        val entries1: ArrayList<BarEntry> = ArrayList()
        val entries2: ArrayList<BarEntry> = ArrayList()
        for (index in 0 until count) {
            entries1.add(BarEntry(0f,Random.nextInt(0,25).toFloat()))

            // stacked
            entries2.add(BarEntry(0f, floatArrayOf(Random.nextInt(0,12).toFloat(), Random.nextInt(0,12).toFloat())))
        }
        val set1 = BarDataSet(entries1, "Bar 1")
        set1.color = Color.rgb(60, 220, 78)
        set1.valueTextColor = Color.rgb(60, 220, 78)
        set1.valueTextSize = 10f
        set1.axisDependency = YAxis.AxisDependency.LEFT
        val set2 = BarDataSet(entries2, "")
        set2.stackLabels = arrayOf("Stack 1", "Stack 2")
        set2.setColors(
            Color.rgb(61, 165, 255),
            Color.rgb(23, 197, 255)
        )
        set2.valueTextColor = Color.rgb(61, 165, 255)
        set2.valueTextSize = 10f
        set2.axisDependency = YAxis.AxisDependency.LEFT
        val groupSpace = 0.06f
        val barSpace = 0.02f // x2 dataset
        val barWidth = 0.45f // x2 dataset
        // (0.45 + 0.02) * 2 + 0.06 = 1.00 -> interval per "group"
        val d = BarData(set1, set2)
        d.barWidth = barWidth

        // make this BarData object grouped
        d.groupBars(0f, groupSpace, barSpace) // start at x = 0
        return d
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ComnbineFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ComnbineFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}