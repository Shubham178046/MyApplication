package com.example.myapplication.Slider

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.myapplication.MainActivity
import com.example.myapplication.Slider.ItemFragment
import com.example.myapplication.R

class CarouselPagerAdapter(context: MainActivity, fm: FragmentManager) : FragmentPagerAdapter(fm) ,
    ViewPager.OnPageChangeListener {
    val BIG_SCALE = 1.0f
    val SMALL_SCALE = 0.7f
    val DIFF_SCALE = BIG_SCALE - SMALL_SCALE
    private var context: MainActivity = context
    private var fragmentManager: FragmentManager? = fm
    private var scale = 0f

    override fun getItem(position: Int): Fragment {
        // make the first pager bigger than others
        var position = position
        try {
            scale = if (position == 10) BIG_SCALE else SMALL_SCALE
            position = position % 10
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return ItemFragment.newInstance(context,position,scale)
    }

   override fun getCount(): Int {
        var count = 0
        try {
            count = 7 * 1000
        } catch (e: Exception) {
            // TODO: handle exception
            e.printStackTrace()
        }
        return 7
    }

    override fun onPageScrolled(
        position: Int,
        positionOffset: Float,
        positionOffsetPixels: Int
    ) {
        try {
            if (positionOffset >= 0f && positionOffset <= 1f) {
                val cur = getRootView(position)
                val next = getRootView(position + 1)
                cur.setScaleBoth(BIG_SCALE - DIFF_SCALE * positionOffset)
                next.setScaleBoth(SMALL_SCALE + DIFF_SCALE * positionOffset)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun onPageSelected(position: Int) {}

    override fun onPageScrollStateChanged(state: Int) {}

    private fun getRootView(position: Int): CarouselLinearLayout {
        return fragmentManager!!.findFragmentByTag(getFragmentTag(position))!!.getView()!!.findViewById(R.id.root_container)
    }

    private fun getFragmentTag(position: Int): String? {
        return "android:switcher:" + context.pager!!.getId().toString() + ":" + position
    }
}