package app.mapper;

import app.dto.CustomerDto;
import app.dto.OrderDto;
import app.model.Customer;
import app.model.Order;
import app.services.data.CustomerTestData;
import app.services.data.OrderTestData;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = {OrderMapperImpl.class})
class OrderMapperTest {

@Autowired
private OrderMapper orderMapper;


    @Test
    void toEntity() {
        Order orderExpected = OrderTestData.ORDER_1;
        Order order = orderMapper.toEntity(OrderTestData.ORDER_DTO_1);
        assertEquals(orderExpected.getCustomerId(),order.getCustomerId());
    }

    @Test
    void toDto() {
        OrderDto orderDtoExpected = OrderTestData.ORDER_DTO_1;
        OrderDto orderDto = orderMapper.toDto(OrderTestData.ORDER_1);
        assertEquals(orderDtoExpected.getCustomerId(),orderDto.getCustomerId());
    }

    @Test
    void toDtoList() {
        List<OrderDto> ordertDtoListExpected = OrderTestData.ORDER_DTO_LIST;
        List<OrderDto>  orderDtoList = orderMapper.toDtoList(OrderTestData.ORDER_LIST);
        assertEquals(ordertDtoListExpected.size(),orderDtoList.size());
    }
}