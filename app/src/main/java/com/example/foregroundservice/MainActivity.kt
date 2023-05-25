package com.example.foregroundservice

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.foregroundservice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var foregroundServiceIntent: Intent? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        foregroundServiceIntent = Intent(this, MyForegroundService::class.java)

        binding.btnStartService.setOnClickListener {
            startMyForegroundService()
        }

        binding.btnStopService.setOnClickListener {
            stopMyForegroundService()
        }
    }

    private fun startMyForegroundService() {
        startService(foregroundServiceIntent)
    }

    private fun stopMyForegroundService() {
        stopService(foregroundServiceIntent)
    }
}