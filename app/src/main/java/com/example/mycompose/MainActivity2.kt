package com.example.mycompose

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity2 : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var manager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupView()
    }

    private fun setupView() {

        Log.d(TAG, "-----setupView 000")
        manager = LinearLayoutManager(this)
        viewAdapter = MyAdapter(getData(20000))
        recyclerView = findViewById<RecyclerView>(R.id.recyclerView).apply {
            setHasFixedSize(true)
            layoutManager = manager
            adapter = viewAdapter
        }
        Log.d(TAG, "-----setupView 111")

    }

    private fun getData(size: Int): List<String> {
        Log.d(TAG, "-----getdata 000")
        val list = ArrayList<String>()
        for (i in 0..size) {
            list.add("name $i")
        }
        Log.d(TAG, "-----getdata 111")
        return list
    }


    class MyAdapter(val data: List<String>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
        class MyViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            val textViewGroup = LayoutInflater.from(parent.context)
                .inflate(R.layout.my_text_view, parent, false) as TextView
//            val tv = TextView(parent.context)

//            return MyViewHolder(tv)
            return MyViewHolder(textViewGroup)
        }

        override fun getItemCount(): Int {
            return data.size
        }

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            holder.textView.text = data[position]
        }


    }
}