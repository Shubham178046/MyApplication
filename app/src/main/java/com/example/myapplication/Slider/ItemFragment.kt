package com.example.myapplication.Slider

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.myapplication.MainActivity
import com.example.myapplication.R

private val POSITON = "position"
private val SCALE = "scale"
private val DRAWABLE_RESOURE = "resource"
class ItemFragment : Fragment() {
    private var screenWidth = 0
    private var screenHeight = 0

    private val imageArray = intArrayOf(
        R.drawable.brochure, R.drawable.ironman,
        R.drawable.thor, R.drawable.spiderman, R.drawable.hulk,
        R.drawable.captainamerica, R.drawable.poster, R.drawable.image8,
        R.drawable.image9, R.drawable.image10
    )
companion object
{
    fun newInstance(context: MainActivity, pos: Int, scale: Float): Fragment {
        val b = Bundle()
        b.putInt(POSITON, pos)
        b.putFloat(SCALE, scale)
        return context?.let { instantiate(it, ItemFragment::class.java.name, b) }
    }
}


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getWidthAndHeight()
    }
    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (container == null) {
            return null
        }
        val postion = this.arguments!!.getInt(POSITON)
        var scale  = this.arguments!!.getFloat(SCALE)
        val layoutParams =
            LinearLayout.LayoutParams(screenWidth / 2, screenHeight / 2)

        val linearLayout =
            inflater.inflate(R.layout.fragment_image, container, false) as LinearLayout

        val textView = linearLayout.findViewById<View>(R.id.text) as TextView
        val root =
            linearLayout.findViewById<View>(R.id.root_container) as CarouselLinearLayout
        val imageView =
            linearLayout.findViewById<View>(R.id.pagerImg) as ImageView

        textView.text = "item: $postion"
        val relativeLayout =
            RelativeLayout.LayoutParams(screenWidth / 2, screenHeight / 2)

        //imageView.setImageResource(imageArray[postion])
        Glide .with(context!!).load(imageArray[postion]).into(imageView)
        //handling click event


        //handling click event


        //imageView.layoutParams = relativeLayout
        root.setScaleBoth(scale)

        return linearLayout
    }

    private fun getWidthAndHeight() {
        val displaymetrics = DisplayMetrics()
        activity!!.windowManager.defaultDisplay.getMetrics(displaymetrics)
        screenHeight = displaymetrics.heightPixels
        screenWidth = displaymetrics.widthPixels
    }
}