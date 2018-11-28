package com.camachoyury.marvelwiki

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import androidx.databinding.DataBindingUtil
import com.camachoyury.marvelwiki.data.model.Character


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //.......................

        getLifecycle().addObserver(LifecycleSearch());

            val binding: com.camachoyury.marvelwiki.databinding.ActivityMainBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_main)
        val hero = Character(10,"Ironman")
        binding.hero = hero


    }
}
