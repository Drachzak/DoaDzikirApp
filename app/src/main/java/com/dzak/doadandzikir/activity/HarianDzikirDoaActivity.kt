package com.dzak.doadandzikir.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.dzak.doadandzikir.R
import com.dzak.doadandzikir.adapter.DzikirDoaAdapter
import com.dzak.doadandzikir.databinding.ActivityHarianDzikirDoaBinding
import com.dzak.doadandzikir.model.DzikirDoa

class HarianDzikirDoaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHarianDzikirDoaBinding
    private val listDzikir: ArrayList<DzikirDoa> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHarianDzikirDoaBinding.inflate(layoutInflater)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setContentView(binding.root)

        with(binding.rvDzikirDoaHarian){
            layoutManager = LinearLayoutManager(this@HarianDzikirDoaActivity)
            adapter = DzikirDoaAdapter(listDzikir)
        }

        initdata()
    }

    private fun initdata() {
        val desc = resources.getStringArray(R.array.arr_dzikir_doa_harian)
        val lafaz = resources.getStringArray(R.array.arr_lafaz_dzikir_doa_harian)
        val terjemah = resources.getStringArray(R.array.arr_terjemah_dzikir_doa_harian)

        for (i in desc.indices){
            val dzikir = DzikirDoa(
                desc[i],
                lafaz[i],
                terjemah[i],
            )
            listDzikir.add(dzikir)
        }
    }
}