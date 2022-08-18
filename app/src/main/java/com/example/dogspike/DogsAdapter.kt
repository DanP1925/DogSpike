package com.example.dogspike

import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.squareup.picasso.Transformation

class DogsAdapter(private val dogsUrls: List<String>) :
    RecyclerView.Adapter<DogsAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val imageView: ImageView

        init {
            imageView = view.findViewById(R.id.item_dog_photo)
        }

        fun bind(url: String) {
            val transformation = object : Transformation {
                override fun transform(source: Bitmap): Bitmap {
                    val targetWidth: Int = imageView.width
                    val aspectRatio: Double = (source.height.toDouble() / source.width.toDouble())
                    val targetHeight: Int = (targetWidth * aspectRatio).toInt()
                    val result: Bitmap =
                        Bitmap.createScaledBitmap(source, targetWidth, targetHeight, false)
                    if (result != source) {
                        source.recycle()
                    }
                    return result
                }

                override fun key(): String {
                    return "transformation" + "desiredHeight"
                }
            }

            imageView.viewTreeObserver.addOnGlobalLayoutListener {
                //TODO: Add placeholder and error images
                Picasso.get()
                    .load(url)
                    .transform(transformation)
                    .into(imageView)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_dogs, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dogsUrls[position])
    }

    override fun getItemCount() = dogsUrls.size

}