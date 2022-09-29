package com.dzak.doadandzikir.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dzak.doadandzikir.activity.DetailArtikelActivity
import com.dzak.doadandzikir.databinding.RowItemRecyclerBinding
import com.dzak.doadandzikir.model.Artikel

class ArtikelAdapter(val listArtikel: ArrayList<Artikel>): RecyclerView.Adapter<ArtikelAdapter.ViewHolder>() {

    class ViewHolder(var binding: RowItemRecyclerBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =  ViewHolder(
        RowItemRecyclerBinding.inflate(LayoutInflater.from(parent.context),parent,false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.imgArtikel.setImageResource(listArtikel[position].imageArtikel)

        holder.itemView.setOnClickListener {
            val pergi = Intent(it.context, DetailArtikelActivity::class.java)
            pergi.putExtra(DetailArtikelActivity.EXTRA_ARTIKEL,listArtikel[position])
            it.context.startActivity(pergi)
        }
    }

    override fun getItemCount() = listArtikel.size
}