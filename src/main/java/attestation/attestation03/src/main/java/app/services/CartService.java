package app.services;

import app.dto.CartProductDto;
import app.dto.CartProductDtoCreate;
import app.mapper.CartProductListMapper;
import app.model.CartProduct;
import app.repository.CartProductRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CartService {

    private final CartProductListMapper cartProductListMapper;

    private final CartProductRepository cartProductRepository;

    private final ProductService productService;

    private final ObjectMapper objectMapper;

    public List<CartProductDto> getByCustomerId(Long customerId) {
        List<CartProduct> cartProductLists = cartProductRepository.findByCustomerId(customerId);
        return cartProductLists.stream()
                .map(cartProductListMapper::toCartProductListDto)
                .toList();
    }

    public CartProductDto getOne(Long id) {
        Optional<CartProduct> cartProductListOptional = cartProductRepository.findById(id);
        return cartProductListMapper.toCartProductListDto(cartProductListOptional.orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity with id `%s` not found".formatted(id))));
    }

    public CartProductDto create(Long customerId, CartProductDtoCreate dto) {
        CartProductDto cartProductListDto = CartProductDto.builder()
                    .customerId(customerId)
                    .product(productService.getOne(dto.getProductId()))
                    .quantity(dto.getQuantity())
                    .build();
        CartProduct cartProductList = cartProductListMapper.toEntity(cartProductListDto);
        CartProduct resultCartProductList = cartProductRepository.save(cartProductList);
        return cartProductListMapper.toCartProductListDto(resultCartProductList);
    }

    public CartProductDto patch(Long id, JsonNode patchNode) throws IOException {
        CartProduct cartProductList = cartProductRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity with id `%s` not found".formatted(id)));

        CartProductDto cartProductListDto = cartProductListMapper.toCartProductListDto(cartProductList);
        objectMapper.readerForUpdating(cartProductListDto).readValue(patchNode);
        cartProductListMapper.updateWithNull(cartProductListDto, cartProductList);

        CartProduct resultCartProductList = cartProductRepository.save(cartProductList);
        return cartProductListMapper.toCartProductListDto(resultCartProductList);
    }


    public CartProductDto delete(Long id) {
        CartProduct cartProductList = cartProductRepository.findById(id).orElse(null);
        if (cartProductList != null) {
            cartProductRepository.delete(cartProductList);
        }
        return cartProductListMapper.toCartProductListDto(cartProductList);
    }


}
