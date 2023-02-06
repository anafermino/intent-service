package com.example.intentservice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.intentservice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnStart.setOnClickListener {
            Intent(this, MyIntentService::class.java).also {
                startService(it)
                binding.tvStatus.text = "Service running"
            }
        }

        binding.btnStop.setOnClickListener {
            MyIntentService.stopService()
            binding.tvStatus.text = "Service stopped"
        }
    }
}
