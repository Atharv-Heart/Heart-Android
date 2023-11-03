package com.accidentaldeveloper.heart.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.accidentaldeveloper.heart.R
import com.accidentaldeveloper.heart.models.heart_events_model.events_responseItem

class MyAdapter(private val eventsArrayList : List<events_responseItem>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.events_rv,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = eventsArrayList[position]
        //holder.date.text = currentItem.date
        holder.place.text = currentItem.location
        holder.dis.text = currentItem.description
        //Picasso.get().load(currentItem.imageUrl).into(holder.image);
    }

    override fun getItemCount(): Int {
        return eventsArrayList.size
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {


            //val date = itemView.findViewById<TextView>(R.id.date)
        val dis = itemView.findViewById<TextView>(R.id.dis)
        val place = itemView.findViewById<TextView>(R.id.place)

        /*val  month = itemView.findViewById<TextView>(R.id.month)
        val bookmark = itemView.findViewById<ImageView>(R.id.bookmark)
        val time = itemView.findViewById<TextView>(R.id.time)
        val image = itemView.findViewById<TextView>(R.id.image)*/

    }
}