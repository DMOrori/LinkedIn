package com.example.linkedin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NetworkAdapter(private val items: List<NetworkItem>) :
    RecyclerView.Adapter<NetworkAdapter.NetworkViewHolder>() {

    class NetworkViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivProfile: ImageView = itemView.findViewById(R.id.ivProfile)
        val tvName: TextView = itemView.findViewById(R.id.tvName)
        val tvHeadline: TextView = itemView.findViewById(R.id.tvHeadline)
        val tvMutual: TextView = itemView.findViewById(R.id.tvMutual)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NetworkViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_network_card, parent, false)
        return NetworkViewHolder(view)
    }

    override fun onBindViewHolder(holder: NetworkViewHolder, position: Int) {
        val item = items[position]
        holder.tvName.text = item.name
        holder.tvHeadline.text = item.headline
        holder.tvMutual.text = "${item.mutualConnections} mutual connections"
        holder.ivProfile.setImageResource(item.profilePic)
    }

    override fun getItemCount() = items.size
}