package com.bounfoodcoop.domain;


import com.bounfoodcoop.repository.documents.PostDocument;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@EqualsAndHashCode(callSuper = true)
public @Data class Post extends BaseDomainObject<PostDocument> {
    private String title;
    private String content;
    private List<Comment> commentList;
    private PostCategory category;

    public Post(){}

    public Post(String title, String content, List<Comment> commentList, PostCategory category) {
        this.Id = UUID.randomUUID();
        this.title = title;
        this.content = content;
        this.commentList = commentList;
        this.category = category;
        this.createdAt = new Date();
    }

    @Override
    public PostDocument ToDocument() {
        PostDocument postDocument = new PostDocument();
        postDocument.setId(this.Id);
        postDocument.setTitle(this.title);
        postDocument.setContent(this.content);
        postDocument.setCreatedAt(this.createdAt);
        postDocument.setCommentList(
                commentList.stream().map(Comment::ToDocument).collect(Collectors.toList()));
        postDocument.setCategory(this.category.getValue());

        return postDocument;
    }

    @Override
    public void Load(PostDocument postDocument) {
        this.title = postDocument.getTitle();
        this.content = postDocument.getContent();
        this.createdAt = postDocument.getCreatedAt();
        this.commentList = postDocument.getCommentList().stream().map(cd -> {
            Comment comment = new Comment();
            comment.Load(cd);
            return comment;
        }).collect(Collectors.toList());
    }
}
