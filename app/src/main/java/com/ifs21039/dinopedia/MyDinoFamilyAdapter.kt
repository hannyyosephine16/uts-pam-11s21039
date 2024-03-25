package com.ifs21039.dinopedia


import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ifs21039.dinopedia.databinding.DinoItemFamilyBinding

class MyDinoFamilyAdapter(private val listFamily: ArrayList<MyDinoFamily>) :
    RecyclerView.Adapter<MyDinoFamilyAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = DinoItemFamilyBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val family = listFamily[position]
        holder.binding.imgFamiliItem.setImageResource(family.iconFamily)
        holder.binding.txtFamiliItem.text = family.namaFamily
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listFamily[holder.adapterPosition])
        }
    }

    override fun getItemCount(): Int = listFamily.size

    class ListViewHolder(var binding: DinoItemFamilyBinding) : RecyclerView.ViewHolder(binding.root)

    interface OnItemClickCallback {
        fun onItemClicked(data: MyDinoFamily)
    }
}
