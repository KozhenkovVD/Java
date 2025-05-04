package app.services;

import app.dto.OrderDto;
import app.exception.NotFoundException;
import app.model.Order;
import app.mapper.OrderMapper;
import app.model.OrderProduct;
import app.model.Product;
import app.repository.OrderProductRepository;
import app.repository.OrderRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderMapper orderMapper;

    private final OrderRepository orderRepository;

    private final OrderProductRepository orderProductRepository;

    public List<OrderDto> getAll() {
        List<Order> orders = orderRepository.findAll();
        return orderMapper.toDtoList(orders);
    }

    public OrderDto getOne(Long id) throws NotFoundException {
        Optional<Order> orderOptional = orderRepository.findById(id);
        return orderMapper.toDto(orderOptional.orElseThrow(() ->
                new NotFoundException("Заказ с id `%s` не найден".formatted(id))));
    }


    public OrderDto create(OrderDto dto) {
        Order order = orderMapper.toEntity(dto);
        Order resultOrder = orderRepository.save(order);
        List<OrderProduct> OrderProductList = order.getOrderProductsList();
        OrderProductList.forEach(i -> i.setOrderId(resultOrder.getId()));
        OrderProductList.forEach(orderProductRepository::save);
        return orderMapper.toDto(resultOrder);
    }

    public OrderDto update(Long id, OrderDto orderDto) throws NotFoundException {
        Order order = orderRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Заказ с id `%s` не найден".formatted(id)));
        order.setCustomerId(orderDto.getCustomerId());
        order.setOrderDate(orderDto.getOrderDate());
        Order resultOrder = orderRepository.save(order);
        return orderMapper.toDto(resultOrder);
    }



    public String delete(Long id) {
        Order order = orderRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Заказ с id `%s` не найден".formatted(id)));
        if (order != null) {
            order.setDeleted(true);
            orderRepository.save(order);
        }
        return "Заказ удален";
    }

}
