package app.mapper;

import app.dto.CartProductDto;
import app.model.CartProduct;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CartProductListMapper {
    CartProduct toEntity(CartProductDto cartProductListDto);

    CartProductDto toCartProductListDto(CartProduct cartProductList);

    CartProduct updateWithNull(CartProductDto cartProductListDto, @MappingTarget CartProduct cartProductList);
}