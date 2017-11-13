package me.chunyu.ui.recyclerview

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.dummy_recyclerview_item_row.view.*


/**
 * Created by Roger Huang on 11/11/2017.
 */

/**
 * this view holder is used when you failed to map an item to a view holder type
 * this is to remind you of possible bug
 * TODO: add a way to turn this off, for online apps
 */
class CYDummyViewHolder(private val v: View) : RecyclerView.ViewHolder(v) {
    fun updateWithMsg(msg: String) {
        v.tipView.text = msg
    }
}