package representation;


import domain.Product;
import lombok.Getter;
import lombok.Setter;

import java.text.Format;
import java.text.SimpleDateFormat;

public class ProductRepresentation {

    public @Getter @Setter String id;
    public @Getter @Setter String name;
    public @Getter @Setter int category;
    public @Getter @Setter String description;
    public @Getter @Setter double price;
    public @Getter @Setter int unit;
    public @Getter @Setter ProducerRepresentation producer;
    public @Getter @Setter int unitInStock;
    public @Getter @Setter int status;
    public @Getter @Setter String city;
    public @Getter @Setter String createdAt;

    public ProductRepresentation() {
    }

    public ProductRepresentation(Product product){
        this.id = product.getId().toString();
        this.name = product.getName();
        this.category = product.getCategory().ordinal();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.unit = product.getUnit().ordinal();
        this.producer = new ProducerRepresentation(product.getProducer());
        this.unitInStock = product.getUnitInStock();
        this.status = product.getStatus().ordinal();
        this.city = product.getCity();

        Format formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        this.setCreatedAt(formatter.format(product.getCreatedAt()));
    }
}
