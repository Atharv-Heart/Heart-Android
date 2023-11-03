package com.accidentaldeveloper.heart.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.accidentaldeveloper.heart.R
import com.accidentaldeveloper.heart.models.Heart_gallery_model.gallery_responseItem
import com.bumptech.glide.Glide


class GalleryAdapter(private val items: List<gallery_responseItem>) :
    RecyclerView.Adapter<GalleryAdapter.GalleryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.galleryrv, parent, false)
        return GalleryViewHolder(view)
    }

    override fun onBindViewHolder(holder: GalleryViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = items.size

    inner class GalleryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: gallery_responseItem) {
            // Use Glide to load the image from the URL into an ImageView
            Glide.with(itemView.context)
                .load(item.imageUrl)
                .into(itemView.findViewById<ImageView>(R.id.vinit))



        }
    }
}
