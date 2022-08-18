package com.example.dogspike

import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.squareup.picasso.Transformation

class DogsAdapter(private val dogsUrls: List<String>, private val imageWidth: Int) :
    RecyclerView.Adapter<DogsAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val imageView: ImageView

        init {
            imageView = view.findViewById(R.id.item_dog_photo)
        }

        fun bind(url: String, imageWidth: Int) {
            Picasso.get()
                .load(url)
                .resize(imageWidth, 0)
                .into(imageView)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_dogs, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dogsUrls[position], imageWidth)
    }

    override fun getItemCount() = dogsUrls.size

}