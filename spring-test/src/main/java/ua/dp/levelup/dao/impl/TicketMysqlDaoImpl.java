package ua.dp.levelup.dao.impl;


import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.dp.levelup.cinema.Ticket;
import ua.dp.levelup.dao.TicketDao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by unike on 02.07.2017.
 */

@Transactional
@Repository("ticketDao")
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
    public List<Ticket> getAllTickets() {
        return template.loadAll(Ticket.class);
    }

    @Override
    public List<Ticket> getTicketsOfMovieSession(Long sessionId) {

        List<Ticket> allTickets = getAllTickets();
        List<Ticket> ticketsOfMovieSession = new ArrayList<>();

        for (Ticket t: allTickets){
            if (t.getMovieSessionId() == sessionId){
                ticketsOfMovieSession.add(t);
            }
        }
        return ticketsOfMovieSession;
    }


}
