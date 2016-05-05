package com.bounfoodcoop.repository.documents;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;


import java.util.Date;
import java.util.UUID;


abstract public class DocumentObject {
    @Getter @Setter @Id public UUID id;
    @Getter @Setter public Date createdAt;
}
