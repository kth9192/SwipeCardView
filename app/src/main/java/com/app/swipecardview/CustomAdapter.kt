package com.app.swipecardview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_card.view.*

class CustomAdapter(models: ArrayList<Model>, context: Context) : PagerAdapter() {

    private var models: ArrayList<Model> = models
    private lateinit var layoutInfalter: LayoutInflater
    private var context: Context = context
    private var currentItem: Int = 0

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getCount(): Int {
        return models.size
    }

    fun setCurrentItem(position: Int) {
        currentItem = position
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        layoutInfalter = LayoutInflater.from(context)
        val view: View = layoutInfalter.inflate(R.layout.item_card, container, false)

        Glide.with(view.img.context).load(models[position].image).into(view.img)
        view.title.text = models[position].title
        view.desc.text = models[position].desc

        view.setOnClickListener { Toast.makeText(context, "$position 클릭", Toast.LENGTH_SHORT).show() }
        
        container.addView(view)

        return view
    }

    override fun setPrimaryItem(container: ViewGroup, position: Int, `object`: Any) {
        super.setPrimaryItem(container, position, `object`)
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View?)
    }
}