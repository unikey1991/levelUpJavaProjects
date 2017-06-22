package ua.dp.levelup.dao;

import ua.dp.levelup.cinema.Order;

import java.util.List;

/**
 * Created by unike on 22.06.2017.
 */
public interface OrderDao {

    List<Order> getAllOrders();

    Order getOrderById(Long id);

    void createOrder(Order order);

    void deleteOrder(Order order);

    void updateOrder(Order order);
}
