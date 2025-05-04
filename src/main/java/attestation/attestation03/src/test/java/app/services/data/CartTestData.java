package app.services.data;

import app.dto.CartProductDto;
import app.dto.CartProductDtoCreate;
import app.dto.OrderDto;
import app.model.CartProduct;
import app.model.Order;
import app.model.OrderProduct;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public interface CartTestData {

    CartProductDto CART_PRODUCT_DTO_1 = new CartProductDto(1L, ProductTestData.PRODUCT_DTO_1, 9);
    CartProductDto CART_PRODUCT_DTO_2 = new CartProductDto(1L, ProductTestData.PRODUCT_DTO_2, 9);
    List<CartProductDto> CART_PRODUCT_DTO_LIST = Arrays.asList(CART_PRODUCT_DTO_1, CART_PRODUCT_DTO_2);
    CartProductDto CART_PRODUCT_DTO_1_UPDATE = new CartProductDto(1L, ProductTestData.PRODUCT_DTO_2, 999);
    CartProductDtoCreate CART_PRODUCT_DTO_CREATE_1 = new CartProductDtoCreate(1L, 1L, 9);
    CartProduct CART_PRODUCT_1 = new CartProduct(1L, ProductTestData.PRODUCT_1,  9);
    CartProduct CART_PRODUCT_2 = new CartProduct(1L, ProductTestData.PRODUCT_2,9);
    List<CartProduct> CART_PRODUCT_LIST = Arrays.asList(CART_PRODUCT_1, CART_PRODUCT_2);
    CartProduct CART_PRODUCT_1_UPDATE = new CartProduct(1L, ProductTestData.PRODUCT_1,  999);
    CartProduct CART_PRODUCT_CREATE_1 = new CartProduct(1L, ProductTestData.PRODUCT_1, 999);






}
