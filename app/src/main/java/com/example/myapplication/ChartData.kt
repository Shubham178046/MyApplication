package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.myapplication.Slider.Fragment.*

class ChartData : AppCompatActivity() {
    var chart_code : Int?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chart_data)
        val intent =  intent
        chart_code = intent.getIntExtra("chart",0)
        when(chart_code)
        {
            0 ->{
                var pieFragment = PieFragment()
                setFragment(pieFragment)

            }
            1 ->
            {
                var barFragment = BarFragment()
                setFragment(barFragment)
            }
            2 ->
            {
                var rangeFragment = RangeFragment()
                setFragment(rangeFragment)
            }
            3 ->
            {
                var lineFragment = LineFragment()
                setFragment(lineFragment)
            }
            4 ->
            {
                var comnbineFragment = ComnbineFragment()
                setFragment(comnbineFragment)
            }
        }
    }
    fun setFragment(fragment : Fragment)
    {
        supportFragmentManager.beginTransaction().replace(R.id.container,fragment).commit()
    }
}