package app.services.data;


import app.dto.OrderDto;
import app.dto.ProductDto;
import app.model.Order;
import app.model.OrderProduct;
import app.model.Product;
import app.model.ProductType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public interface ProductTestData {

    ProductDto PRODUCT_DTO_1 = new ProductDto(1L, ProductType.PRODUCT, "Product1", BigDecimal.valueOf(100));
    ProductDto PRODUCT_DTO_2 = new ProductDto(2L, ProductType.PRODUCT, "Product2", BigDecimal.valueOf(100));
    List<ProductDto> PRODUCT_DTO_LIST = Arrays.asList(PRODUCT_DTO_1, PRODUCT_DTO_2);

    Product PRODUCT_1 = new Product(ProductType.PRODUCT, "Product1", BigDecimal.valueOf(100));
    Product PRODUCT_2 = new Product(ProductType.PRODUCT, "Product2", BigDecimal.valueOf(100));
    List<Product> PRODUCT_LIST = Arrays.asList(PRODUCT_1, PRODUCT_2);

    ProductDto PRODUCT_DTO_1_UPDATE = new ProductDto(1L, ProductType.PRODUCT, "Product999", BigDecimal.valueOf(100));
    Product PRODUCT_1_UPDATE = new Product(ProductType.PRODUCT, "Product999", BigDecimal.valueOf(100));








}
