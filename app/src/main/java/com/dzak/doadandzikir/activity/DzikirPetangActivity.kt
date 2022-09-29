package com.dzak.doadandzikir.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.dzak.doadandzikir.adapter.DzikirDoaAdapter
import com.dzak.doadandzikir.data.DataDzikirDoa
import com.dzak.doadandzikir.databinding.ActivityDzikirPetangBinding

class DzikirPetangActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDzikirPetangBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDzikirPetangBinding.inflate(layoutInflater)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setContentView(binding.root)

        with(binding.rvDzikirPetang){
            layoutManager =
                LinearLayoutManager(this@DzikirPetangActivity)
            adapter = DzikirDoaAdapter(DataDzikirDoa.listDzikirPetang)
        }
    }
}