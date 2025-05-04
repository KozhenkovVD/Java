package app.services;


import app.dto.ProductDto;
import app.exception.NotFoundException;
import app.mapper.ProductMapper;
import app.model.Product;
import app.repository.ProductRepository;
import app.services.data.ProductTestData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest(classes = {ProductService.class})
class ProductServiceTest {
    @MockitoBean
    private ProductMapper productMapper;
    @MockitoBean
    private ProductRepository productRepository;

    @Autowired
    ProductService productService;

    @Test
    void getAll() {
        Mockito.when(productRepository.findAll()).thenReturn(ProductTestData.PRODUCT_LIST);
        Mockito.when(productMapper.toDtoList(ProductTestData.PRODUCT_LIST)).thenReturn(ProductTestData.PRODUCT_DTO_LIST);
        List<ProductDto> result = productService.getAll();
        assertEquals(ProductTestData.PRODUCT_DTO_LIST, result);

    }

    @Test
    void getOne() {
        Product product = ProductTestData.PRODUCT_1;
        product.setId(1L);
        Mockito.when(productRepository.findById(1L)).thenReturn(Optional.of(product));
        Mockito.when(productMapper.toDto(product)).thenReturn(ProductTestData.PRODUCT_DTO_1);
        ProductDto result = productService.getOne(1L);
        assertEquals(ProductTestData.PRODUCT_DTO_1, result);
        assertNotEquals(ProductTestData.PRODUCT_DTO_2, result);
    }
    @Test
    void getOneException() throws NotFoundException {
        //Product product = ProductTestData.PRODUCT_1;
        RuntimeException exception = Assertions.assertThrows(
                RuntimeException.class,
                () -> productService.getOne(1L));
        assertEquals(exception.getMessage(), "Продукт с id `1` не найден");


    }

    @Test
    void create() {
        Mockito.when(productMapper.toEntity(ProductTestData.PRODUCT_DTO_1)).thenReturn(ProductTestData.PRODUCT_1);
        Mockito.when(productRepository.save(ProductTestData.PRODUCT_1)).thenReturn(ProductTestData.PRODUCT_1);
        Mockito.when(productMapper.toDto(ProductTestData.PRODUCT_1)).thenReturn(ProductTestData.PRODUCT_DTO_1);
        ProductDto result = productService.create(ProductTestData.PRODUCT_DTO_1);
        assertEquals(ProductTestData.PRODUCT_DTO_1, result);
    }

    @Test
    void update() throws NotFoundException {
        Product product = ProductTestData.PRODUCT_1;
        Mockito.when(productRepository.findById(1L)).thenReturn(Optional.of(product));
        Mockito.when(productMapper.toDto(product)).thenReturn(ProductTestData.PRODUCT_DTO_1);
        Mockito.when(productRepository.save(product)).thenReturn(ProductTestData.PRODUCT_1_UPDATE);
        Mockito.when(productMapper.toDto(ProductTestData.PRODUCT_1_UPDATE)).thenReturn(ProductTestData.PRODUCT_DTO_1_UPDATE);
        ProductDto result = productService.update(1L, ProductTestData.PRODUCT_DTO_1_UPDATE);
        assertEquals(ProductTestData.PRODUCT_DTO_1_UPDATE.getName(), result.getName());
    }

    @Test
    void updateException() throws NotFoundException{
        Product product = ProductTestData.PRODUCT_1;
        RuntimeException exception = Assertions.assertThrows(
                RuntimeException.class,
                () -> productService.update(1L, ProductTestData.PRODUCT_DTO_1_UPDATE));
        assertEquals(exception.getMessage(), "Продукт с id `1` не найден");


    }

    @Test
    void delete() throws NotFoundException{
        Product product = ProductTestData.PRODUCT_1;
        product.setId(1L);
        Product productDelete = product;
        productDelete.setDeleted(true);
        Mockito.when(productRepository.findById(1L)).thenReturn(Optional.of(product));
        Mockito.when(productRepository.save(product)).thenReturn(productDelete);
        String result = productService.delete(1L);
        assertEquals("Продукт удален", result);
    }

    @Test
    void deleteException() throws NotFoundException{
        Product product = ProductTestData.PRODUCT_1;
        RuntimeException exception = Assertions.assertThrows(
                RuntimeException.class,
                () -> productService.delete(product.getId()));
        assertEquals(exception.getMessage(), "Продукт с id `null` не найден");


    }
}