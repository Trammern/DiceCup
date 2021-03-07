package com.example.dicecup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dicecupcompulsory.R
import kotlinx.android.synthetic.main.activity_history.*

class History : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)
        val extras: Bundle = intent.extras!!
        val listHistory = extras.getSerializable("history") as MutableList<Int>
        recycler_View.adapter = RecyclerAdapter(listHistory)
        recycler_View.layoutManager = LinearLayoutManager(this)
        recycler_View.setHasFixedSize(true)



    }


}