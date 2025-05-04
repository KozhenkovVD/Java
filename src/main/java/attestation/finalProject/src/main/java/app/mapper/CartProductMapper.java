package app.mapper;

import app.dto.CartProductDto;
import app.model.CartProduct;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CartProductMapper {
    CartProduct toEntity(CartProductDto cartProductListDto);
    CartProductDto toDto(CartProduct cartProductList);
    List<CartProductDto> toDtoList(List<CartProduct> cartProductList);
}