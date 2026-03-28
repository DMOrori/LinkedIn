package com.example.linkedin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class NetworkFragment : Fragment() {

    private lateinit var rvSuggestions: RecyclerView
    private lateinit var networkAdapter: NetworkAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_network, container, false)
        setupRecyclerView(view)
        return view
    }

    private fun setupRecyclerView(view: View) {
        rvSuggestions = view.findViewById(R.id.rvSuggestions)
        // Using GridLayoutManager with 2 columns to match LinkedIn's suggestion cards
        rvSuggestions.layoutManager = GridLayoutManager(context, 2)

        val dummySuggestions = listOf(
            NetworkItem(1, "Elon Musk", "Technoking at Tesla", R.drawable.ic_network, 45),
            NetworkItem(2, "Bill Gates", "Co-chair, Bill & Melinda Gates Foundation", R.drawable.ic_network, 120),
            NetworkItem(3, "Tim Cook", "CEO at Apple", R.drawable.ic_network, 88),
            NetworkItem(4, "Mark Zuckerberg", "CEO at Meta", R.drawable.ic_network, 30),
            NetworkItem(5, "Jeff Bezos", "Founder at Amazon", R.drawable.ic_network, 15),
            NetworkItem(6, "Sam Altman", "CEO at OpenAI", R.drawable.ic_network, 50)
        )

        networkAdapter = NetworkAdapter(dummySuggestions)
        rvSuggestions.adapter = networkAdapter
    }
}