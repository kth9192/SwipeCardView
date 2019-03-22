package com.app.swipecardview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_card.view.*

class CustomAdapter(models: ArrayList<Model>, context: Context) : PagerAdapter() {

    private var models: ArrayList<Model> = models
    private lateinit var layoutInfalter: LayoutInflater
    private var context: Context = context

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getCount(): Int {
        return models.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        layoutInfalter = LayoutInflater.from(context)
        val view : View = layoutInfalter.inflate(R.layout.item_card, container, false)

        Glide.with(view.img.context).load(models[position].image).into(view.img)
        view.title.text = models[position].title
        view.desc.text = models[position].desc

        container.addView(view)

        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View?)
    }
}