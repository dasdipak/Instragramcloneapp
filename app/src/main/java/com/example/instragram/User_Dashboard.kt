package com.example.instragram

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.instragram.adapter.postadapter
import com.example.instragram.adapter.storyadapter
import com.example.instragram.model.Postclass
import com.example.instragram.model.Storyclass
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.*

class User_Dashboard : AppCompatActivity() {

    private lateinit var fullName: TextView;
    private lateinit var circularPost: RecyclerView;
    private lateinit var circularStory: RecyclerView;
    private lateinit var btnAddPost: FloatingActionButton;
    private lateinit var fabAddStory: FloatingActionButton;

    private val lstPost = arrayListOf<Postclass>();
    private val lstStory = arrayListOf<Storyclass>();
    var url: String = "";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user__dashboard)

        fullName = findViewById(R.id.fullname);
        circularPost = findViewById(R.id.recyclerViewPost);
        circularStory = findViewById(R.id.recyclerViewStroy);
        btnAddPost = findViewById(R.id.btnAddPost);
        fabAddStory = findViewById(R.id.fabAddStory);

        val intent = intent;
        if (intent.extras != null) {
            fullName.text = "Welcome " + intent.getStringExtra("fullname").toString();

        }

        //Post Adapter
        val adapter = postadapter(this, lstPost);
        circularPost.layoutManager = LinearLayoutManager(this@User_Dashboard);
        circularPost.adapter = adapter;

        //Story Adapter
        val adapterStory = storyadapter(this, lstStory);
        var storyLayout = LinearLayoutManager(this@User_Dashboard);
        storyLayout.orientation = LinearLayoutManager.HORIZONTAL;
        circularStory.layoutManager = storyLayout;
        circularStory.adapter = adapterStory;




        btnAddPost.setOnClickListener {
            startActivityForResult(Intent(this, post_activity::class.java), 1);
        }

        fabAddStory.setOnClickListener {
            startActivityForResult(Intent(this, story_activity::class.java), 2);
        }



    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                url = data?.getStringExtra("url").toString();
                lstPost.add(
                    Postclass(
                        url
                        , Date()
                    )
                );
            }
        } else if (requestCode == 2) {
            if (resultCode == Activity.RESULT_OK) {
                url = data?.getStringExtra("url").toString();
                lstStory.add(Storyclass(url));
            }
        }
    }

}