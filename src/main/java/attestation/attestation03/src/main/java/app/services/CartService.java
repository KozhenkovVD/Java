package app.services;

import app.dto.CartProductDto;
import app.dto.CartProductDtoCreate;
import app.dto.CustomerDto;
import app.dto.ProductDto;
import app.exception.NotFoundException;
import app.mapper.CartProductMapper;
import app.model.CartProduct;
import app.model.Customer;
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

    private final CartProductMapper cartProductMapper;

    private final CartProductRepository cartProductRepository;

    private final ProductService productService;

    private final ObjectMapper objectMapper;

    public List<CartProductDto> getByCustomerId(Long customerId) {
        List<CartProduct> cartProductLists = cartProductRepository.findByCustomerId(customerId);
        return cartProductMapper.toDtoList(cartProductLists);

    }

    public CartProductDto getOne(Long id) {
        Optional<CartProduct> cartProductListOptional = cartProductRepository.findById(id);
        return cartProductMapper.toDto(cartProductListOptional.orElseThrow(() ->
                new NotFoundException("Товар с id `%s` не найден".formatted(id))));
    }

    public CartProductDto create(Long customerId, CartProductDtoCreate dto) {
        ProductDto productDto = productService.getOne(dto.getProductId());
        CartProductDto cartProductDto = new CartProductDto(customerId, productDto, dto.getQuantity());
        CartProduct cartProductList = cartProductMapper.toEntity(cartProductDto);
        CartProduct resultCartProductList = cartProductRepository.save(cartProductList);
        return cartProductMapper.toDto(resultCartProductList);
    }

      public CartProductDto update(Long id, CartProductDto cartProductDto) throws NotFoundException {
        CartProduct cartProduct = cartProductRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Товар с id `%s` не найден".formatted(id)));
        cartProduct.setQuantity(cartProductDto.getQuantity());
        CartProduct resultcartProduct = cartProductRepository.save(cartProduct);
        return cartProductMapper.toDto(resultcartProduct);
    }


    public String delete(Long id) {
        CartProduct cartProduct = cartProductRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Товар с id `%s` не найден".formatted(id)));
        if (cartProduct != null) {
            cartProduct.setDeleted(true);
            cartProductRepository.save(cartProduct);
        }
        return "Товар удален";
    }


}
