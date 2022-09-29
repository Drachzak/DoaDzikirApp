package com.dzak.doadandzikir

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.dzak.doadandzikir.activity.HarianDzikirDoaActivity
import com.dzak.doadandzikir.activity.PagiPetangDzikirActivity
import com.dzak.doadandzikir.activity.QouliyahShalatActivity
import com.dzak.doadandzikir.activity.SetiapSaatDzikirActivity
import com.dzak.doadandzikir.adapter.ArtikelAdapter
import com.dzak.doadandzikir.databinding.ActivityMainBinding
import com.dzak.doadandzikir.model.Artikel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val listArtikel: ArrayList<Artikel> = arrayListOf()
    private lateinit var dotSlide: Array<ImageView?>
    private val slidingCallBack = object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            for (i in 0 until listArtikel.size){
                dotSlide[i]?.setImageDrawable(
                    ContextCompat.getDrawable(applicationContext, R.drawable.dot_inactive)
                )
            }
            dotSlide[position]?.setImageDrawable(
                ContextCompat.getDrawable(applicationContext, R.drawable.dot_active)
            )
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
        initData()
        setupViewPager()

    }

    private fun setupViewPager() {
        dotSlide = arrayOfNulls(listArtikel.size)

        for (i in 0 until listArtikel.size){
            dotSlide[i] = ImageView(this)
            dotSlide[i]?.setImageDrawable(
                ContextCompat.getDrawable(applicationContext, R.drawable.dot_inactive)
            )

            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT,
            )
            params.setMargins(9,0,8,0)
            params.gravity = Gravity.CENTER_VERTICAL
            binding.llSlideDots.addView(dotSlide[i], params)
        }

        dotSlide[0]?.setImageDrawable(
            ContextCompat.getDrawable(applicationContext, R.drawable.dot_active)
        )
    }

    private fun initData() {
        val titleArtikel = resources.getStringArray(R.array.arr_title_artikel)
        val descArtikel = resources.getStringArray(R.array.arr_desc_artikel)
        val imgArtikel = resources.obtainTypedArray(R.array.arr_img_artikel)

        for (i in titleArtikel.indices){
            val artikel = Artikel(
                titleArtikel[i],
                descArtikel[i],
                imgArtikel.getResourceId(i,0)
            )
            listArtikel.add(artikel)
        }
        imgArtikel.recycle()
    }

    private fun initView() {
        binding.llDzikirDoaHarian.setOnClickListener {
            startActivity(Intent(this,HarianDzikirDoaActivity::class.java))
        }

        binding.llDzikirDoaShalat.setOnClickListener {
            startActivity(Intent(this,QouliyahShalatActivity::class.java))
        }

        binding.llDzikirPagiPetang.setOnClickListener {
            startActivity(Intent(this,PagiPetangDzikirActivity::class.java))
        }

        binding.llDzikirSetiapSaat.setOnClickListener {
            startActivity(Intent(this,SetiapSaatDzikirActivity::class.java))
        }

        binding.vpArtikel.adapter = ArtikelAdapter(listArtikel)

        binding.vpArtikel.adapter = ArtikelAdapter(listArtikel)
        binding.vpArtikel.registerOnPageChangeCallback(slidingCallBack)
    }
}