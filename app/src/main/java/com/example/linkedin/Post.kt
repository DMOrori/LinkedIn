package com.example.linkedin

data class Post(
    val id: Int,
    val authorName: String,
    val authorHeadline: String,
    val authorProfilePic: Int, // Drawable resource ID for now
    val timeAgo: String,
    val content: String,
    val postImage: Int? = null, // Optional post image
    val likesCount: Int,
    val commentsCount: Int
)