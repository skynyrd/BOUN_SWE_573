package com.mongoDemo.service;

import com.mongoDemo.domain.PostDocument;
import com.mongoDemo.repository.IPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private IPostRepository postRepository;

    @Autowired
    public PostService(IPostRepository postRepository){
        this.postRepository = postRepository;
    }

    public PostDocument getLatestPost(){
        return postRepository.findFirstByOrderByPostedOnDesc();
    }

    public List<PostDocument> list() {
        return postRepository.findAllByOrderByPostedOnDesc();
    }

    public PostDocument getBySlug(String slug) {
        return postRepository.findBySlug(slug);
    }
}