package com.mongoDemo.controller;

import com.mongoDemo.domain.PostDocument;
import com.mongoDemo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    private PostService postService;

    @Autowired
    public PostController(PostService postService){
        this.postService = postService;
    }

    @RequestMapping("/list")
    public List<PostDocument> listPosts(){
        return postService.list();
    }

    @RequestMapping("/slug/{slug}")
    public PostDocument view(@PathVariable(value="slug") String slug){
        return postService.getBySlug(slug);
    }
}