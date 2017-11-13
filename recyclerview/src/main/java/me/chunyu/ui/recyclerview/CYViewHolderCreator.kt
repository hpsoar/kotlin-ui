package me.chunyu.ui.recyclerview

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

/**
* Created by Roger Huang on 11/11/2017.
*/
interface CYViewHolderCreator {
    val viewType: Int
    val layout: Int
    fun create(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder
}

