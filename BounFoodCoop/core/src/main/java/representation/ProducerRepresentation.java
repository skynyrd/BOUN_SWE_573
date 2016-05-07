package representation;


import domain.Producer;
import lombok.Getter;
import lombok.Setter;

public class ProducerRepresentation {

    public @Getter @Setter String id;
    public @Getter @Setter String name;
    public @Getter @Setter String surname;
    public @Getter @Setter String firmName;
    public @Getter @Setter String telephoneNumber;
    public @Getter @Setter String city;

    public ProducerRepresentation(Producer producer){
        this.id = producer.getId().toString();
        this.name = producer.getName();
        this.city = producer.getCity();
        this.surname = producer.getSurname();
        this.firmName = producer.getFirmName();
        this.telephoneNumber = producer.getTelephoneNumber();
    }
}
