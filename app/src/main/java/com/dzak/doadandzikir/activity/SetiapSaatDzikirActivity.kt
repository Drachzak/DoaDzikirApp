package com.dzak.doadandzikir.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.dzak.doadandzikir.adapter.DzikirDoaAdapter
import com.dzak.doadandzikir.data.DataDzikirDoa
import com.dzak.doadandzikir.databinding.ActivitySetiapSaatDzikirBinding

class SetiapSaatDzikirActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySetiapSaatDzikirBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySetiapSaatDzikirBinding.inflate(layoutInflater)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setContentView(binding.root)

        with(binding.rvDzikirSetiapSaat){
            layoutManager = LinearLayoutManager(this@SetiapSaatDzikirActivity)
            adapter = DzikirDoaAdapter(DataDzikirDoa.listDzikir)
        }
    }
}