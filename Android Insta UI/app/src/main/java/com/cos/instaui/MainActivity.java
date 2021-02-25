package com.cos.instaui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.cos.instaui.adapter.PostAdapter;
import com.cos.instaui.adapter.StoryAdapter;
import com.cos.instaui.model.Post;
import com.cos.instaui.model.Story;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvPostList,rvStoryList;
    private PostAdapter postAdapter;
    private StoryAdapter storyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        List<Story> stories = new ArrayList<>();
        for(int i=1;i<5;i++) {
            stories.add(new Story(i,"wlgus2qh",R.drawable.wlgus));
            stories.add(new Story(i,"hacksu",R.drawable.a));
            stories.add(new Story(i,"machine",R.drawable.a2));
            stories.add(new Story(i,"dideogus",R.drawable.a3));
            stories.add(new Story(i,"kimjjeong",R.drawable.a4));
            stories.add(new Story(i,"wooooony",R.drawable.a5));
            stories.add(new Story(i,"rarar1234",R.drawable.a6));
            stories.add(new Story(i,"heechan001",R.drawable.a7));
        }

        LinearLayoutManager manager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        rvStoryList = findViewById(R.id.rv_stotylist);
        rvStoryList .setLayoutManager(manager);
        storyAdapter = new StoryAdapter(stories);
        rvStoryList.setAdapter(storyAdapter);


        List<Post> posts = new ArrayList<>();
            posts.add(new Post(1,R.drawable.wlgus,R.drawable.wlgus2,"wlgus2qh","#치어리더 #안지현 #롯데 #롯데자이언츠",
                    R.drawable.a5,"dideogus","2826명","2시간 전"));

            posts.add(new Post(2,R.drawable.a,R.drawable.a3,"hacksu","#심심",
                    R.drawable.a6,"rarar1234","10명","5시간 전"));

            posts.add(new Post(3,R.drawable.a2,R.drawable.a4,"machine","#나른하다...",
                    R.drawable.a7,"heechan001","182명","8시간 전"));

        LinearLayoutManager manager2 = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        rvPostList = findViewById(R.id.rv_postlist);
        rvPostList .setLayoutManager(manager2);
        postAdapter = new PostAdapter(posts);
        rvPostList.setAdapter(postAdapter);
    }
}