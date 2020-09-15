package com.example.myapplication

import android.os.Bundle
import android.util.DisplayMetrics
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager


class CardViewSliding : AppCompatActivity()  {
    var slidingItemModel = ArrayList<SlidingItemModel>()
    lateinit var slidingItemAdapter : SlidingItemAdapter

    companion object{
        const val PAGES = 7
        lateinit var pager : ViewPager
        val LOOPS = 1000
       // var FIRST_PAGE = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card_view_sliding)
        var colors  = arrayOf(resources.getColor(R.color.color1),resources.getColor(R.color.ironman),resources.getColor(R.color.spiderman),resources.getColor(R.color.thor),resources.getColor(R.color.captainamerica),resources.getColor(R.color.hulk),resources.getColor(R.color.color3))
            pager = findViewById(R.id.viewPagerSliding)

        slidingItemModel.add(SlidingItemModel(R.drawable.brochure,"Brocher","Brochure is an informative paper document (often also used for advertising) that can be folded into a template"))
        slidingItemModel.add(SlidingItemModel(R.drawable.ironman,"Iron Man","Iron Man is a fictional superhero who wears a suit of armor. His alter ego is Tony Stark. He was created by Stan Lee, Jack Kirby and Larry Lieber for Marvel Comics in Tales of Suspense #39 in the year 1963 and appears in their comic books. He is also one of the main protagonists in the Marvel Cinematic Universe."))
        slidingItemModel.add(SlidingItemModel(R.drawable.spiderman,"SpiderMan","Spider-Man has spider-like abilities including superhuman strength and the ability to cling to most surfaces. He is also extremely agile and has amazing reflexes. Spider-Man also has a “spider sense,” that warns him of impending danger. Spider-Man has supplemented his powers with technology."))
        slidingItemModel.add(SlidingItemModel(R.drawable.thor,"Thor","In Germanic mythology, Thor (/θɔːr/; from Old Norse: Þórr, runic ᚦᚢᚱ þur) is a hammer-wielding god associated with thunder, lightning, storms, sacred groves and trees, strength, the protection of mankind and also hallowing and fertility."))
        slidingItemModel.add(SlidingItemModel(R.drawable.captainamerica,"Captain America","Captain America is the alter ego of Steve Rogers, a frail young man enhanced to the peak of human perfection by an experimental serum to aid the United States government's efforts in World War II. Near the end of the war, he was trapped in ice and survived in suspended animation until he was revived in modern times."))
        slidingItemModel.add(SlidingItemModel(R.drawable.hulk,"Hulk","In his comic book appearances, the character is both the Hulk, a green-skinned, hulking and muscular humanoid possessing a vast degree of physical strength, and his alter ego Dr. Robert Bruce Banner, a physically weak, socially withdrawn, and emotionally reserved physicist, the two existing as independent personalities"))
        slidingItemModel.add(SlidingItemModel(R.drawable.poster,"Poster","Poster is any piece of printed paper designed to be attached to a wall or vertical surface."))

        slidingItemAdapter = SlidingItemAdapter(this,supportFragmentManager,colors)
        pager.adapter = slidingItemAdapter
       slidingItemAdapter.notifyDataSetChanged()
        pager.addOnPageChangeListener(slidingItemAdapter)
       // pager!!.setPadding(50,0,50,0)
        val metrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(metrics)
        val pageMargin = metrics.widthPixels / 4 * 2
        pager.pageMargin = pageMargin
        pager.setCurrentItem(0);
        pager.setOffscreenPageLimit(3);

    }
}