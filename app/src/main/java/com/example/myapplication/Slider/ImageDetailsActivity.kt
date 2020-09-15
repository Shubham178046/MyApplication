package com.example.myapplication.Slider

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import kotlinx.android.synthetic.main.fragment_sliding.*


class ImageDetailsActivity : AppCompatActivity() {
    private var imageView: ImageView? = null
    private var button: Button? = null
    private val DRAWABLE_RESOURE = "resource"
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_full_image)

        imageView = findViewById(R.id.img) as ImageView
        button = findViewById(R.id.btnClose) as Button

        val drawbleResource = intent.getIntExtra(DRAWABLE_RESOURE, 0)
        imageView!!.setImageResource(drawbleResource)
        button!!.setOnClickListener { finish() }

    }

    override fun onBackPressed() {
        finish()
    }
}