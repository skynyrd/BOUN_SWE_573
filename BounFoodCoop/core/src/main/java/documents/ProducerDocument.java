package documents;


import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public @Data class ProducerDocument extends DocumentObject {
    private String name;
    private String surname;
    private String firmName;
    private String telephoneNumber;
    private String city;
}
