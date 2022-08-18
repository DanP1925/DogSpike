package com.example.dogspike

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.rv_main)
        recyclerView.layoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        //TODO: Replace dataset with data fetched from remote data source
        val dogs = mutableListOf(
            "https://images.dog.ceo/breeds/poodle-miniature/n02113712_1077.jpg",
            "https://images.dog.ceo/breeds/spaniel-cocker/n02102318_3700.jpg",
            "https://images.dog.ceo/breeds/stbernard/n02109525_3346.jpg"
        )
        val adapter = DogsAdapter(dogs)
        recyclerView.adapter = adapter
    }

}