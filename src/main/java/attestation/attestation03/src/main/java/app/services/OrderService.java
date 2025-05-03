package app.services;

import app.dto.OrderDto;
import app.model.Order;
import app.mapper.OrderMapper;
import app.model.OrderProduct;
import app.repository.OrderProductListRepository;
import app.repository.OrderRepository;
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
public class OrderService {

    private final OrderMapper orderMapper;

    private final OrderRepository orderRepository;

    private final ObjectMapper objectMapper;

    private final OrderProductListRepository orderProductListRepository;

    public List<OrderDto> getAll() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream()
                .map(orderMapper::toOrderDto)
                .toList();
    }

    public OrderDto getOne(Long id) {
        Optional<Order> orderOptional = orderRepository.findById(id);
        return orderMapper.toOrderDto(orderOptional.orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity with id `%s` not found".formatted(id))));
    }

    public List<OrderDto> getMany(List<Long> ids) {
        List<Order> orders = orderRepository.findAllById(ids);
        return orders.stream()
                .map(orderMapper::toOrderDto)
                .toList();
    }

    public OrderDto create(OrderDto dto) {
        Order order = orderMapper.toEntity(dto);
        Order resultOrder = orderRepository.save(order);
        List<OrderProduct> OrderProductList = order.getOrderProductsList();
        OrderProductList.forEach(i -> i.setOrderId(resultOrder.getId()));
        OrderProductList.forEach(orderProductListRepository::save);
        return orderMapper.toOrderDto(resultOrder);
    }

    public OrderDto patch(Long id, JsonNode patchNode) throws IOException {
        Order order = orderRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity with id `%s` not found".formatted(id)));

        OrderDto orderDto = orderMapper.toOrderDto(order);
        objectMapper.readerForUpdating(orderDto).readValue(patchNode);
        orderMapper.updateWithNull(orderDto, order);

        Order resultOrder = orderRepository.save(order);
        return orderMapper.toOrderDto(resultOrder);
    }

    public List<Long> patchMany(List<Long> ids, JsonNode patchNode) throws IOException {
        Collection<Order> orders = orderRepository.findAllById(ids);

        for (Order order : orders) {
            OrderDto orderDto = orderMapper.toOrderDto(order);
            objectMapper.readerForUpdating(orderDto).readValue(patchNode);
            orderMapper.updateWithNull(orderDto, order);
        }

        List<Order> resultOrders = orderRepository.saveAll(orders);
        return resultOrders.stream()
                .map(Order::getId)
                .toList();
    }

    public OrderDto delete(Long id) {
        Order order = orderRepository.findById(id).orElse(null);
        if (order != null) {
            orderRepository.delete(order);
        }
        return orderMapper.toOrderDto(order);
    }

    public void deleteMany(List<Long> ids) {
        orderRepository.deleteAllById(ids);
    }
}
