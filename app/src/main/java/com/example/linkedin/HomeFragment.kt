package com.example.linkedin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeFragment : Fragment() {

    private lateinit var feedRecyclerView: RecyclerView
    private lateinit var postAdapter: PostAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        setupRecyclerView(view)
        return view
    }

    private fun setupRecyclerView(view: View) {
        feedRecyclerView = view.findViewById(R.id.feedRecyclerView)
        feedRecyclerView.layoutManager = LinearLayoutManager(context)

        val dummyPosts = listOf(
            Post(
                1,
                "Sundar Pichai",
                "CEO at Google",
                R.drawable.ic_network,
                "2h",
                "Excited to share our latest breakthroughs in AI! We are building technology that helps everyone, everywhere.",
                null,
                1540,
                120
            ),
            Post(
                2,
                "Satya Nadella",
                "CEO at Microsoft",
                R.drawable.ic_network,
                "4h",
                "The era of AI is here, and it's transforming how we work and live. Join us at Microsoft Build to learn more.",
                null,
                2300,
                450
            ),
             Post(
                3,
                "Android Developer",
                "Official Android Account",
                R.drawable.ic_network,
                "6h",
                "Check out the new features in Android 15! Better performance, improved privacy, and more.",
                null,
                890,
                45
            )
        )

        postAdapter = PostAdapter(dummyPosts)
        feedRecyclerView.adapter = postAdapter
    }
}