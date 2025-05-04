package app.services;


import app.dto.OrderDto;
import app.exception.NotFoundException;
import app.mapper.OrderMapper;
import app.model.Order;
import app.repository.OrderProductRepository;
import app.repository.OrderRepository;
import app.services.data.OrderTestData;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(classes = {OrderService.class})
class OrderServiceTest {
    @MockitoBean
    private OrderMapper orderMapper;
    @MockitoBean
    private OrderRepository orderRepository;
    @MockitoBean
    private ObjectMapper objectMapper;
    @MockitoBean
    private OrderProductRepository orderProductRepository;

    @Autowired
    OrderService orderService;

    @Test
    void getAll() {
        Mockito.when(orderRepository.findAll()).thenReturn(OrderTestData.ORDER_LIST);
        Mockito.when(orderMapper.toDtoList(OrderTestData.ORDER_LIST)).thenReturn(OrderTestData.ORDER_DTO_LIST);
        List<OrderDto> result = orderService.getAll();
        assertEquals(OrderTestData.ORDER_DTO_LIST, result);

    }

    @Test
    void getOne() {
        Order order = OrderTestData.ORDER_1;
        order.setId(1L);
        Mockito.when(orderRepository.findById(1L)).thenReturn(Optional.of(order));
        Mockito.when(orderMapper.toDto(order)).thenReturn(OrderTestData.ORDER_DTO_1);
        OrderDto result = orderService.getOne(1L);
        assertEquals(OrderTestData.ORDER_DTO_1, result);
        assertNotEquals(OrderTestData.ORDER_DTO_2, result);
    }
    @Test
    void getOneException() throws NotFoundException{
        Order order = OrderTestData.ORDER_1;
        RuntimeException exception = Assertions.assertThrows(
                RuntimeException.class,
                () -> orderService.getOne(1L));
        assertEquals(exception.getMessage(), "Заказ с id `1` не найден");


    }

    @Test
    void create() {
        Mockito.when(orderMapper.toEntity(OrderTestData.ORDER_DTO_1)).thenReturn(OrderTestData.ORDER_1);
        Mockito.when(orderRepository.save(OrderTestData.ORDER_1)).thenReturn(OrderTestData.ORDER_1);
        Mockito.when(orderMapper.toDto(OrderTestData.ORDER_1)).thenReturn(OrderTestData.ORDER_DTO_1);
        OrderDto result = orderService.create(OrderTestData.ORDER_DTO_1);
        assertEquals(OrderTestData.ORDER_DTO_1, result);
    }

    @Test
    void update() throws NotFoundException {
        Order order = OrderTestData.ORDER_1;
        Mockito.when(orderRepository.findById(1L)).thenReturn(Optional.of(order));
        Mockito.when(orderMapper.toDto(order)).thenReturn(OrderTestData.ORDER_DTO_1);
        Mockito.when(orderRepository.save(order)).thenReturn(order);
        OrderDto result = orderService.update(1L, OrderTestData.ORDER_DTO_1_UPDATE);
        assertEquals(OrderTestData.ORDER_DTO_1_UPDATE.getCustomerId(), result.getCustomerId());
    }

    @Test
    void updateException() throws NotFoundException{
        Order order = OrderTestData.ORDER_1;
        RuntimeException exception = Assertions.assertThrows(
                RuntimeException.class,
                () -> orderService.update(1L, OrderTestData.ORDER_DTO_1_UPDATE));
        assertEquals(exception.getMessage(), "Заказ с id `1` не найден");


    }

    @Test
    void delete() throws NotFoundException{
        Order order = OrderTestData.ORDER_1;
        order.setId(1L);
        Order orderDelete = order;
        orderDelete.setDeleted(true);
        Mockito.when(orderRepository.findById(1L)).thenReturn(Optional.of(order));
        Mockito.when(orderRepository.save(order)).thenReturn(orderDelete);
        String result = orderService.delete(1L);
        assertEquals("Заказ удален", result);
    }

    @Test
    void deleteException() throws NotFoundException{
        Order order = OrderTestData.ORDER_1;
        RuntimeException exception = Assertions.assertThrows(
                RuntimeException.class,
                () -> orderService.delete(order.getId()));
        assertEquals(exception.getMessage(), "Заказ с id `null` не найден");


    }
}