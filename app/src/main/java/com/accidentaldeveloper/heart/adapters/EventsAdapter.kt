package com.accidentaldeveloper.heart.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.accidentaldeveloper.heart.R
import com.accidentaldeveloper.heart.models.heart_events_model.events_responseItem
import com.bumptech.glide.Glide
import com.google.android.material.imageview.ShapeableImageView
import de.hdodenhof.circleimageview.CircleImageView

class MyAdapter(private val eventsArrayList : List<events_responseItem>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.events_rv,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = eventsArrayList[position]
        holder.time.text = currentItem.time
        holder.place.text = currentItem.location
        holder.dis.text = currentItem.description
       holder.date.text = currentItem.date
        Glide.with(holder.itemView.context)
            .load(currentItem.imageUrl)
            .into(holder.image)
    }

    override fun getItemCount(): Int {
        return eventsArrayList.size
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {


            //val date = itemView.findViewById<TextView>(R.id.date)
        val dis = itemView.findViewById<TextView>(R.id.dis)
        val place = itemView.findViewById<TextView>(R.id.place)
        val time = itemView.findViewById<TextView>(R.id.time)
        val date = itemView.findViewById<TextView>(R.id.date)

        val  image = itemView.findViewById<ImageView>(R.id.image)
        //val bookmark = itemView.findViewById<ImageView>(R.id.bookmark)



    }
}