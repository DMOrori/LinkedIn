package com.example.linkedin

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavigation: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, 0, systemBars.right, 0)
            insets
        }

        setupBottomNavigation()
        
        // Set default fragment
        if (savedInstanceState == null) {
            replaceFragment(HomeFragment())
        }
    }

    private fun setupBottomNavigation() {
        bottomNavigation = findViewById(R.id.bottomNavigation)
        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    replaceFragment(HomeFragment())
                    true
                }
                R.id.navigation_network -> {
                    replaceFragment(NetworkFragment())
                    true
                }
                R.id.navigation_post -> {
                    // In real LinkedIn, this often opens a new activity or a full-screen dialog
                    // For now, let's just show a placeholder fragment
                    replaceFragment(PlaceholderFragment("Post"))
                    true
                }
                R.id.navigation_notifications -> {
                    replaceFragment(PlaceholderFragment("Notifications"))
                    true
                }
                R.id.navigation_jobs -> {
                    replaceFragment(PlaceholderFragment("Jobs"))
                    true
                }
                else -> false
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }
}