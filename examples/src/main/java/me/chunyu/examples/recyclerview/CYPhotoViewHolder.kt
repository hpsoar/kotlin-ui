package me.chunyu.examples.recyclerview

import android.support.v7.widget.RecyclerView
import android.view.View
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.recycleview_photo_item.view.*
import me.chunyu.examples.R
import me.chunyu.ui.recyclerview.CYItemViewHolder

/**
 * Created by huangpeng on 11/11/2017.
 */
class CYPhotoViewHolder(v: View) : RecyclerView.ViewHolder(v), me.chunyu.ui.recyclerview.CYItemViewHolder {
    //2
    private var view: View = v
    private var photo: CYPhoto? = null

    //3
    init {

    }

    override fun shouldUpdate(item: Any): Boolean {
        if (item !is CYPhotoItem) return false

        val photo = item.photo

        this.photo = photo

        Picasso.with(view.context).load(photo.url).into(view.itemImage)
        view.itemDate.text = photo.humanDate
        view.itemDescription.text = photo.explanation

        return true
    }

    companion object {
        val creator = CYItemViewHolder.Creator(CYPhotoViewHolder::class, R.layout.recycleview_photo_item)
    }
}