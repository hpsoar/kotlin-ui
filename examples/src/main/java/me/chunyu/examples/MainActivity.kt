package me.chunyu.examples

import android.os.Bundle
import me.chunyu.examples.common.GridListActivity
import me.chunyu.examples.recyclerview.Example

class MainActivity : GridListActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        adapter.addItems(Example.examples)
    }
}
