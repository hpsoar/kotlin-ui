package me.chunyu.examples.recyclerview

import me.chunyu.ui.recyclerview.CYItemModel
import me.chunyu.ui.recyclerview.CYViewHolderCreator

/**
 * Created by huangpeng on 11/11/2017.
 *
 * this is the item that will bind to view holder
 */
class CYPhotoItem(photo: CYPhoto) : CYItemModel {
    val photo = photo
    override fun getViewHolderCreator(): CYViewHolderCreator? {
        return CYPhotoViewHolder.creator
    }
}