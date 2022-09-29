package com.dzak.doadandzikir.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dzak.doadandzikir.databinding.ActivityDetailArtikelBinding
import com.dzak.doadandzikir.model.Artikel


class DetailArtikelActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailArtikelBinding
    companion object{
        const val EXTRA_ARTIKEL = "u"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailArtikelBinding.inflate(layoutInflater)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        title = "Artikel Islami"
        setContentView(binding.root)

        val data = intent.getParcelableExtra<Artikel>(EXTRA_ARTIKEL)

        binding.tvDetailTitle.text = data?.titleArtikel
        binding.tvDetailDesc.text = data?.descArtikel
        binding.imgDetail.setImageResource(data!!.imageArtikel)
    }
}