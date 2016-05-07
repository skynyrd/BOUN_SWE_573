package representation;

import domain.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

public class ProductListRepresentation {
    public @Getter @Setter List<ProductRepresentation> productRepresentationList;

    public ProductListRepresentation(List<Product> productList){
        this.productRepresentationList = productList
            .stream().map(ProductRepresentation::new)
            .collect(Collectors.toList());
    }
}
