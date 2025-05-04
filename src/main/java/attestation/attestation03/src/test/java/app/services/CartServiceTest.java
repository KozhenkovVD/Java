package app.services;

import app.dto.CartProductDto;
import app.exception.NotFoundException;
import app.mapper.CartProductMapper;
import app.model.CartProduct;
import app.repository.CartProductRepository;
import app.services.data.CartTestData;
import app.services.data.ProductTestData;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import static org.mockito.Mockito.*;

@SpringBootTest(classes = {CartService.class})
class CartServiceTest {
    @MockitoBean
    CartProductMapper cartProductMapper;
    @MockitoBean
    CartProductRepository cartProductRepository;
    @MockitoBean
    ProductService productService;
    @MockitoBean
    ObjectMapper objectMapper;
    @Autowired
    CartService cartService;

    @Test
    void getByCustomerId() {
        when(cartProductRepository.findByCustomerId(1L)).thenReturn(CartTestData.CART_PRODUCT_LIST);
        when(cartProductMapper.toDtoList(CartTestData.CART_PRODUCT_LIST)).thenReturn(CartTestData.CART_PRODUCT_DTO_LIST);
        List<CartProductDto> result = cartService.getByCustomerId(1L);
        Assertions.assertEquals(CartTestData.CART_PRODUCT_DTO_LIST, result);
    }

    @Test
    void getOne() {
        CartProduct cartProduct = CartTestData.CART_PRODUCT_1;
        cartProduct.setId(1L);
        Mockito.when(cartProductRepository.findById(1L)).thenReturn(Optional.of(cartProduct));
        Mockito.when(cartProductMapper.toDto(cartProduct)).thenReturn(CartTestData.CART_PRODUCT_DTO_1);
        CartProductDto result = cartService.getOne(1L);
        assertEquals(CartTestData.CART_PRODUCT_DTO_1, result);
        assertNotEquals(CartTestData.CART_PRODUCT_DTO_2, result);
    }

    @Test
    void getOneException() throws NotFoundException{
        RuntimeException exception = Assertions.assertThrows(
                RuntimeException.class,
                () -> cartService.getOne(1L));
        assertEquals(exception.getMessage(), "Товар с id `1` не найден");
    }

    @Test
    void create() {
        Mockito.when(productService.getOne(1L)).thenReturn(ProductTestData.PRODUCT_DTO_1);
        Mockito.when(cartProductMapper.toEntity(CartTestData.CART_PRODUCT_DTO_1)).thenReturn(CartTestData.CART_PRODUCT_1);
        Mockito.when(cartProductRepository.save(CartTestData.CART_PRODUCT_1)).thenReturn(CartTestData.CART_PRODUCT_CREATE_1);
        Mockito.when(cartProductMapper.toDto(CartTestData.CART_PRODUCT_CREATE_1)).thenReturn(CartTestData.CART_PRODUCT_DTO_1);
        CartProductDto result = cartService.create(1L, CartTestData.CART_PRODUCT_DTO_CREATE_1);
        assertEquals(CartTestData.CART_PRODUCT_DTO_1, result);
    }
    @Test
    void update() {
        CartProduct cartProduct = CartTestData.CART_PRODUCT_1;
        cartProduct.setId(1L);
        Mockito.when(cartProductRepository.findById(1L)).thenReturn(Optional.of(cartProduct));
        Mockito.when(cartProductMapper.toDto(cartProduct)).thenReturn(CartTestData.CART_PRODUCT_DTO_1_UPDATE);
        Mockito.when(cartProductRepository.save(cartProduct)).thenReturn(cartProduct);
        CartProductDto result = cartService.update(1L, CartTestData.CART_PRODUCT_DTO_1_UPDATE);
        assertEquals(CartTestData.CART_PRODUCT_DTO_1_UPDATE.getQuantity(), result.getQuantity());
    }
    @Test
    void updateException() throws NotFoundException{
        RuntimeException exception = Assertions.assertThrows(
                RuntimeException.class,
                () -> cartService.update(1L, CartTestData.CART_PRODUCT_DTO_1_UPDATE));
        assertEquals(exception.getMessage(), "Товар с id `1` не найден");
    }

    @Test
    void delete() throws NotFoundException {
        CartProduct cartProduct  = CartTestData.CART_PRODUCT_1;
        Mockito.when(cartProductRepository.findById(1L)).thenReturn(Optional.of(cartProduct));
        Mockito.when(cartProductRepository.save(cartProduct)).thenReturn(cartProduct);
        String result = cartService.delete(1L);
        assertEquals("Товар удален", result);
    }

    @Test
    void deleteException() throws NotFoundException{
        RuntimeException exception = Assertions.assertThrows(
                RuntimeException.class,
                () -> cartService.delete(1L));
        assertEquals(exception.getMessage(), "Товар с id `1` не найден");
    }

}
