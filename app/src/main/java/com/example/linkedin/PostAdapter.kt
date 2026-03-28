package com.example.linkedin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PostAdapter(private val posts: List<Post>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val TYPE_HEADER = 0
        private const val TYPE_POST = 1
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) TYPE_HEADER else TYPE_POST
    }

    class HeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Handle clicks on "Start a post" if needed
    }

    class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivProfile: ImageView = itemView.findViewById(R.id.ivProfile)
        val tvAuthorName: TextView = itemView.findViewById(R.id.tvAuthorName)
        val tvAuthorHeadline: TextView = itemView.findViewById(R.id.tvAuthorHeadline)
        val tvTimeAgo: TextView = itemView.findViewById(R.id.tvTimeAgo)
        val tvContent: TextView = itemView.findViewById(R.id.tvContent)
        val ivPostImage: ImageView = itemView.findViewById(R.id.ivPostImage)
        val btnLike: TextView = itemView.findViewById(R.id.btnLike)
        val btnComment: TextView = itemView.findViewById(R.id.btnComment)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == TYPE_HEADER) {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_start_post, parent, false)
            HeaderViewHolder(view)
        } else {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_post, parent, false)
            PostViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is PostViewHolder) {
            val post = posts[position - 1] // -1 because of header
            holder.tvAuthorName.text = post.authorName
            holder.tvAuthorHeadline.text = post.authorHeadline
            holder.tvTimeAgo.text = post.timeAgo
            holder.tvContent.text = post.content
            holder.ivProfile.setImageResource(post.authorProfilePic)

            if (post.postImage != null) {
                holder.ivPostImage.visibility = View.VISIBLE
                holder.ivPostImage.setImageResource(post.postImage)
            } else {
                holder.ivPostImage.visibility = View.GONE
            }

            holder.btnLike.text = "Like (${post.likesCount})"
            holder.btnComment.text = "Comment (${post.commentsCount})"
        }
    }

    override fun getItemCount() = posts.size + 1 // +1 for header
}