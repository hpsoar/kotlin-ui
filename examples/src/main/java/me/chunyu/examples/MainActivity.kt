package me.chunyu.examples

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import me.chunyu.examples.common.GridListActivity
import me.chunyu.examples.recyclerview.Example
import me.chunyu.ui.recyclerview.RecyclerAdapter

class MainActivity : GridListActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        adapter.addItems(Example.examples)
    }
}
