package com.mongoDemo;


import com.mongoDemo.domain.AuthorDocument;
import com.mongoDemo.domain.PostDocument;
import com.mongoDemo.repository.IAuthorRepository;
import com.mongoDemo.repository.IPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class DBLoader {

    private IAuthorRepository authorRepository;
    private IPostRepository postRepository;

    @Autowired
    public DBLoader(IAuthorRepository authorRepository, IPostRepository postRepository){
        this.authorRepository = authorRepository;
        this.postRepository = postRepository;
    }

    @PostConstruct
    private void loadSamples(){
        PostDocument samplePost = new PostDocument();
        PostDocument samplePost2 = new PostDocument();

        authorRepository.deleteAll();
        postRepository.deleteAll();

        AuthorDocument sampleAuthor = new AuthorDocument();
        sampleAuthor.seteMail("james@hetfield.com");
        sampleAuthor.setFirstName("James");
        sampleAuthor.setLastName("Hetfield");
        sampleAuthor.setPosts(Arrays.asList(samplePost, samplePost2));

        samplePost.setId(BigInteger.valueOf(845255));
        samplePost.setBody("this is the body");
        samplePost.setPostedOn(new Date());
        samplePost.setSlug("slug");
//        samplePost.setAuthor(sampleAuthor);
        samplePost.setTitle("The Title");

        samplePost2.setId(BigInteger.valueOf(12313));
//        samplePost2.setAuthor(sampleAuthor);
        samplePost2.setBody("this is the body");
        samplePost2.setPostedOn(new Date());
        samplePost2.setSlug("slug2");
        samplePost2.setTitle("The Title 2");

        authorRepository.save(sampleAuthor);
        postRepository.save(Arrays.asList(samplePost, samplePost2));
    }
}
