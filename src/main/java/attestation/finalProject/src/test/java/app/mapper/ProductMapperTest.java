package app.mapper;

import app.dto.ProductDto;
import app.model.Product;
import app.services.ProductService;
import app.services.data.ProductTestData;
import ch.qos.logback.classic.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = {ProductMapperImpl.class})
class ProductMapperTest {

@Autowired
private ProductMapper productMapper;


    @Test
    void toEntity() {
        Product productExpected = ProductTestData.PRODUCT_1;
        Product product = productMapper.toEntity(ProductTestData.PRODUCT_DTO_1);
        assertEquals(productExpected.getName(),product.getName());
    }

    @Test
    void toDto() {
        ProductDto productDtoExpected = ProductTestData.PRODUCT_DTO_1;
        ProductDto productDto = productMapper.toDto(ProductTestData.PRODUCT_1);
        assertEquals(productDtoExpected.getName(),productDto.getName());
    }

    @Test
    void updateWithNull() {
    }

    @Test
    void toDtoList() {
        List<ProductDto> productDtoListExpected = ProductTestData.PRODUCT_DTO_LIST;
        List<ProductDto>  productDtoList = productMapper.toDtoList(ProductTestData.PRODUCT_LIST);
        assertEquals(productDtoListExpected.size(),productDtoList.size());
    }
}