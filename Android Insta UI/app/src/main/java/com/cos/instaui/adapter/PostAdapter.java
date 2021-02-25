package com.cos.instaui.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.cos.instaui.R;
import com.cos.instaui.model.Post;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.MyViewHolder> {

    private static final String TAG = "PostAdapter";
    private final List<Post> posts;
    public  PostAdapter(List<Post> posts){
        this.posts =posts;
    }

    public void addItem(Post post){
        posts.add(post);
        notifyDataSetChanged();
    }

    public void removeItem(int position){
        posts.remove(position);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: ");
        LayoutInflater inflater =(LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);   // main엑티비티에 연결할 객체를 생성해주는 인플레이터
        View view = inflater.inflate(R.layout.post_item,parent,false);
        return new MyViewHolder(view);
    }
            @Override
            public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
                holder.setItem(posts.get(position));
            }

            @Override
            public int getItemCount() {
                return posts.size();
            }

            public static class MyViewHolder extends RecyclerView.ViewHolder{

        private CircleImageView profileImg;
        private ImageView mainImg;
        private TextView nickName;
        private TextView nickName2;
        private TextView content;
        private CircleImageView fvImg;
        private TextView fvnic;
        private TextView fvComment;
        private TextView tvTime;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            profileImg = itemView.findViewById(R.id.post_profile);
            mainImg = itemView.findViewById(R.id.iv_mainImg);
            nickName = itemView.findViewById(R.id.tv_nickname);
            nickName2 = itemView.findViewById(R.id.tv_nickname2);
            content = itemView.findViewById(R.id.tv_content);
            fvImg = itemView.findViewById(R.id.favorite_Img);
            fvnic  = itemView.findViewById(R.id.favorite_nickname);
            fvComment  = itemView.findViewById(R.id.favorite_count);
            tvTime  = itemView.findViewById(R.id.tv_time);
        }
                public void setItem(Post post){
                    profileImg.setImageResource(post.getProfileImg());
                    mainImg.setImageResource(post.getMainImg());
                    nickName.setText(post.getNickname());
                    nickName2.setText(post.getNickname());
                    content.setText(post.getContent());
                    fvImg.setImageResource(post.getFavoriteImg());
                    fvnic.setText(post.getFavoriteNickname());
                    fvComment.setText(post.getFavoriteCount());
                    tvTime.setText(post.getTime());
                }
            }
}
