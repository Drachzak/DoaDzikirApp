package com.dzak.doadandzikir.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.dzak.doadandzikir.adapter.DzikirDoaAdapter
import com.dzak.doadandzikir.data.DataDzikirDoa
import com.dzak.doadandzikir.databinding.ActivityDzikirPagiBinding

class DzikirPagiActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDzikirPagiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDzikirPagiBinding.inflate(layoutInflater)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setContentView(binding.root)

        with(binding.rvDzikirPagi){
            layoutManager = LinearLayoutManager(this@DzikirPagiActivity)
            adapter = DzikirDoaAdapter(DataDzikirDoa.listDzikirPagi)
        }
    }
}