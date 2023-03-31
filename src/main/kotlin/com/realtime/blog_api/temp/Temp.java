//package com.realtime.blog_api.temp;
//
//import com.realtime.blog_api.entities.Post;
//import jakarta.persistence.CascadeType;
//import jakarta.persistence.OneToMany;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class Temp{
//
//    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
//    List<Post> posts = new ArrayList<Post>();
//
//}