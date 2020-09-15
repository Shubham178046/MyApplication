package com.example.myapplication.Slider.Fragment

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.R
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.utils.ColorTemplate
import com.github.mikephil.charting.utils.ColorTemplate.MATERIAL_COLORS
import kotlinx.android.synthetic.main.fragment_pie.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PieFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PieFragment : Fragment() {
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
        return inflater.inflate(R.layout.fragment_pie, container, false)
    }

    @SuppressLint("ResourceType")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var pieChart : ArrayList<PieEntry> = ArrayList<PieEntry>()
        pieChart.add(PieEntry(420f,"2014"))
        pieChart.add(PieEntry(220f,"2013"))
        pieChart.add(PieEntry(120f,"2012"))
        pieChart.add(PieEntry(120f,"2011"))
        pieChart.add(PieEntry(120f,"2010"))
        pieChart.add(PieEntry(120f,"2009"))
        pieChart.add(PieEntry(120f,"2008"))
        pieChart.add(PieEntry(120f,"2007"))
        pieChart.add(PieEntry(120f,"2006"))
        pieChart.add(PieEntry(120f,"2005"))

        var barDataSet : PieDataSet = PieDataSet(pieChart,"student")
        //var colorList : List<Int> = context.resources.getIntArray(R.array.graphColor)
         barDataSet.color = resources.getColor(R.color.captainamerica)

        barDataSet.valueTextColor = Color.BLACK
        barDataSet.valueTextSize = 18f

        var barData : PieData = PieData(barDataSet)
        piecharts.data = barData
        piecharts.description.isEnabled = true
        piecharts.centerText = "Student Admission Data"
        piecharts.setTouchEnabled(false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment PieFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PieFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}