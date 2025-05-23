package app.mapper;

import app.dto.CartProductDto;
import app.dto.OrderDto;
import app.model.CartProduct;
import app.model.Order;
import app.services.data.CartTestData;
import app.services.data.OrderTestData;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = {CartProductMapperImpl.class})
class CartMapperTest {

@Autowired
private CartProductMapper cartProductMapper;


    @Test
    void toEntity() {
        CartProduct cartProductExpected = CartTestData.CART_PRODUCT_1;
        CartProduct cartProduct = cartProductMapper.toEntity(CartTestData.CART_PRODUCT_DTO_1);
        assertEquals(cartProductExpected.getCustomerId(),cartProduct.getCustomerId());
    }

    @Test
    void toDto() {
        CartProductDto cartProductDtoExpected = CartTestData.CART_PRODUCT_DTO_1;
        CartProductDto cartProductDto = cartProductMapper.toDto(CartTestData.CART_PRODUCT_1);
        assertEquals(cartProductDtoExpected.getCustomerId(),cartProductDto.getCustomerId());
    }

    @Test
    void toDtoList() {
        List<CartProductDto> cartProductDtoListExpected = CartTestData.CART_PRODUCT_DTO_LIST;
        List<CartProductDto>  cartProductDtoList = cartProductMapper.toDtoList(CartTestData.CART_PRODUCT_LIST);
        assertEquals(cartProductDtoListExpected.size(),cartProductDtoList.size());
    }
}