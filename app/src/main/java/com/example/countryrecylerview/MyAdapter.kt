package com.example.countryrecylerview

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter (var myarray: ArrayList<datamodel>,var context: Activity ) :
RecyclerView.Adapter<MyAdapter.MyViewHolder>()
{
    private  lateinit var mylisitner: onItemClickListener
    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setonItemClickListner(listener:onItemClickListener){
        mylisitner=listener
    }





    class MyViewHolder (itemView: View,listener: onItemClickListener):RecyclerView.ViewHolder (itemView){

          val img=itemView.findViewById<ImageView>(R.id.imageView)

        val textt=itemView.findViewById<TextView>(R.id.textView)
        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {

        val itemView=LayoutInflater.from(parent.context).inflate(R.layout.mycountrystyle,parent,false)

        return MyViewHolder(itemView,mylisitner )

    }

    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {

        val currentitem=myarray[position]
        holder.img.setImageResource(currentitem.img)
        holder.textt.text=currentitem.txt
    }

    override fun getItemCount(): Int {
      return myarray.size
    }
}