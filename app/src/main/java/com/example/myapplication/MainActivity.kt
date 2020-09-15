package com.example.myapplication

import android.os.Bundle
import android.util.DisplayMetrics
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.myapplication.Slider.CarouselPagerAdapter

class MainActivity : AppCompatActivity() {
    companion object
    val LOOPS = 1000
    var adapter: CarouselPagerAdapter? = null
    var pager: ViewPager? = null
    var count = 10 //ViewPager items size
    var FIRST_PAGE = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var colors  = arrayOf(resources.getColor(R.color.color1),resources.getColor(R.color.ironman),resources.getColor(R.color.spiderman),resources.getColor(R.color.thor),resources.getColor(R.color.captainamerica),resources.getColor(R.color.hulk),resources.getColor(R.color.color3))
        pager = findViewById(R.id.myviewpager) as ViewPager

        //set page margin between pages for viewpager

        //set page margin between pages for viewpager
        val metrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(metrics)
        val pageMargin = (metrics.widthPixels / 9 * 2.5 ).toInt()
        pager!!.pageMargin = -pageMargin
        adapter = CarouselPagerAdapter(this, supportFragmentManager)
        pager!!.setAdapter(adapter)
        adapter!!.notifyDataSetChanged()
   //pager!!.setPadding(100,0,100,0)
        pager!!.addOnPageChangeListener(adapter!!)

        pager!!.currentItem = FIRST_PAGE
        pager!!.offscreenPageLimit = 3
    }
}