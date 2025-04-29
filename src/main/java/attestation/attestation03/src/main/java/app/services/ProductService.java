package app.services;

import app.dto.ProductDto;
import app.dto.ProductDtoV2;
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

    private final ObjectMapper objectMapper;

    public List<ProductDtoV2> getAll() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(productMapper::toProductDtoV2)
                .toList();
    }

    public ProductDto getOne(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        return productMapper.toProductDto(productOptional.orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity with id `%s` not found".formatted(id))));
    }

    public List<ProductDto> getMany(List<Long> ids) {
        List<Product> products = productRepository.findAllById(ids);
        return products.stream()
                .map(productMapper::toProductDto)
                .toList();
    }

    public ProductDto create(ProductDto dto) {
        Product product = productMapper.toEntity(dto);
        Product resultProduct = productRepository.save(product);
        return productMapper.toProductDto(resultProduct);
    }

    public List<ProductDto> createList(List<ProductDto> dtos) {
        dtos.forEach(dto -> {
            Product product = productMapper.toEntity(dto);
            System.out.println(product);
            Product resultProduct = productRepository.save(product);});

        return dtos;
    }

    public ProductDto patch(Long id, JsonNode patchNode) throws IOException {
        Product product = productRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity with id `%s` not found".formatted(id)));

        ProductDto productDto = productMapper.toProductDto(product);
        objectMapper.readerForUpdating(productDto).readValue(patchNode);
        productMapper.updateWithNull(productDto, product);

        Product resultProduct = productRepository.save(product);
        return productMapper.toProductDto(resultProduct);
    }

    public List<Long> patchMany(List<Long> ids, JsonNode patchNode) throws IOException {
        Collection<Product> products = productRepository.findAllById(ids);

        for (Product product : products) {
            ProductDto productDto = productMapper.toProductDto(product);
            objectMapper.readerForUpdating(productDto).readValue(patchNode);
            productMapper.updateWithNull(productDto, product);
        }

        List<Product> resultProducts = productRepository.saveAll(products);
        return resultProducts.stream()
                .map(Product::getId)
                .toList();
    }

    public ProductDto delete(Long id) {
        Product product = productRepository.findById(id).orElse(null);
        if (product != null) {
            productRepository.delete(product);
        }
        return productMapper.toProductDto(product);
    }

    public void deleteMany(List<Long> ids) {
        productRepository.deleteAllById(ids);
    }
}
