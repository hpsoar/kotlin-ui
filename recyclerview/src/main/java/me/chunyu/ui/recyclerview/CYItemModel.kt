package me.chunyu.ui.recyclerview

/**
* Created by Roger Huang on 11/11/2017.
*/
interface CYItemModel {
    fun getViewHolderCreator() : CYViewHolderCreator? {
        return null
    }
}
