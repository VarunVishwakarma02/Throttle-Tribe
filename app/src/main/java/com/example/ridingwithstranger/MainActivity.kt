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
                R.id.myride -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, MyRides())
                        .commit()
                    true
                }
                // Add other navigation items here as needed
                R.id.profile -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, Profile())
                        .commit()
                    true
                }
                R.id.explore -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, Explore())
                        .commit()
                    true
                }
                else -> false

            }
        }
        // Set default fragment
        if(savedInstanceState == null){
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, Explore())
                .commit()
        }
    }
}