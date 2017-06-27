package ua.dp.levelup.service;

import ua.dp.levelup.cinema.Order;

import java.util.List;

/**
 * Created by java on 27.06.2017.
 */
public interface OrderService {

    List<Order> getAllOrders();

    Order getOrderById(Long id);

    void createOrder(Order order);

    void deleteOrder(Order order);

    void updateOrder(Order order);
}
