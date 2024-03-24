package com.ifs21039.dinopedia

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MyDinoAdapter(private val myDinoData: Array<MyDinoData>, private val context: Context) :
    RecyclerView.Adapter<MyDinoAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.dino_item_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val myDinoDataList = myDinoData[position]
        holder.textViewTitle.text = myDinoDataList.dinoTitle
        holder.textViewDesc.text = myDinoDataList.dinoDesc
        holder.dinoImage.setImageResource(myDinoDataList.dinoImage)

        holder.itemView.setOnClickListener {
            Toast.makeText(context, myDinoDataList.dinoTitle, Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return myDinoData.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val dinoImage: ImageView = itemView.findViewById(R.id.imageview)
        val textViewTitle: TextView = itemView.findViewById(R.id.dinoTitle)
        val textViewDesc: TextView = itemView.findViewById(R.id.dinoDesc)
    }
}
