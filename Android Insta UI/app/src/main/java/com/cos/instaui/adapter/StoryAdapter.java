package com.cos.instaui.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.cos.instaui.R;
import com.cos.instaui.model.Post;
import com.cos.instaui.model.Story;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.MyViewHolder> {

    private static final String TAG = "StoryAdapter";
    private final List<Story> stories;

    public  StoryAdapter(List<Story> stories){
        this.stories =stories;
    }

    public void addItem(Story story){
        stories.add(story);
        notifyDataSetChanged();
    }

    public void removeItem(int position){
        stories.remove(position);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: ");
        LayoutInflater inflater =(LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);   // main엑티비티에 연결할 객체를 생성해주는 인플레이터
        View view = inflater.inflate(R.layout.stoty_item,parent,false);
        return new MyViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.setItem(stories.get(position));
    }

    @Override
    public int getItemCount() {
        return stories.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private CircleImageView profileImg;
        private TextView storyNickName;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            profileImg = itemView.findViewById(R.id.story_profile);
            storyNickName = itemView.findViewById(R.id.story_nickname);
        }
        public void setItem(Story story){
            profileImg.setImageResource(story.getPic());
            storyNickName.setText(story.getNickname());
        }
    }
}
