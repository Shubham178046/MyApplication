package com.example.myapplication

import android.animation.ArgbEvaluator
import android.content.Context
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.myapplication.CardViewSliding.Companion.pager

class SlidingItemAdapter(var context: CardViewSliding,var fragmentManager: FragmentManager,val colors : Array<Int>) : FragmentPagerAdapter(fragmentManager), ViewPager.OnPageChangeListener {
    val BIG_SCALE: Float = 1.0f
    val SMALL_SCALE = 0.7f
    val DIFF_SCALE = BIG_SCALE - SMALL_SCALE
    var colors_temp : Array<Int>? = null

    private var scale = 0f
    var argbEvaluator: ArgbEvaluator = ArgbEvaluator()
    override fun getCount(): Int {
      return  7
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
        Log.d("Logged", "getItem: "+pos % CardViewSliding.PAGES)
        return Sliding.newInstance(context,pos,scale)
    }

    private fun getRootView(position: Int): SlidingLayout? {
        Log.d("Position", "getRootView: "+position)
        return fragmentManager.findFragmentByTag(getFragmentTag(position))!!.getView()!!.findViewById<View>(R.id.root_container) as SlidingLayout
    }

      private fun getFragmentTag(position: Int): String? {
        Log.d("Switcher", "getFragmentTag: "+ pager!!.getId().toString() + ":" + position)
        return "android:switcher:" + pager!!.getId().toString() + ":" + position

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
        colors_temp = colors
        if (position < 7 - 1 && position < colors_temp!!.size - 1) {
            pager!!.setBackgroundColor(
                argbEvaluator.evaluate(
                    positionOffset,
                    colors[position],
                    colors[position + 1]
                ) as Int
            )
        }
        else {
            pager!!.setBackgroundColor(colors_temp!![colors_temp!!.size - 1]);
        }
    }

    override fun onPageSelected(position: Int) {
    }
}