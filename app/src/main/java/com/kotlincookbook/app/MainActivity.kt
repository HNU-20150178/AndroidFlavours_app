package com.kotlincookbook.app

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var mAdapter:AndroidFlavourAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mAdapter= AndroidFlavourAdapter()
        flavour_list.layoutManager=LinearLayoutManager(this)
        flavour_list.adapter=mAdapter
        mAdapter.flavourItems=flavorList
        shuffle.setOnClickListener {
            mAdapter.flavourItems=flavorList.shuffle()
        }
    }
}

