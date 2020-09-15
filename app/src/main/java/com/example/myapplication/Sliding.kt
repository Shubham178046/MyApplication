package com.example.myapplication

import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.example.myapplication.SlidingLayout


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

private const val POSITON = "position"
private const val SCALE = "scale"
private const val DRAWABLE_RESOURE = "resource"

private var screenWidth = 0
private var screenHeight = 0

class Sliding : Fragment() {
    // TODO: Rename and change types of parameters
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getWidthAndHeight()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (container == null) {
            return null;
        }
        var linearLayout: LinearLayout =
            inflater.inflate(R.layout.fragment_sliding, container, false) as LinearLayout
        /* Log.d("Data", "onCreateView: "+slidingItemModel.size)
         context?.let { Glide.with(it).load(slidingItemModel.get(position).image).into(linearLayout.Slidingimage) };
         linearLayout.Slidingtitle.setText(slidingItemModel.get(position).title)
         linearLayout.Slidingdesc.setText(slidingItemModel.get(position).desc)
 */
        val scale = this.arguments!!.getFloat(SCALE)
        val pos = this.arguments!!.getInt(POSITON)
        val root: SlidingLayout =
            linearLayout.findViewById<View>(R.id.root_container) as SlidingLayout
        Log.d("SCALE", "onCreateView: "+scale+ "Position" + pos)
        root.setScaleBoth(scale)
        return linearLayout
    }

    companion object {
        @JvmStatic
        fun newInstance(context: CardViewSliding, position: Int, scale: Float): Fragment {
            val b = Bundle()
            b.putInt(POSITON, position)
            b.putFloat(SCALE, scale)
            return instantiate(
                context,
                Sliding::class.java.getName(), b
            )
        }
    }

    private fun getWidthAndHeight() {
        val displaymetrics = DisplayMetrics()
        activity!!.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics)
        screenHeight = displaymetrics.heightPixels
        screenWidth = displaymetrics.widthPixels

        Log.d("HEight And Width", "getWidthAndHeight: "+screenHeight +" " +screenWidth)
    }
}

