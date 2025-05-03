package app.mapper;

import app.dto.OrderDto;
import app.dto.ProductDto;
import app.model.Order;
import app.model.Product;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderMapper {
    Order toEntity(OrderDto orderDto);
    OrderDto toDto(Order order);
    List<OrderDto> toDtoList(List<Order> orders);
}