package domain;

import documents.CommentDocument;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
public @Data
class Comment extends BaseDomainObject<CommentDocument>{
    private String title;
    private String content;
    private String user;

    public Comment(){}

    public Comment(String title, String content, String user) {
        this.Id = UUID.randomUUID();
        this.title = title;
        this.content = content;
        this.user = user;
        this.createdAt = new Date();
    }

    @Override
    public CommentDocument ToDocument() {
        CommentDocument commentDocument = new CommentDocument();
        commentDocument.setId(this.Id);
        commentDocument.setTitle(this.title);
        commentDocument.setContent(this.content);
        commentDocument.setUser(this.user);
        commentDocument.setCreatedAt(this.createdAt);
        return commentDocument;
    }

    @Override
    public void Load(CommentDocument commentDocument) {
        this.Id = commentDocument.getId();
        this.title = commentDocument.getTitle();
        this.content = commentDocument.getContent();
        this.user = commentDocument.getUser();
        this.createdAt = commentDocument.getCreatedAt();
    }
}
