package com.bounfoodcoop.domain;

import com.bounfoodcoop.repository.documents.DocumentObject;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.UUID;

public abstract class BaseDomainObject<TDocument extends DocumentObject> {
    @Id
    protected  @Getter @Setter UUID Id;

    abstract public TDocument ToDocument();
    abstract public void Load(TDocument document);
}
