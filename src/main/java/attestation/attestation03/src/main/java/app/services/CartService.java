package app.services;

import app.dto.CartProductDto;
import app.dto.CartProductDtoCreate;
import app.dto.ProductDto;
import app.mapper.CartProductMapper;
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
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity with id `%s` not found".formatted(id))));
    }

    public CartProductDto create(Long customerId, CartProductDtoCreate dto) {
        ProductDto productDto = productService.getOne(dto.getProductId());
        CartProductDto cartProductDto = new CartProductDto(customerId, productDto, dto.getQuantity());
        CartProduct cartProductList = cartProductMapper.toEntity(cartProductDto);
        CartProduct resultCartProductList = cartProductRepository.save(cartProductList);
        return cartProductMapper.toDto(resultCartProductList);
    }

    public CartProductDto patch(Long id, JsonNode patchNode) throws IOException {
        CartProduct cartProductList = cartProductRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity with id `%s` not found".formatted(id)));

        CartProductDto cartProductListDto = cartProductMapper.toDto(cartProductList);
        objectMapper.readerForUpdating(cartProductListDto).readValue(patchNode);
        cartProductMapper.updateWithNull(cartProductListDto, cartProductList);

        CartProduct resultCartProductList = cartProductRepository.save(cartProductList);
        return cartProductMapper.toDto(resultCartProductList);
    }


    public CartProductDto delete(Long id) {
        CartProduct cartProductList = cartProductRepository.findById(id).orElse(null);
        if (cartProductList != null) {
            cartProductRepository.delete(cartProductList);
        }
        return cartProductMapper.toDto(cartProductList);
    }


}
