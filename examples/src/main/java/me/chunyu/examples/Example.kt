package me.chunyu.examples.recyclerview

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.example_item_row.view.*
import me.chunyu.examples.R
import me.chunyu.ui.recyclerview.CYItemModel
import me.chunyu.ui.recyclerview.CYItemViewHolder
import me.chunyu.ui.recyclerview.CYViewHolderCreator

/**
 * Created by huangpeng on 11/11/2017.
 */
class Example(public val title: String, public val desc: String, private val activityClass: Class<*>) : CYItemModel {

    override fun getViewHolderCreator(): CYViewHolderCreator? {
        return ExampleViewHolder.creator
    }

    fun show(context: Context) {
        val intent = Intent(context, activityClass)
        context.startActivity(intent)
    }

    companion object {
        val examples = arrayListOf<CYItemModel>(
            Example("RecyclerView", "photo list", PhotoListActivity::class.java)
        )
    }
}

class ExampleViewHolder(v: View) : RecyclerView.ViewHolder(v), me.chunyu.ui.recyclerview.CYItemViewHolder {
    private var item: Example? = null

    init {
        v.setOnClickListener {
            showExample()
        }
    }

    private fun showExample() {
        if (item != null) {
            item?.show(itemView.context)
        }
    }

    override fun shouldUpdate(item: Any): Boolean {
        if (item is Example) {
            itemView.title.text = item.title
            itemView.desc.text = item.desc

            this.item = item
        }
        return true
    }

    companion object {
        val creator = CYItemViewHolder.Creator(ExampleViewHolder::class, R.layout.example_item_row)
    }
}
