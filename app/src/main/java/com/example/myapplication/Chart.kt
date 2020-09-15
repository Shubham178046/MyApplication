package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_chart.*

class Chart : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chart)
        pie_chart.setOnClickListener {
            actionListner(0)
        }
        bar_chart.setOnClickListener {
            actionListner(1)
        }
        range_chart.setOnClickListener {
            actionListner(2)
        }
        line_Chart.setOnClickListener {
            actionListner(3)
        }
        combine_Chart.setOnClickListener {
            actionListner(4)
        }
    }

    fun actionListner(code : Int)
    {
        var intent = Intent(applicationContext,ChartData::class.java)
        intent.putExtra("chart",code)
        startActivity(intent)
    }
}