package com.example.tvshowapp2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tvshowapp2.adapter.tvshowadapter
import com.example.tvshowapp2.databinding.ActivityMainBinding
import com.example.tvshowapp2.viewmodel.tvshowviewmodel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
   private val binding by lazy {
       ActivityMainBinding.inflate(layoutInflater)
   }
    private val viewmodel: tvshowviewmodel by viewModels()
    private lateinit var tvshowadpater: tvshowadapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setuprv()




    }

    private fun setuprv() {
        tvshowadpater= tvshowadapter()
        binding.recyclerview.apply {
            adapter=tvshowadpater
            layoutManager= LinearLayoutManager(this@MainActivity,
                LinearLayoutManager.VERTICAL,
                false)
            setHasFixedSize(true)
        }
        viewmodel.tvshowresponsedata.observe(this,{ listtvshow->
            tvshowadpater.tvshow=listtvshow

        })


    }
}