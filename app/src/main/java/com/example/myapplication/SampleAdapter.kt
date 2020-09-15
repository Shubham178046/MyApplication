package com.example.myapplication

import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager

class SampleAdapter(var context: CardViewSliding, var fragmentManager: FragmentManager, val colors : Array<Int>) : FragmentPagerAdapter(fragmentManager), ViewPager.OnPageChangeListener{
    val BIG_SCALE: Float = 1.0f
    val SMALL_SCALE = 0.7f
    val DIFF_SCALE = BIG_SCALE - SMALL_SCALE
    private var scale = 0f

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }
    override fun getItem(position: Int): Fragment {
        var pos = position
        if (pos == 0)
        {
            scale = BIG_SCALE;
        }
        else
        {
            scale = SMALL_SCALE;
        }

        pos = pos % CardViewSliding.PAGES;
        return Sliding.newInstance(context,pos,scale)
    }
    private fun getRootView(position: Int): SlidingLayout? {
        Log.d("Position", "getRootView: "+position)
        return fragmentManager.findFragmentByTag(getFragmentTag(position))!!.getView()!!.findViewById<View>(R.id.root_container) as SlidingLayout
    }
    private fun getFragmentTag(position: Int): String? {
        Log.d("Switcher", "getFragmentTag: "+ CardViewSliding.pager!!.getId().toString() + ":" + position)
        return "android:switcher:" + CardViewSliding.pager!!.getId().toString() + ":" + position

    }
    override fun getCount(): Int {
       return 7
    }

    override fun onPageScrollStateChanged(state: Int) {

    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
        try {
            if (positionOffset >= 0f && positionOffset <= 1f) {
                val cur: SlidingLayout? = getRootView(position)
                val next: SlidingLayout? = getRootView(position + 1)
                cur!!.setScaleBoth(BIG_SCALE - DIFF_SCALE * positionOffset)
                next!!.setScaleBoth(SMALL_SCALE + DIFF_SCALE * positionOffset)
                Log.d("Position", "onPageScrolled: "+cur+next)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun onPageSelected(position: Int) {

    }

}