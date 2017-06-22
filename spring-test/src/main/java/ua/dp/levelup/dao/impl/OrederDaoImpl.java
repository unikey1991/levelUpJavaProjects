package ua.dp.levelup.dao.impl;

import ua.dp.levelup.cinema.Order;
import ua.dp.levelup.dao.OrderDao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by unike on 22.06.2017.
 */
public class OrederDaoImpl implements OrderDao {

    Map<Long, Order> orderById = new HashMap<>();


    @Override
    public List<Order> getAllOrders() {
        return (List<Order>) orderById.values();
    }

    @Override
    public Order getOrderById(Long id) {
        return orderById.get(id);
    }

    @Override
    public void createOrder(Order order) {
        orderById.put(order.getId(), order);
    }

    @Override
    public void deleteOrder(Order order) {
        orderById.remove(order.getId());
    }

    @Override
    public void updateOrder(Order order) {
        orderById.put(order.getId(), order);

    }
}
