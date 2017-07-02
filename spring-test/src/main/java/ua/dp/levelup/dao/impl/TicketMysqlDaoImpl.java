package ua.dp.levelup.dao.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.dp.levelup.cinema.Ticket;
import ua.dp.levelup.dao.TicketDao;

import java.util.List;

/**
 * Created by unike on 02.07.2017.
 */

@Transactional
@Repository
public class TicketMysqlDaoImpl implements TicketDao {

    @Autowired
    private HibernateTemplate template;

    @Override
    public void createTicket(Ticket ticket) {
        template.save(ticket);
    }

    @Override
    public void updateTicket(Ticket ticket) {
        template.update(ticket);
    }

    @Override
    public List<Ticket> getAllOrders() {
        return template.loadAll(Ticket.class);
    }
}
