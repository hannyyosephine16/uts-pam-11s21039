package com.ifs21039.dinopedia

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyDinoAdapter(private val data: List<MyDinoData>) :
    RecyclerView.Adapter<MyDinoAdapter.DinoViewHolder>() {

    private var listener: OnItemClickListener? = null

    interface OnItemClickListener {
        fun onItemClick(dino: MyDinoData)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DinoViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.dino_item_list, parent, false)
        return DinoViewHolder(view)
    }

    override fun onBindViewHolder(holder: DinoViewHolder, position: Int) {
        val dino = data[position]
        holder.bind(dino)
        holder.itemView.setOnClickListener {
            listener?.onItemClick(dino)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class DinoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imgIconDino: ImageView = itemView.findViewById(R.id.img_dino_icon)
        private val txtNamaDino: TextView = itemView.findViewById(R.id.txt_nama_dino)

        fun bind(dino: MyDinoData) {
            imgIconDino.setImageResource(dino.dinoIcon)
            txtNamaDino.text = dino.dinoName
        }
    }
}