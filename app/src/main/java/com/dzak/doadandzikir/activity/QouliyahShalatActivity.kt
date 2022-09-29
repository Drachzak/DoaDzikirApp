package com.dzak.doadandzikir.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.dzak.doadandzikir.adapter.DzikirDoaAdapter
import com.dzak.doadandzikir.data.DataDzikirDoa
import com.dzak.doadandzikir.databinding.ActivityQouliyahShalatBinding

class QouliyahShalatActivity : AppCompatActivity() {

    private lateinit var binding: ActivityQouliyahShalatBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQouliyahShalatBinding.inflate(layoutInflater)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setContentView(binding.root)

        with(binding.rvQouliyahShalat){
            layoutManager = LinearLayoutManager(this@QouliyahShalatActivity)
            adapter = DzikirDoaAdapter(DataDzikirDoa.listQouliyah)
        }
    }
}