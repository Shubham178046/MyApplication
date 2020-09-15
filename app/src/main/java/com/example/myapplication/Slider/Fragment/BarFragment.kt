package com.example.myapplication.Slider.Fragment

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.R
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate
import kotlinx.android.synthetic.main.fragment_bar.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BarFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BarFragment : Fragment() {
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
        return inflater.inflate(R.layout.fragment_bar, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var barChart : ArrayList<BarEntry> = ArrayList<BarEntry>()

        barChart.add(BarEntry(1998f,100f))
        barChart.add(BarEntry(1999f,80f))
        barChart.add(BarEntry(2000f,50f))
        barChart.add(BarEntry(2001f,10f))
        barChart.add(BarEntry(2002f,60f))
        barChart.add(BarEntry(2003f,200f))
        barChart.add(BarEntry(2004f,150f))
        barChart.add(BarEntry(2005f,75f))
        barChart.add(BarEntry(2006f,220f))
        barChart.add(BarEntry(2007f,75f))
        barChart.add(BarEntry(2008f,55f))
        barChart.add(BarEntry(2009f,45f))

        var barDataset : BarDataSet = BarDataSet(barChart,"bornData")
        barDataset.color = Color.BLUE
        barDataset.valueTextColor = Color.BLACK
        barDataset.valueTextSize = 18f

        var barData : BarData = BarData(barDataset)
        barCharts.setFitBars(true)
        barCharts.setScaleEnabled(false)
        barCharts.setTouchEnabled(false)
        barCharts.data = barData
        barCharts.setPinchZoom(false)
        barCharts.description.text = "Children Born Data By Years"
        //barCharts.animateY(2000)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BarFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BarFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}