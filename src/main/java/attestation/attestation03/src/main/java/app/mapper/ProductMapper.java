package app.mapper;

import app.dto.ProductDto;
import app.dto.ProductDtoV2;
import app.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductMapper {
    Product toEntity(ProductDto productDto);

    ProductDto toProductDto(Product product);
    ProductDtoV2 toProductDtoV2 (Product product);
    Product updateWithNull(ProductDto productDto, @MappingTarget Product product);
}