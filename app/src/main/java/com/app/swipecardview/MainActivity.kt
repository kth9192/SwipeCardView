package com.app.swipecardview

import android.animation.ArgbEvaluator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var models : ArrayList<Model>
    private lateinit var myAdapter: CustomAdapter
    private lateinit var myViewPager: ViewPager
    private lateinit var colors: Array<Int>
    private var argbEvaluator = ArgbEvaluator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        models = ArrayList()
        models.add(Model(R.drawable.brochure, "brochure", "test1"))
        models.add(Model(R.drawable.sticker, "Sticker", "test2"))
        models.add(Model(R.drawable.poster, "Poster", "test3"))
        models.add(Model(R.drawable.namecard, "Namecard", "test4"))

        myViewPager = viewPager as ViewPager

        myAdapter = CustomAdapter(models, this)
        myViewPager.adapter = myAdapter
        myViewPager.setPadding(150, 0, 150, 0)

        dots_indicator.setViewPager(myViewPager)

//        var colors_tmp : Array<Int> = arrayOf(
//            resources.getColor(R.color.color1, null),
//            resources.getColor(R.color.color2, null),
//            resources.getColor(R.color.color3, null),
//            resources.getColor(R.color.color4, null)
//        )
//
//        colors = colors_tmp

        myViewPager.addOnPageChangeListener(object  : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
//                if(position < (myAdapter.count -1) && position < (colors.size -1)){
//                    myViewPager.setBackgroundColor(
//                        argbEvaluator.evaluate(positionOffset, colors[position], colors[position + 1]) as Int
//                    )
//                }
            }

            override fun onPageSelected(position: Int) {
            }

        })

    }
}
