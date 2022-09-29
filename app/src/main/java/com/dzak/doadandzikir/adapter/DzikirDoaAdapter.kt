package com.dzak.doadandzikir.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dzak.doadandzikir.databinding.RowIremDzikirDoaBinding
import com.dzak.doadandzikir.model.DzikirDoa

class DzikirDoaAdapter(val listDzikirDoa: ArrayList<DzikirDoa>): RecyclerView.Adapter<DzikirDoaAdapter.ViewHolder>() {

    class ViewHolder(var binding : RowIremDzikirDoaBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        RowIremDzikirDoaBinding.inflate(LayoutInflater.from(parent.context),parent,false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.tvDesc.text = listDzikirDoa[position].desc
        holder.binding.tvLafaz.text = listDzikirDoa[position].lafaz
        holder.binding.tvTerjemah.text = listDzikirDoa[position].terjemah
    }

    override fun getItemCount() = listDzikirDoa.size
}