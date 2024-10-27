package com.example.android_hw_1

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MyActivity : AppCompatActivity() {
    companion object {
        private const val ITEMS = "squares"
        private val INITIAL_VALUE = arrayListOf(1, 2, 3, 4, 5)
    }

    private lateinit var recyclerView: RecyclerView
    private lateinit var button: Button

    private var adapter = MyAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recycler_view)
        button = findViewById(R.id.button)

        val items = savedInstanceState?.getIntegerArrayList(ITEMS) ?: INITIAL_VALUE

        adapter.setItems(items)
        recyclerView.adapter = adapter

        button.setOnClickListener {
            adapter.addItem()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putIntegerArrayList(ITEMS, adapter.getItems())
    }
}