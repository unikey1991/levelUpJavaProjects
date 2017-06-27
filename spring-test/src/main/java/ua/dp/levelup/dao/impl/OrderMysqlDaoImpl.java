package ua.dp.levelup.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.dp.levelup.cinema.Order;
import ua.dp.levelup.dao.OrderDao;

import java.util.List;

/**
 * Created by java on 27.06.2017.
 */

@Repository
@Transactional
public class OrderMysqlDaoImpl implements OrderDao {

    @Autowired
    private HibernateTemplate template;

    @Override
    public List<Order> getAllOrders() {
        return template.loadAll(Order.class);
    }

    @Override
    public Order getOrderById(Long id) {
        return template.get(Order.class, id);
    }

    @Override
    public void createOrder(Order order) {
        template.save(order);
    }

    @Override
    public void deleteOrder(Order order) {
        template.delete(order);
    }

    @Override
    public void updateOrder(Order order) {
        template.update(order);
    }
}
