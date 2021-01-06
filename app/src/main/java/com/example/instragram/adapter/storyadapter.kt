package com.example.instragram.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.instragram.R
import com.example.instragram.model.Storyclass
import de.hdodenhof.circleimageview.CircleImageView

class storyadapter(val context: Context, val lstStory: ArrayList<Storyclass>) :
    RecyclerView.Adapter<storyadapter.StoryViewHolder>()  {

    class StoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        //        val fullName: TextView
        val imgStory: CircleImageView

        init {
//            fullName = view.findViewById(R.id.tvStoryFullname);
            imgStory = view.findViewById(R.id.imgStory);
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryViewHolder {
        val storyView =
            LayoutInflater.from(this.context).inflate(R.layout.story_layout, parent, false);
        return StoryViewHolder(view = storyView);
    }

    override fun getItemCount(): Int {
        return lstStory.size;
    }

    override fun onBindViewHolder(holder: StoryViewHolder, position: Int) {
        val storyclass = lstStory[position];
//        holder.fullName.text = story.username.toString()

        Glide.with(context).load(storyclass.storyImage).into(holder.imgStory);
    }

}