package me.chunyu.ui.recyclerview

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import me.chunyu.recyclerview.R
import me.chunyu.ui.utils.inflate
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.count
import kotlin.collections.set

/**
 * Created by Roger Huang on 11/11/2017.
 */

/*
    there are two ways to bind ViewHolder subclass with CYItemModel
    1. call registerModelViewHolder manually for each (model, holder) pair
    2. return a CYViewHolderCreator from CYItemModel::getViewHolderCreator()
       1. one CYItemModel can return different creator at different state
 */
class CYRecyclerAdapter(items: ArrayList<CYItemModel>?) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var mItems = ArrayList<CYItemModel>()

    // Model -> viewType
    private val mViewTypeMap = HashMap<Class<*>, Int>()

    // viewType -> ViewHolderCreator
    private val mHolderMap = HashMap<Int, CYViewHolderCreator>()

    init {
        if (items != null) {
            addItems(items)
        }
    }

    fun<T: CYItemModel> registerModelViewHolder(key: Class<T>, creator: CYViewHolderCreator) {
        mViewTypeMap[key] = creator.viewType

        addViewHolderCreator(creator)
    }

    // MARK - add & remove items

    fun addItems(items: ArrayList<CYItemModel>) {
        mItems.addAll(items)
    }

    fun addItem(item: CYItemModel) {
        mItems.add(item)
    }

    fun add(item: CYItemModel, position: Int) {
        mItems.add(position, item)
    }

    fun removeItemAt(position: Int) {
        mItems.removeAt(position)
    }

    // MARK - overrides: holder create & bind

    override fun getItemCount() : Int {
        return mItems.count()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = mItems[position]

        if (holder is CYItemViewHolder) {
            holder.shouldUpdate(item)
        } else if (holder is CYDummyViewHolder) {
            // remind user that he forget to map CYItemModel to CYItemViewHolder
            val msg = nonViewHolderMapMsg(item, position)
            holder.updateWithMsg(msg)
        }
    }

    override fun getItemViewType(position: Int): Int {
        val item = mItems[position]

        // if item has creator, use this creator
        val creator = item.getViewHolderCreator()

        if (creator != null) {
            // add this creator to adapter
            addViewHolderCreator(creator)

            return creator.viewType
        }

        // otherwise, we use a registeredCreator
        val viewType = mViewTypeMap[item.javaClass]

        return viewType ?: -1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val meta = mHolderMap[viewType]
        if (meta != null) {
            return meta.create(parent, viewType)
        }

        val inflatedView = parent.inflate(R.layout.dummy_recyclerview_item_row, false)
        return CYDummyViewHolder(inflatedView)
    }

    // MARK - private

    private fun addViewHolderCreator(creator: CYViewHolderCreator) {
        mHolderMap[creator.viewType] = creator
    }

    private fun nonViewHolderMapMsg(item: CYItemModel, position: Int) : String {
        val msg = item::class.toString() + " at position " + position.toString() + " did not map to any view holder" +
                "\nTODO:" +
                "\n  1. implement CYItemModel::getViewHolderCreator in your model class;" +
                "\n  2. call RecyclerAdapter::mapModelViewHolder to map your model to a ViewHolder;"
        return msg
    }
}