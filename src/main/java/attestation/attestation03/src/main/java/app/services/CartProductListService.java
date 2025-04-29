package app.services;

import app.dto.CartProductListDto;
import app.dto.CartProductListDtoAdd;
import app.mapper.CartProductListMapper;
import app.model.CartProductList;
import app.repository.CartProductListRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CartProductListService {

    private final CartProductListMapper cartProductListMapper;

    private final CartProductListRepository cartProductListRepository;

    private final ProductService productService;

    private final ObjectMapper objectMapper;

    public List<CartProductListDto> getAll() {
        List<CartProductList> cartProductLists = cartProductListRepository.findAll();
        return cartProductLists.stream()
                .map(cartProductListMapper::toCartProductListDto)
                .toList();
    }

    public CartProductListDto getOne(Long id) {
        Optional<CartProductList> cartProductListOptional = cartProductListRepository.findById(id);
        return cartProductListMapper.toCartProductListDto(cartProductListOptional.orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity with id `%s` not found".formatted(id))));
    }

    public List<CartProductListDto> getMany(List<Long> ids) {
        List<CartProductList> cartProductLists = cartProductListRepository.findAllById(ids);
        return cartProductLists.stream()
                .map(cartProductListMapper::toCartProductListDto)
                .toList();
    }

    public CartProductListDto create(CartProductListDtoAdd dto) {
        CartProductListDto cartProductListDto = CartProductListDto.builder()
                    .customerId(dto.getCustomerId())
                    .product(productService.getOne(dto.getProductId()))
                    .quantity(dto.getQuantity())
                    .build();
        CartProductList cartProductList = cartProductListMapper.toEntity(cartProductListDto);
        CartProductList resultCartProductList = cartProductListRepository.save(cartProductList);
        return cartProductListMapper.toCartProductListDto(resultCartProductList);
    }

    public CartProductListDto patch(Long id, JsonNode patchNode) throws IOException {
        CartProductList cartProductList = cartProductListRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity with id `%s` not found".formatted(id)));

        CartProductListDto cartProductListDto = cartProductListMapper.toCartProductListDto(cartProductList);
        objectMapper.readerForUpdating(cartProductListDto).readValue(patchNode);
        cartProductListMapper.updateWithNull(cartProductListDto, cartProductList);

        CartProductList resultCartProductList = cartProductListRepository.save(cartProductList);
        return cartProductListMapper.toCartProductListDto(resultCartProductList);
    }

    public List<Long> patchMany(List<Long> ids, JsonNode patchNode) throws IOException {
        Collection<CartProductList> cartProductLists = cartProductListRepository.findAllById(ids);

        for (CartProductList cartProductList : cartProductLists) {
            CartProductListDto cartProductListDto = cartProductListMapper.toCartProductListDto(cartProductList);
            objectMapper.readerForUpdating(cartProductListDto).readValue(patchNode);
            cartProductListMapper.updateWithNull(cartProductListDto, cartProductList);
        }

        List<CartProductList> resultCartProductLists = cartProductListRepository.saveAll(cartProductLists);
        return resultCartProductLists.stream()
                .map(CartProductList::getId)
                .toList();
    }

    public CartProductListDto delete(Long id) {
        CartProductList cartProductList = cartProductListRepository.findById(id).orElse(null);
        if (cartProductList != null) {
            cartProductListRepository.delete(cartProductList);
        }
        return cartProductListMapper.toCartProductListDto(cartProductList);
    }

    public void deleteMany(List<Long> ids) {
        cartProductListRepository.deleteAllById(ids);
    }
}
