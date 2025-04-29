package app.mapper;

import app.dto.OrderDto;
import app.model.Order;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderMapper {
    Order toEntity(OrderDto orderDto);

//    @AfterMapping
//    default void linkOrderProductsList(@MappingTarget Order order) {
//        order.getOrderProductsList().forEach(orderProductsList -> orderProductsList.setOrderId(order));
//    }

    OrderDto toOrderDto(Order order);

    Order updateWithNull(OrderDto orderDto, @MappingTarget Order order);
}