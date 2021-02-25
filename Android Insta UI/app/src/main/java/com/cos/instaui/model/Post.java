package com.cos.instaui.model;

import android.content.Intent;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Post {
    private Integer id;
    private Integer profileImg;
    private Integer mainImg;
    private String nickname;
    private String content;
    private Integer favoriteImg;
    private String favoriteNickname;
    private String favoriteCount;
    private String Time;
}
