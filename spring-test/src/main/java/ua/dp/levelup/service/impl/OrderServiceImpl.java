package ua.dp.levelup.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.dp.levelup.cinema.Order;
import ua.dp.levelup.cinema.Ticket;
import ua.dp.levelup.dao.OrderDao;
import ua.dp.levelup.dao.TicketDao;
import ua.dp.levelup.service.OrderService;

import java.util.List;

/**
 * Created by java on 27.06.2017.
 */

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDao orderDao;

    @Autowired
    TicketDao ticketDao;


    @Override
    public List<Order> getAllOrders() {
        return orderDao.getAllOrders();
    }

    @Override
    public Order getOrderById(Long id) {
        return orderDao.getOrderById(id);
    }

    @Override
    public void createOrder(Order order) {
        orderDao.createOrder(order);
        List<Ticket> tickets = order.getTickets();
        for (Ticket t: tickets){
            t.setOrder(order);
            ticketDao.updateTicket(t);
        }
    }

    @Override
    public void deleteOrder(Order order) {
        orderDao.createOrder(order);
    }

    @Override
    public void updateOrder(Order order) {
        orderDao.updateOrder(order);
    }
}
