package com.example.ridingwithstranger

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ridingwithstranger.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.myrides -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, MyRides())
                        .commit()
                    true
                }
                // Add other navigation items here as needed
                else -> false
            }
        }
        // Show MyRides fragment by default
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, MyRides())
            .commit()
    }
}