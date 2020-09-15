package com.example.myapplication.Slider.Fragment

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.R
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import kotlinx.android.synthetic.main.fragment_range.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RangeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RangeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

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
        return inflater.inflate(R.layout.fragment_range, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var radarChart : ArrayList<RadarEntry> = ArrayList<RadarEntry>()

        radarChart.add(RadarEntry(100f))
        radarChart.add(RadarEntry(80f))
        radarChart.add(RadarEntry(100f))
        radarChart.add(RadarEntry(80f))
        radarChart.add(RadarEntry(100f))
        radarChart.add(RadarEntry(80f))
        radarChart.add(RadarEntry(100f))
        radarChart.add(RadarEntry(80f))
        radarChart.add(RadarEntry(100f))
        radarChart.add(RadarEntry(80f))
        radarChart.add(RadarEntry(100f))
        radarChart.add(RadarEntry(80f))

        var radarDataSet : RadarDataSet = RadarDataSet(radarChart,"bornData")
        radarDataSet.color = Color.RED
        radarDataSet.lineWidth = 2f
        radarDataSet.valueTextColor = Color.RED
        radarDataSet.valueTextSize = 18f

        var radarData : RadarData = RadarData()
        radarData.addDataSet(radarDataSet)

        var labels : Array<String> = arrayOf("1998f",
            "1999f",
            "2000f",
            "2001f",
            "2002f",
            "2003f",
            "2004f",
            "2005f",
            "2006f",
            "2007f",
            "2008f",
            "2009f")

        var xAxis = radarCharts.xAxis
        xAxis.valueFormatter = IndexAxisValueFormatter(labels)
        radarCharts.description.text = "Born Status By Years"
        radarCharts.data = radarData
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment RangeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RangeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}