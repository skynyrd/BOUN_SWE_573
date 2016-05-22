package com.bounfoodcoop.core.domain;

import com.bounfoodcoop.core.documents.DocumentObject;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.UUID;

public abstract class BaseDomainObject<TDocument extends DocumentObject> {
    @Id
    protected  @Getter @Setter UUID Id;
    public @Getter @Setter Date createdAt;

    abstract public TDocument ToDocument();
    abstract public void Load(TDocument document);
}
