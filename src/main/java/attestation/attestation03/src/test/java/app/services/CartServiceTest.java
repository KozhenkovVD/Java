package app.services;

import app.dto.CartProductDto;
import app.dto.CartProductDtoCreate;
import app.dto.ProductDto;
import app.mapper.CartProductMapper;
import app.model.CartProduct;
import app.model.ProductType;
import app.repository.CartProductRepository;
import app.services.data.CartProductTestData;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.math.BigDecimal;
import java.util.List;

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
        when(cartProductRepository.findByCustomerId(1L)).thenReturn(CartProductTestData.CART_PRODUCT_LIST);
        when(cartProductMapper.toDtoList(CartProductTestData.CART_PRODUCT_LIST)).thenReturn(CartProductTestData.CART_PRODUCT_DTO_LIST);
        List<CartProductDto> result = cartService.getByCustomerId(1L);
        Assertions.assertEquals(CartProductTestData.CART_PRODUCT_DTO_LIST, result);
    }

//    @Test
//    void getOne() {
//        when(cartProductListMapper.toCartProductListDto(any(CartProduct.class))).thenReturn(new CartProductDto(Long.valueOf(1), new ProductDto(Long.valueOf(1), ProductType.SERVICE, "name", new BigDecimal(0)), Integer.valueOf(0)));
//        when(cartProductRepository.findById(any(ID.class))).thenReturn(null);
//
//        CartProductDto result = cartService.getOne(Long.valueOf(1));
//        Assertions.assertEquals(new CartProductDto(Long.valueOf(1), new ProductDto(Long.valueOf(1), ProductType.SERVICE, "name", new BigDecimal(0)), Integer.valueOf(0)), result);
//    }
//
//    @Test
//    void create() {
//        when(cartProductListMapper.toEntity(any(CartProductDto.class))).thenReturn(new CartProduct(Long.valueOf(1), null, Integer.valueOf(0)));
//        when(cartProductListMapper.toCartProductListDto(any(CartProduct.class))).thenReturn(new CartProductDto(Long.valueOf(1), new ProductDto(Long.valueOf(1), ProductType.SERVICE, "name", new BigDecimal(0)), Integer.valueOf(0)));
//        when(cartProductRepository.save(any(S.class))).thenReturn(new S());
//        when(productService.getOne(anyLong())).thenReturn(new ProductDto(Long.valueOf(1), ProductType.SERVICE, "name", new BigDecimal(0)));
//
//        CartProductDto result = cartService.create(Long.valueOf(1), new CartProductDtoCreate(Long.valueOf(1), Long.valueOf(1), Integer.valueOf(0)));
//        Assertions.assertEquals(new CartProductDto(Long.valueOf(1), new ProductDto(Long.valueOf(1), ProductType.SERVICE, "name", new BigDecimal(0)), Integer.valueOf(0)), result);
//    }
//
//    @Test
//    void patch() {
//        when(cartProductListMapper.toCartProductListDto(any(CartProduct.class))).thenReturn(new CartProductDto(Long.valueOf(1), new ProductDto(Long.valueOf(1), ProductType.SERVICE, "name", new BigDecimal(0)), Integer.valueOf(0)));
//        when(cartProductListMapper.updateWithNull(any(CartProductDto.class), any(CartProduct.class))).thenReturn(new CartProduct(Long.valueOf(1), null, Integer.valueOf(0)));
//        when(cartProductRepository.save(any(S.class))).thenReturn(new S());
//        when(cartProductRepository.findById(any(ID.class))).thenReturn(null);
//        when(objectMapper.readerForUpdating(any(Object.class))).thenReturn(new ObjectReader());
//
//        CartProductDto result = cartService.patch(Long.valueOf(1), null);
//        Assertions.assertEquals(new CartProductDto(Long.valueOf(1), new ProductDto(Long.valueOf(1), ProductType.SERVICE, "name", new BigDecimal(0)), Integer.valueOf(0)), result);
//    }
//
//    @Test
//    void delete() {
//        when(cartProductListMapper.toCartProductListDto(any(CartProduct.class))).thenReturn(new CartProductDto(Long.valueOf(1), new ProductDto(Long.valueOf(1), ProductType.SERVICE, "name", new BigDecimal(0)), Integer.valueOf(0)));
//        when(cartProductRepository.findById(any(ID.class))).thenReturn(null);
//
//        CartProductDto result = cartService.delete(Long.valueOf(1));
//        verify(cartProductRepository).delete(any(T.class));
//        Assertions.assertEquals(new CartProductDto(Long.valueOf(1), new ProductDto(Long.valueOf(1), ProductType.SERVICE, "name", new BigDecimal(0)), Integer.valueOf(0)), result);
//    }
}
