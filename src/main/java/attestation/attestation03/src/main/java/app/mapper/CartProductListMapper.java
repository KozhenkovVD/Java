package app.mapper;

import app.dto.CartProductListDto;
import app.model.CartProductList;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CartProductListMapper {
    CartProductList toEntity(CartProductListDto cartProductListDto);

    CartProductListDto toCartProductListDto(CartProductList cartProductList);

    CartProductList updateWithNull(CartProductListDto cartProductListDto, @MappingTarget CartProductList cartProductList);
}