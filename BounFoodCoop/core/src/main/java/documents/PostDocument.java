package documents;


import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Document
public @Data class PostDocument extends DocumentObject {
    private String title;
    private String content;
    @DBRef
    private List<CommentDocument> commentList;
    private int category;
}
