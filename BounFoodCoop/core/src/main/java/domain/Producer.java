package domain;

import documents.ProducerDocument;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
public @Data class Producer extends BaseDomainObject<ProducerDocument> {

    private String name;
    private String surname;
    private String firmName;
    private String telephoneNumber;
    private String city;

    public Producer(){}

    public Producer(String name, String surname, String firmName, String telephoneNumber, String city) {
        this.Id = UUID.randomUUID();
        this.name = name;
        this.surname = surname;
        this.firmName = firmName;
        this.telephoneNumber = telephoneNumber;
        this.city = city;
        this.createdAt = new Date();
    }

    @Override
    public ProducerDocument ToDocument() {
        ProducerDocument producerDocument = new ProducerDocument();

        producerDocument.setId(this.Id);
        producerDocument.setName(this.name);
        producerDocument.setSurname(this.surname);
        producerDocument.setFirmName(this.firmName);
        producerDocument.setTelephoneNumber(this.telephoneNumber);
        producerDocument.setCity(this.city);
        producerDocument.setCreatedAt(this.createdAt);

        return producerDocument;
    }

    @Override
    public void Load(ProducerDocument producerDocument) {

        this.Id = producerDocument.getId();
        this.name = producerDocument.getName();
        this.surname = producerDocument.getSurname();
        this.firmName = producerDocument.getFirmName();
        this.telephoneNumber = producerDocument.getTelephoneNumber();
        this.city = producerDocument.getCity();
        this.createdAt = producerDocument.getCreatedAt();
    }
}
