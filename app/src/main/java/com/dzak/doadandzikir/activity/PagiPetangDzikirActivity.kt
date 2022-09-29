package com.dzak.doadandzikir.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.dzak.doadandzikir.R
import com.dzak.doadandzikir.databinding.ActivityPagiPetangDzikirBinding

class PagiPetangDzikirActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityPagiPetangDzikirBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPagiPetangDzikirBinding.inflate(layoutInflater)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setContentView(binding.root)

        binding.cvDzikirPagi.setOnClickListener(this)
        binding.imgBtnDzikirPagi.setOnClickListener(this)

        binding.cvDzikirPetang.setOnClickListener(this)
        binding.imgBtnDzikirPetang.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.cv_dzikir_pagi -> startActivity(Intent(this,DzikirPagiActivity::class.java))
            R.id.img_btn_dzikir_pagi -> startActivity(Intent(this,DzikirPagiActivity::class.java))

            R.id.cv_dzikir_petang -> startActivity(Intent(this,DzikirPetangActivity::class.java))
            R.id.img_btn_dzikir_petang -> startActivity(Intent(this,DzikirPetangActivity::class.java))
        }
    }
}