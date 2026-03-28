package com.example.linkedin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class PlaceholderFragment(private var title: String) : Fragment() {
    
    // Default constructor for fragment recreation
    constructor() : this("Placeholder")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_placeholder, container, false)
        view.findViewById<TextView>(R.id.tvPlaceholder).text = title
        return view
    }
}