package com.example.instragram.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.instragram.R
import com.example.instragram.model.Postclass

class postadapter(val context: Context, val lstPost: ArrayList<Postclass>) :
    RecyclerView.Adapter<postadapter.PostViewHolder>() {

    class PostViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val postImage: ImageView
        val postDate: TextView
//        val postedBy: TextView

        init {
            postImage = view.findViewById(R.id.imgPost);
            postDate = view.findViewById(R.id.tvPostedOn);
//            postedBy = view.findViewById(R.id.tvPostedBy);

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {

        val postView =
            LayoutInflater.from(this.context).inflate(R.layout.post_layout, parent, false);
        return PostViewHolder(view = postView);
    }

    override fun getItemCount(): Int {
        return lstPost.size;
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = lstPost[position];
        holder.postDate.text = post.postDate.toString()
//        holder.postedBy.text = post.postedBy.toString();

        Glide.with(context).load(post.postImage).into(holder.postImage)
    }

    }