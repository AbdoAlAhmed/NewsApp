package com.abdo.news

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.abdo.news.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        var navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment
        var navController = navHostFragment.navController
        binding.bottomNav.setupWithNavController(navController)


        setContentView(binding.root)
    }
}