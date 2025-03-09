package homeworks.homework14;

import java.util.Arrays;
import java.util.List;

public class ProductService {
    public List<Product> convertStringToProduct(String line) {
        return Arrays.stream(line.split(";"))
                .map(e -> {
                    String[] elements = e.split("=");
                    return new Product(elements[0].trim(),Integer.parseInt(elements[1].trim()));
                })
                .toList();
    }
}


