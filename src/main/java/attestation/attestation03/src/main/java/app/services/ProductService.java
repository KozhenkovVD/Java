package app.services;

import app.dto.ProductDto;
import app.dto.ProductDtoV2;
import app.exception.NotFoundException;
import app.mapper.ProductMapper;
import app.model.Product;
import app.repository.ProductRepository;
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
public class ProductService {

    private final ProductMapper productMapper;

    private final ProductRepository productRepository;

    public List<ProductDto> getAll() {
        List<Product> products = productRepository.findAll();
        return productMapper.toDtoList(products);
    }

    public ProductDto getOne(Long id) throws NotFoundException {
        Optional<Product> productOptional = productRepository.findById(id);
        return productMapper.toDto(productOptional.orElseThrow(() ->
                new NotFoundException("Продукт с id `%s` не найден".formatted(id))));
    }

    public ProductDto create(ProductDto dto) {
        Product product = productMapper.toEntity(dto);
        Product resultProduct = productRepository.save(product);
        return productMapper.toDto(resultProduct);
    }

public ProductDto update(Long id, ProductDto  productDto) throws NotFoundException {
    Product product = productRepository.findById(id).orElseThrow(() ->
            new NotFoundException("Продукт с id `%s` не найден".formatted(id)));
    product.setName(productDto.getName());
    product.setType(productDto.getType());
    product.setPrice(productDto.getPrice());
    Product resultProduct = productRepository.save(product);

    return productMapper.toDto(resultProduct);
}


    public String delete(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Продукт с id `%s` не найден".formatted(id)));
        if (product != null) {
            product.setDeleted(true);
            productRepository.save(product);
        }
        return "Продукт удален";
    }

}
