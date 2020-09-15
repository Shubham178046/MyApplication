package com.example.myapplication

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.widget.LinearLayout


class SlidingLayout : LinearLayout {
    constructor(
        context: Context?,
        attrs: AttributeSet?
    ) : super(context, attrs) {

    }
    constructor(context: Context?) : super(context) {
    }

    private var scale: Float = 1.0f

    fun setScaleBoth(scale: Float) {
        this.scale = scale
        this.invalidate()
    }
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val w = this.width
        val h = this.height
       canvas!!.scale(scale, scale, (w / 2).toFloat(), (h / 2).toFloat())


    }
}