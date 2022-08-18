package com.example.dogspike

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso

class DogsAdapter(private val dogsUrls: List<String>, private val imageWidth: Int) :
    RecyclerView.Adapter<DogsAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val imageView: ImageView
        private val loadingView: ProgressBar

        init {
            imageView = view.findViewById(R.id.item_dog_photo)
            loadingView = view.findViewById(R.id.item_dog_loading)
        }

        fun bind(url: String, imageWidth: Int) {
            Picasso.get()
                .load(url)
                .resize(imageWidth, 0)
                .error(R.drawable.dog_error)
                .into(imageView, object : Callback {
                    override fun onSuccess() {
                        loadingView.visibility = View.GONE
                    }

                    override fun onError(e: Exception?) {
                        //Not used
                    }
                })
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